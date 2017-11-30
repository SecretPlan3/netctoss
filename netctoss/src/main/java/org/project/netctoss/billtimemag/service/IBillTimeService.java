package org.project.netctoss.billtimemag.service;

import org.project.netctoss.pojos.PagerBean;


public interface IBillTimeService {
	
	
	/**
	 * 按条件分页查询 所有的 账务账号  总览
	 * @return PagerBean
	 */
	
	public PagerBean findAllUsersBillTimeByCondition(PagerBean page);
	
	/**
	 * 按条件分页查询 一个账务账号下 所有的 业务账号 时长 总览
	 * @return PagerBean
	 */
	public PagerBean findAllServicesBillTimeByCondition(PagerBean page);
	

}
