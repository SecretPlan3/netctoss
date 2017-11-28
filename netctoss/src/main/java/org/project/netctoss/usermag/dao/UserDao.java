package org.project.netctoss.usermag.dao;

import org.project.netctoss.beans.UserBean;
import org.project.netctoss.pojos.PagerBean;

public interface UserDao {
	public UserBean findUserById(Long id);
	
	public void deleteUserById(UserBean user);
	
	public void addUser(UserBean user);
	
	public void updateUser(UserBean user); 
	
	
	public PagerBean findUserByPager(PagerBean pager);

	public UserBean findUserByLoginNameAndPassword(String loginName,String passWord);
	
	public UserBean findUserByLoginName(String LoginName);
}	

