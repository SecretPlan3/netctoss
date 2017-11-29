package org.project.netctoss.servicemag.service;

import org.project.netctoss.beans.ServiceYearlyBean;
 
public interface IServiceYearlyService { 
		public void saveServiceYearlyBean(ServiceYearlyBean sd);
		public void deleteServiceYearlyBean(ServiceYearlyBean sd);
		public void updateServiceYearlyBean(ServiceYearlyBean sd);
		public ServiceYearlyBean getServiceYearlyBeanByID(Long ID);
		public ServiceYearlyBean getServiceYearlyBeanByYear(String year);
}
