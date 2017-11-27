package org.project.netctoss.usermag.service;

import org.project.netctoss.beans.UserBean;
import org.project.netctoss.pojos.PagerBean;

public interface UserService {
	public UserBean findUserById(Long id);
	
	public Long deleteUserById(Long id);
	
	public void addUser(UserBean user);
	
	public void updateUser(UserBean user);
	
	public PagerBean findUserByPager(PagerBean pager);

	public UserBean findUserByLoginNameAndPassword(UserBean user);
	
	public UserBean findUserByLoginName(String LoginName);
}	
