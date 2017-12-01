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
		/**
		 * 查找t_service_time表里所有的业务账号
		 */
		public List<Map<String, String>> findAllOsName(String beginTime);
		/**
		 *得到表里对应业务账号的总时长
		 */
		public Long getSumTimeByOsName(String osName);
}
