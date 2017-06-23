package com.zhutougg.utils;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.zhutougg.entity.Authlog;
import com.zhutougg.entity.Secret;

public class DBUtils {

		static Configuration configure = new Configuration().configure();
		static SessionFactory sessionFactory = configure.buildSessionFactory();
	
	public static void save(String username, String seckey) {
		System.out.println("seckey:" + seckey);
		Session session = sessionFactory.openSession();
		Secret sec = new Secret();
		sec.setUsername(username);
		sec.setSeckey(seckey);
		sec.setCreateTime(new Date());
		session.save(sec);
		Transaction tx = session.beginTransaction();
		tx.commit();
		session.close();
	}

	public static Secret getSecret(String username) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Secret where username=?");
		query.setParameter(0, username);
		Secret secret = null;
		if(query.list().size()!=0){
			secret = (Secret) query.list().get(0);
		}
		Transaction tx = session.beginTransaction();
		tx.commit();
		session.close();
		return secret;
	}
	
	public static void addauthLog(Authlog authlog){
		Session session = sessionFactory.openSession();
		session.save(authlog);
		Transaction tx = session.beginTransaction();
		tx.commit();
		session.close();
	}

	public static void lock(Secret secret) {
		Session session = sessionFactory.openSession();
		secret.setUserStatus(1);
		session.update(secret);
		Transaction tx = session.beginTransaction();
		tx.commit();
		session.close();
	}
	
	public static void delete(Secret secret){
		Session session = sessionFactory.openSession();
		session.delete(secret);
		Transaction tx = session.beginTransaction();
		tx.commit();
		session.close();
	}

}
