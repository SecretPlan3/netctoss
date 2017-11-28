package org.project.netctoss.usermag.service.serviceImpl;

import javax.annotation.Resource;

import org.project.netctoss.beans.UserBean;
import org.project.netctoss.pojos.PagerBean;
import org.project.netctoss.usermag.dao.UserDao;
import org.project.netctoss.usermag.service.UserService;
import org.project.netctoss.utils.BaseDao;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl extends BaseDao implements UserService {
	@Resource
	private UserDao UserDaoImpl;
	
	public UserBean findUserById(Long id) {
		// TODO Auto-generated method stub
		return UserDaoImpl.findUserById(id);
	}

	public void deleteUserById(UserBean user) {
		// TODO Auto-generated method stub  
		UserDaoImpl.deleteUserById(user);
	}

	public void addUser(UserBean user) {
		// TODO Auto-generated method stub
		UserDaoImpl.addUser(user);
	}

	public void updateUser(UserBean user) {
		// TODO Auto-generated method stub
		UserDaoImpl.updateUser(user);
	}
	
	public PagerBean findUserByPager(PagerBean pager) {
		// TODO Auto-generated method stub
		return UserDaoImpl.findUserByPager(pager);
	}

	public UserBean findUserByLoginNameAndPassword(String loginName,String passWord) {
		// TODO Auto-generated method stub
		return UserDaoImpl.findUserByLoginNameAndPassword(loginName,passWord);
	}
	
	public UserBean findUserByLoginName(String LoginName) {
		// TODO Auto-generated method stub
		return UserDaoImpl.findUserByLoginName(LoginName);
	}
	
}
