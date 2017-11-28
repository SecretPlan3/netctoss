package org.project.netctoss.servicemag.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.project.netctoss.beans.ServiceBean;
import org.project.netctoss.beans.ServiceDailyBean;
import org.project.netctoss.beans.ServiceMonthlyBean;
import org.project.netctoss.beans.ServiceTimeBean;
import org.project.netctoss.servicemag.dao.IServiceBeanDao;
import org.project.netctoss.servicemag.dao.IServiceTimeDao;
import org.project.netctoss.utils.BaseDao;
import java.util.Set;

import org.hibernate.Query;
import org.project.netctoss.beans.ServiceBean;
import org.project.netctoss.beans.UserBean;
import org.project.netctoss.pojos.PagerBean;
import org.project.netctoss.servicemag.dao.IServiceBeanDao;
import org.project.netctoss.utils.BaseDao;
import org.springframework.stereotype.Repository;
@Repository
public class ServiceTimeDaoImpl extends BaseDao implements IServiceTimeDao  {
	@Resource			
	IServiceBeanDao serviceBeanDaoImpl;
    /**
     * 将unix服务器传来的ServiceTime表解析后转化为ServiceDailyBean存入数据库
     */
	@Override
	public void saveAsDailyService() {
		// TODO Auto-generated method stub
		Date nowTime = new Date();
		int nowDay = nowTime.getDate();
		int nowMonth = nowTime.getMonth()+1;
		int nowYear = nowTime.getYear();
		String beginTime=nowYear+"-"+nowMonth+"-"+"01 00:00:00";
		Date beginDate =null;
		try {
			beginDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(beginTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String hql ="From ServiceTimeBean as s where s.loginTime between ? and ? ";
		Query query = getSession().createQuery(hql);
		query.setDate(0, beginDate);
		query.setDate(0, nowTime);
		List<ServiceTimeBean> allSeriviceTime = query.list();
		for (ServiceTimeBean serviceTimeBean : allSeriviceTime) {
			 ServiceBean sb = serviceBeanDaoImpl.getServiceBeanByOsName(serviceTimeBean.getOsName());
			 Date loginT = serviceTimeBean.getLoginTime();
			 int loginDay = loginT.getDate();
			 int loginMonth = loginT.getMonth()+1;
			 int loginYear = loginT.getYear();
			 
			 Date logoutT =serviceTimeBean.getLogoutTime();
			 int logoutDay = logoutT.getDate();
			 int logoutMonth = logoutT.getMonth()+1;
			 int logoutYear = logoutT.getYear();
			 if(loginDay==logoutDay) {
				 
			 }
			 
	};
	}
	@Override
	public void saveAsMonthlyService(Set<ServiceDailyBean> allDailyService) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveAsYearlyService(Set<ServiceMonthlyBean> allMonthlyService) {
		// TODO Auto-generated method stub
		
	}

}
