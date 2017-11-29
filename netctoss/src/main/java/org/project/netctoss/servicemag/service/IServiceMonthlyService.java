package org.project.netctoss.servicemag.service;

import org.project.netctoss.beans.ServiceMonthlyBean;

public interface IServiceMonthlyService {
		public void saveServiceMonthlyBean(ServiceMonthlyBean sd);
		public void deleteServiceMonthlyBean(ServiceMonthlyBean sd);
		public void updateServiceMonthlyBean(ServiceMonthlyBean sd);
		public ServiceMonthlyBean getServiceMonthlyBeanByID(Long ID);
		public ServiceMonthlyBean getServiceMonthlyBeanByMonth(String month);
}
