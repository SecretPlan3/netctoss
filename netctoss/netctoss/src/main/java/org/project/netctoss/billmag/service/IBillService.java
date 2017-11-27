package org.project.netctoss.billmag.service;

import org.project.netctoss.pojos.PagerBean;

public interface IBillService {
	
	/**
	 * 找到所有账务账单，按年月查询，参数：年份；月份；账务账号；用户名；身份证
	 * @param page
	 * @return
	 */
	public PagerBean findAllUserBillByCondition(PagerBean page);
	
	/**
	 * 找到某账务账号的所有业务账号账单，按年月查询
	 * @param page
	 * @return
	 */
	public PagerBean findAllServiceBillByCondition(PagerBean page);
	
	/**
	 * 找到某业务账号的这个月所有时间段使用账单，按年月查询
	 * @param page
	 * @return
	 */
	public PagerBean findAllServiceTimeBillByCondition(PagerBean page);
	
}
