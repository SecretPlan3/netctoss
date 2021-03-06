package org.project.netctoss.servicemag.service.impl;

import javax.annotation.Resource;

import org.project.netctoss.beans.ServiceMonthlyBean;
import org.project.netctoss.servicemag.dao.IServiceMonthlyDao;
import org.project.netctoss.servicemag.service.IServiceMonthlyService;
import org.springframework.stereotype.Service;

@Service
public class ServiceMonthlyServiceImpl implements IServiceMonthlyService {
	@Resource
	IServiceMonthlyDao serviceMonthlyDaoImpl;

	@Override
	public void saveServiceMonthlyBean(ServiceMonthlyBean sd) {
		// TODO Auto-generated method stub
		serviceMonthlyDaoImpl.saveServiceMonthlyBean(sd);
	}

	@Override
	public void deleteServiceMonthlyBean(ServiceMonthlyBean sd) {
		// TODO Auto-generated method stub
		serviceMonthlyDaoImpl.deleteServiceMonthlyBean(sd);
	}

	@Override
	public void updateServiceMonthlyBean(ServiceMonthlyBean sd) {
		// TODO Auto-generated method stub
		serviceMonthlyDaoImpl.updateServiceMonthlyBean(sd);
	}

	@Override
	public ServiceMonthlyBean getServiceMonthlyBeanByID(Long ID) {
		// TODO Auto-generated method stub
		return serviceMonthlyDaoImpl.getServiceMonthlyBeanByID(ID);
	}

	@Override
	public ServiceMonthlyBean getServiceMonthlyBeanByMonthAndServiceAndYear(String month,String osName,String year) {
		// TODO Auto-generated method stub
		return serviceMonthlyDaoImpl.getServiceMonthlyBeanByMonthAndServiceAndYear(month, osName, year);
	}

}
