package org.project.netctoss.servicemag.service.impl;


import javax.annotation.Resource;

import org.project.netctoss.beans.ServiceYearlyBean;
import org.project.netctoss.servicemag.dao.IServiceYearlyDao;
import org.project.netctoss.servicemag.service.IServiceYearlyService;
import org.springframework.stereotype.Service;
@Service
public class ServiceYearlyServiceImpl implements IServiceYearlyService {
@Resource 
 IServiceYearlyDao serviceYearlyDao;
	@Override
	public void saveServiceYearlyBean(ServiceYearlyBean sd) {
		// TODO Auto-generated method stub
		serviceYearlyDao.saveServiceYearlyBean(sd);
	}
 
	@Override
	public void deleteServiceYearlyBean(ServiceYearlyBean sd) {
		// TODO Auto-generated method stub
		serviceYearlyDao.deleteServiceYearlyBean(sd);
	}

	@Override
	public void updateServiceYearlyBean(ServiceYearlyBean sd) {
		// TODO Auto-generated method stub
		serviceYearlyDao.updateServiceYearlyBean(sd);
	}

	@Override
	public ServiceYearlyBean getServiceYearlyBeanByID(Long ID) {
		// TODO Auto-generated method stub
		return serviceYearlyDao.getServiceYearlyBeanByID(ID);
	}

	@Override
	public ServiceYearlyBean getServiceYearlyBeanByYearAndService(String year,String osName) {
		// TODO Auto-generated method stub
		return serviceYearlyDao.getServiceYearlyBeanByYearAndService(year,osName);
	}

}
