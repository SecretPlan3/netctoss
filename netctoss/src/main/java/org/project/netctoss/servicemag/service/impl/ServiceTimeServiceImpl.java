package org.project.netctoss.servicemag.service.impl;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.project.netctoss.servicemag.dao.IServiceTimeDao;
import org.project.netctoss.servicemag.service.IServiceTimeService;
import org.springframework.stereotype.Service;

@Service
public class ServiceTimeServiceImpl implements IServiceTimeService {
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
	public List<Map<String, String>> findAllOsName(String beginTime) {
		// TODO Auto-generated method stub
		return serviceTimeDaoImpl.findAllOsName(beginTime);
	}

	
}
