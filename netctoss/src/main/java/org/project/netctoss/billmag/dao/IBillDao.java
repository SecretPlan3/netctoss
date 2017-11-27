package org.project.netctoss.billmag.dao;

import org.project.netctoss.pojos.PagerBean;

public interface IBillDao {

	
	/**
	 * 账单查询
	 * 找到所有账务账单，按年月查询，参数：年份；月份；账务账号；用户名；身份证
	 * 年份；月份的时间参数形式'2017-10'，级联UserBean
	 * 查询表：t_UserMonthlyCost
	 * PagerBean：BillBean：List
	 * @param page
	 * @return
	 */
	public PagerBean findAllUserBillByCondition(PagerBean page);
	 
	
	/**
	 * 找到某账务账号的所有业务账号账单，按年月查询,参数：UserBean；年份；月份；天
	 * 查询表：
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
