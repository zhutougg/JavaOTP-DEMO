package com.zhutougg.junit;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import com.zhutougg.entity.Secret;


public class APP {

	@Test
	public void testLocked(){
		Configuration configure = new Configuration().configure();
		SessionFactory sessionFactory = configure.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Secret secret = new Secret();
		secret.setUsername("demo");
		secret.setUserStatus(1);
		session.saveOrUpdate(session);
	}
}
