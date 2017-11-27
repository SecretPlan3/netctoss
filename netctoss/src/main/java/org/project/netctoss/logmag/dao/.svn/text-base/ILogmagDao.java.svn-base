package org.project.netctoss.logmag.dao;

import java.util.List;

import org.project.netctoss.beans.ManagerLogBean;

public interface ILogmagDao {
	/**
	 * 查询管理员操作日志
	 * @param managerLogBean
	 * @return
	 */
	public List<ManagerLogBean> findAllManagerLog(ManagerLogBean managerLogBean);
	
	/**
	 * 查询管理员登陆时间/退出时间（通过管理员）
	 * @param managerLogBean
	 * @return
	 */
	public ManagerLogBean selectManagerLog(ManagerLogBean managerLogBean);
	/**
	 * 分页查询/模糊查询
	 * @return
	 */
	public List<ManagerLogBean> findAllManagerLogByPage();
}
