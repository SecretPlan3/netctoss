package org.project.netctoss.servicemag.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.project.netctoss.beans.ServiceDailyBean;
import org.project.netctoss.servicemag.dao.IServiceDailyDao;
import org.project.netctoss.servicemag.service.IServiceDailyService;
import org.springframework.stereotype.Service;

@Service
public class ServiceDailyServiceImpl implements IServiceDailyService {
	@Resource
	IServiceDailyDao serviceDailyDaoImpl;

	@Override
	public void saveServiceDailyBean(ServiceDailyBean sd) {
		// TODO Auto-generated method stub
		serviceDailyDaoImpl.saveServiceDailyBean(sd);
	}

	@Override
	public void deleteServiceDailyBean(ServiceDailyBean sd) {
		// TODO Auto-generated method stub
		serviceDailyDaoImpl.deleteServiceDailyBean(sd);
	}

	@Override
	public void updateServiceDailyBean(ServiceDailyBean sd) {
		// TODO Auto-generated method stub
		serviceDailyDaoImpl.updateServiceDailyBean(sd);
	}
	@Override
	public ServiceDailyBean getServiceDailyBeanByID(Long ID) {
		// TODO Auto-generated method stub
		return serviceDailyDaoImpl.getServiceDailyBeanByID(ID);
	}

	@Override
	public ServiceDailyBean getServiceDailyBeanByLoginDate(Date loginDate) {
		// TODO Auto-generated method stub
	
		return serviceDailyDaoImpl.getServiceDailyBeanByLoginDate(loginDate);
	}

}
