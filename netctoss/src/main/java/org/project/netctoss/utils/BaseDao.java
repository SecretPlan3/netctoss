package org.project.netctoss.utils;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class BaseDao {
	
	@Resource
	private SessionFactory sf;
	
	private static ThreadLocal<Session> thread = new ThreadLocal<Session>();
	
//	public Session getSession() {
//		return sf.getCurrentSession();
//	}
	
	public Session getSession() {
		Session session = thread.get();
		if(session == null) {
			session = sf.openSession();
			thread.set(session);
		}
		return session;
	}
}
