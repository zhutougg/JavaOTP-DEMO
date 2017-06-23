package com.zhutougg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhutougg.entity.Authlog;
import com.zhutougg.entity.Secret;
import com.zhutougg.utils.DBUtils;
import com.zhutougg.utils.GoogleAuthenticator;

public class OTPAction extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String secret = GoogleAuthenticator.genSecret(username);
		System.out.println(secret);
		request.setAttribute("otp", "otpauth://totp/" + username + "?secret="+ secret);
		request.getRequestDispatcher("/qrcode.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String username = request.getParameter("username");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		if (type.equals("add")) {// 注册时执行
			String result = SecretOpera.addSecret(request);
			out.write("{\"result\":\"" + result + "\"}");
		}else if(type.equals("delete")){
			String result = SecretOpera.deleteSecret(request);
			out.write("{\"result\":\"" + result + "\"}");
		}else if (type.equals("check")) {
			Boolean result = SecretOpera.checkSecret(request);
			out.write("{\"result\":\""+result+"\"}");
		}
	}
}
