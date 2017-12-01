package org.project.netctoss.servicemag.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.project.netctoss.beans.ServiceBean;
import org.project.netctoss.beans.UserBean;
import org.project.netctoss.servicemag.dao.IServiceBeanDao;
import org.project.netctoss.servicemag.service.IServiceBeanService;
import org.springframework.stereotype.Service;
@Service
public class ServiceBeanServiceImpl implements IServiceBeanService {
	@Resource
	IServiceBeanDao serviceBeanDaoImpl;
	@Override
	public void saveServiceBean(ServiceBean sb) {
		// TODO Auto-generated method stub
		serviceBeanDaoImpl.saveServiceBean(sb);
	}

	@Override
	public void updateServiceBean(ServiceBean sb) {
		// TODO Auto-generated method stub
		serviceBeanDaoImpl.updateServiceBean(sb);
	}

	@Override
	public void deleteServiceBean(ServiceBean sb) {
		// TODO Auto-generated method stub
		serviceBeanDaoImpl.deleteServiceBean(sb);
	}

	@Override
	public ServiceBean getServiceBeanByID(Long ID) {
		// TODO Auto-generated method stub
		return serviceBeanDaoImpl.getServiceBeanByID(ID);
	}

	@Override
	public Set<ServiceBean> getServiceBeansByUserBean(UserBean ub) {
		// TODO Auto-generated method stub
		return serviceBeanDaoImpl.getServiceBeansByUserBean(ub);
	}

	@Override
	public ServiceBean getServiceBeanByOsName(String osName) {
		// TODO Auto-generated method stub
		return serviceBeanDaoImpl.getServiceBeanByOsName(osName);
	}

}
