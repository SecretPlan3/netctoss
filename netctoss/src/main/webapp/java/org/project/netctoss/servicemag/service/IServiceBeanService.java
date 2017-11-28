package org.project.netctoss.servicemag.service;

import java.util.Set;

import org.project.netctoss.beans.ServiceBean;
import org.project.netctoss.beans.UserBean;

public interface IServiceBeanService {
	public void saveServiceBean(ServiceBean sb);
	  public void updateServiceBean(ServiceBean sb);
	  public void deleteServiceBean(ServiceBean sb);
	  public ServiceBean getServiceBeanByID(Long ID);
	  public Set<ServiceBean> getServiceBeansByUserBean(UserBean ub);
}
