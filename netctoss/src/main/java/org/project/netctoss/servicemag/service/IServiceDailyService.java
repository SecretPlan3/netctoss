package org.project.netctoss.servicemag.service;

import java.util.Date;

import org.project.netctoss.beans.ServiceDailyBean;

public interface IServiceDailyService {
		public void saveServiceDailyBean(ServiceDailyBean sd);
		public void deleteServiceDailyBean(ServiceDailyBean sd);
		public void updateServiceDailyBean(ServiceDailyBean sd);
		public ServiceDailyBean getServiceDailyBeanByID(Long ID);
		public ServiceDailyBean getServiceDailyBeanByLoginDate(Date loginDate);
}
