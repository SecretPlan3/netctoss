package org.project.netctoss.usermag.service.serviceImpl;

import org.project.netctoss.beans.UserBean;
import org.project.netctoss.pojos.PagerBean;
import org.project.netctoss.usermag.service.UserService;
import org.project.netctoss.utils.BaseDao;

public class UserServiceImpl extends BaseDao implements UserService {

	public UserBean findUserById(Long id) {
		// TODO Auto-generated method stub
		return (UserBean)getSession().get(UserBean.class, id);
	}

	public void deleteUserById(UserBean user) {
		// TODO Auto-generated method stub
		getSession().delete(user);
	}

	public void addUser(UserBean user) {
		// TODO Auto-generated method stub
		 getSession().save(user);
	}

	public void updateUser(UserBean user) {
		// TODO Auto-generated method stub
		getSession().save(user);
	}
	
	public PagerBean findUserByPager(PagerBean pager) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long deleteUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserBean findUserByLoginNameAndPassword(UserBean user) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserBean findUserByLoginName(String LoginName) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
