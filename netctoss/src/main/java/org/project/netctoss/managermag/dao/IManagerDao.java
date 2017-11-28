package org.project.netctoss.managermag.dao;


import org.project.netctoss.beans.ManagerBean;
import org.project.netctoss.pojos.PagerBean;

public interface IManagerDao {

	/**
	 * 添加或者修改一个实体管理员
	 * @param manegerbean
	 */
	public void addOrUpdateManeger(ManagerBean managerbean);
	
	
	/**
	 * 根据id删除一个管理员
	 * @param id
	 */
	public void deleteManegerById(ManagerBean managerbean);
	
	
	/**
	 * 根据id查看一个管理员的具体信息
	 * @param id
	 * @return
	 */
	public ManagerBean selectManegerById(Long id);
	
	/**
	 * 根据登录名查询管理员
	 * @param loginName
	 * @return
	 */
	public ManagerBean findManagerByLoginName(String loginName);
	
	/**
	 * 根据登录名和密码查询管理员
	 * @param loginName
	 * @param password
	 * @return
	 */
	public ManagerBean findManagerByLoginNameAndPassword(String loginName,String password);
	
	
	/**
	 * 分页+模糊查询
	 * @return
	 */
	public PagerBean findAllManagersByPager(PagerBean pager);
}
