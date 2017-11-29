package org.project.netctoss.servicemag.service;

import java.util.Set;

import org.project.netctoss.beans.ServiceDailyBean;
import org.project.netctoss.beans.ServiceMonthlyBean;
import org.project.netctoss.beans.ServiceTimeBean;
     
public interface IServiceTimeService {
		public void saveAsDailyService();
		public void saveAsMonthlyService();
		public void saveAsYearlyService();
}
