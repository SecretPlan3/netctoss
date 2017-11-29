package org.project.netctoss.servicemag.service.impl;

import javax.annotation.Resource;

import org.project.netctoss.servicemag.dao.IServiceTimeDao;
import org.project.netctoss.utils.BaseDao;
import org.springframework.stereotype.Service;

@Service
public class ServiceTimeServiceImpl implements IServiceTimeDao {
	@Resource
	IServiceTimeDao serviceTimeDaoImpl;
	/**
	 * 将unix服务器传来的ServiceTime表解析后转化为ServiceDailyBean存入数据库
	 */
	@Override
	public void saveAsDailyService() {
		// TODO Auto-generated method stub
		 serviceTimeDaoImpl.saveAsDailyService();

	};

	@Override
	public void saveAsMonthlyService() {
		// TODO Auto-generated method stub
		 serviceTimeDaoImpl.saveAsMonthlyService();
	}

	@Override
	public void saveAsYearlyService() {
		// TODO Auto-generated method stub
		 serviceTimeDaoImpl.saveAsYearlyService();
	}

}
