package org.project.netctoss.utils;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class BaseDao {
	
	@Resource
	private SessionFactory sf;
	
	public Session getSession() {
		return sf.getCurrentSession();
	}
}
