package org.project.netctoss.servicemag.dao;

import java.util.Set;

import org.project.netctoss.beans.ServiceDailyBean;
import org.project.netctoss.beans.ServiceMonthlyBean;
import org.project.netctoss.beans.ServiceTimeBean;

public interface IServiceTimeDao {
		public void saveAsDailyService();
		public void saveAsMonthlyService(Set<ServiceDailyBean> allDailyService );
		public void saveAsYearlyService(Set<ServiceMonthlyBean> allMonthlyService);
}
