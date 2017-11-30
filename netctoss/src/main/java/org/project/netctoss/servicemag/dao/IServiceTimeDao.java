package org.project.netctoss.servicemag.dao;


import java.util.List;
import java.util.Map;
import java.util.Set;

import org.project.netctoss.beans.ServiceDailyBean;
import org.project.netctoss.beans.ServiceMonthlyBean;
import org.project.netctoss.beans.ServiceTimeBean;
     
public interface IServiceTimeDao {
		public void saveAsDailyService();
		public void saveAsMonthlyService();
		public List<Map<String, String>> findAllOsName(String beginTime);
}
