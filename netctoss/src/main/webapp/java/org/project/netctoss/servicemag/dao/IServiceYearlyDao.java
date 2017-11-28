package org.project.netctoss.servicemag.dao;

import org.project.netctoss.beans.ServiceYearlyBean;
 
public interface IServiceYearlyDao {
		public void saveServiceYearlyBean(ServiceYearlyBean sd);
		public void deleteServiceYearlyBean(ServiceYearlyBean sd);
		public void updateServiceYearlyBean(ServiceYearlyBean sd);
		public ServiceYearlyBean getServiceYearlyBeanByID(Long ID);
}
