package org.project.netctoss.servicemag.dao;

import java.util.Set;

import org.project.netctoss.beans.ServiceBean;
import org.project.netctoss.beans.UserBean;
import org.project.netctoss.pojos.PagerBean;

public interface IServiceBeanDao {
  public void saveServiceBean(ServiceBean sb);
  public void updateServiceBean(ServiceBean sb);
  public void deleteServiceBean(ServiceBean sb);
  public ServiceBean getServiceBeanByID(Long ID);
  public Set<ServiceBean> getServiceBeansByUserBean(UserBean ub);
//  public PagerBean getServiceBeansByPage(PagerBean page);
}
