package org.project.netctoss.servicemag.dao;

import org.project.netctoss.beans.ServiceMonthlyBean;

public interface IServiceMonthlyDao {
		public void saveServiceMonthlyBean(ServiceMonthlyBean sd);
		public void deleteServiceMonthlyBean(ServiceMonthlyBean sd);
		public void updateServiceMonthlyBean(ServiceMonthlyBean sd);
		public ServiceMonthlyBean getServiceMonthlyBeanByID(Long ID);
}
