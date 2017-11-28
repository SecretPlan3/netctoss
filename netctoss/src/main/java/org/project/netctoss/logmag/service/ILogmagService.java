package org.project.netctoss.logmag.service;

import org.project.netctoss.pojos.PagerBean;

public interface ILogmagService {
	/**
	 * 通过管理员名字，查询管理员登陆/退出系统时间(分页查询)
	 * @param pagerBean
	 * @return
	 */
	public PagerBean findManagerLog(PagerBean pagerBean);
	/**
	 * 查询管理员在线操作信息
	 * @param pagerBean
	 * @return
	 */
	public PagerBean findManagerOperationLog(PagerBean pagerBean);
}
