package com.zhutougg.servlet;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import com.zhutougg.entity.Authlog;
import com.zhutougg.entity.Secret;
import com.zhutougg.utils.DBUtils;
import com.zhutougg.utils.GoogleAuthenticator;

public class SecretOpera {

	public static String addSecret(HttpServletRequest request){
		String username = request.getParameter("username");
		Secret sec = DBUtils.getSecret(username);
		String url = "添加失败";
		if(sec == null){
			String secret = GoogleAuthenticator.genSecret(username);
			DBUtils.save(username, secret);
			url = "otpauth://totp/"+username+"?secret="+secret;
		}
		return url;
	}
	
	public static String deleteSecret(HttpServletRequest request){
		String username = request.getParameter("username");
		Secret secret = DBUtils.getSecret(username);
		String result = "删除失败";
		if(secret != null){
			DBUtils.delete(secret);
			result = "删除成功";
		}
		return result;
		
	}
	
	public static Boolean checkSecret(HttpServletRequest request){
		String username = request.getParameter("username");
		String code = request.getParameter("code");
		Secret secret = DBUtils.getSecret(username);
		if(secret != null){
			Authlog authlog = new Authlog();
			authlog.setUsername(username);
			authlog.setAuthTime(new Date());
			authlog.setIpaddr(request.getRemoteAddr());
			
			Boolean bool = GoogleAuthenticator.authcode(code,secret.getSeckey());
			DBUtils.addauthLog(authlog);
			return bool;
		}
		return false;
		
		
	}
}
