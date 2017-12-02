package org.project.netctoss.usermag.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.project.netctoss.beans.UserBean;
import org.project.netctoss.pojos.PagerBean;
import org.project.netctoss.usermag.dao.IUserDao;
import org.project.netctoss.usermag.service.IUserService;
import org.project.netctoss.utils.BaseDao;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl extends BaseDao implements IUserService {
	@Resource
	private IUserDao userDaoImpl;
	
	public UserBean findUserById(Long id) {
		// TODO Auto-generated method stub
		return userDaoImpl.findUserById(id);
	}

	public void deleteUserById(UserBean user) {
		// TODO Auto-generated method stub
		UserBean user1 = findUserById(user.getUserId());//根据id查的持久化对象
		user1.setStatus(user.getStatus());//对持久化对象做修改
		userDaoImpl.updateUser(user1);//点击删除以后，直接将状态栏修改为关闭。
	}

	public void addUser(UserBean user) {
		// TODO Auto-generated method stub 
		userDaoImpl.addUser(user);
	}

	public void updateUser(UserBean user) {
		// TODO Auto-generated method stub
		userDaoImpl.updateUser(user);
	}
	
	public PagerBean findUserByPager(PagerBean pager) {
		// TODO Auto-generated method stub
		return userDaoImpl.findUserByPager(pager);
	}

	public UserBean findUserByLoginNameAndPassword(String loginName,String passWord) {
		// TODO Auto-generated method stub
		return userDaoImpl.findUserByLoginNameAndPassword(loginName,passWord);
	}
	
	public UserBean findUserByLoginName(String LoginName) {
		// TODO Auto-generated method stub
		return userDaoImpl.findUserByLoginName(LoginName);
	}

	@Override
	public void addUsersById(Set<UserBean> users) {
		// TODO Auto-generated method stub
		
	}
	
}
