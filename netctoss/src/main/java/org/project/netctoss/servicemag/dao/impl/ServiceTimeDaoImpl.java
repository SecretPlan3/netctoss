package org.project.netctoss.servicemag.dao.impl;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.project.netctoss.beans.CostBean;
import org.project.netctoss.beans.ServiceBean;
import org.project.netctoss.beans.ServiceDailyBean;
import org.project.netctoss.beans.ServiceMonthlyBean;
import org.project.netctoss.beans.ServiceTimeBean;
import org.project.netctoss.beans.ServiceYearlyBean;
import org.project.netctoss.servicemag.dao.IServiceBeanDao;
import org.project.netctoss.servicemag.dao.IServiceDailyDao;
import org.project.netctoss.servicemag.dao.IServiceMonthlyDao;
import org.project.netctoss.servicemag.dao.IServiceTimeDao;
import org.project.netctoss.servicemag.dao.IServiceYearlyDao;
import org.project.netctoss.utils.BaseDao;
import org.springframework.stereotype.Repository;

@Repository
public class ServiceTimeDaoImpl extends BaseDao implements IServiceTimeDao {
	@Resource
	IServiceBeanDao serviceBeanDaoImpl;
	@Resource
	IServiceDailyDao serviceDailyDaoImpl;
	@Resource
	IServiceMonthlyDao serviceMonthlyDaoImpl;
	@Resource
	IServiceYearlyDao serviceYearlyImpl;

	/**
	 * 将unix服务器传来的ServiceTime表解析后转化为ServiceDailyBean存入数据库
	 */
	@Override
	public void saveAsDailyService() {
		// TODO Auto-generated method stub
		// 获取当前时间
		Date nowTime = new Date();
		// 拼接起始查询时间
		int beginMonth = nowTime.getMonth();
		int beginYear = nowTime.getYear();
		if (beginMonth == 0) {
			beginMonth = 12;
			beginYear = beginYear - 1;
		}
		String beginTime = beginYear + "-" + beginMonth;
		// 查询当月ServiceTime结果集
		String hql = "From ServiceTimeBean as s where  s.loginTime like CONCAT(?,%)";
		Query query = getSession().createQuery(hql);
		query.setString(0, beginTime);
		List<ServiceTimeBean> allSeriviceTime = query.list();
		// 循环转存为ServiceDailyBean
		for (ServiceTimeBean serviceTimeBean : allSeriviceTime) {
			// 获取对应的业务账号
			ServiceBean sb = serviceBeanDaoImpl.getServiceBeanByOsName(serviceTimeBean.getOsName());
			// 获取登录时间
			Date loginT = serviceTimeBean.getLoginTime();
			int loginDay = loginT.getDate();
			int loginMonth = loginT.getMonth() + 1;
			int loginYear = loginT.getYear();
			// 获取对应的月对象
			ServiceMonthlyBean sm = serviceMonthlyDaoImpl
					.getServiceMonthlyBeanByMonthAndService(loginYear + "-" + loginMonth, serviceTimeBean.getOsName());
			// 将日期截取为数据库所需要存入的时间
			String saveDate = loginYear + "-" + loginMonth + "-" + loginDay;
			Date dateToSave = null;
			try {
				dateToSave = new SimpleDateFormat("yyyy-MM-dd").parse(saveDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Date logoutT = serviceTimeBean.getLogoutTime();
			int logoutDay = logoutT.getDate();
			int logoutMonth = logoutT.getMonth() + 1;
			int logoutYear = logoutT.getYear();
			Long onlineTime = logoutT.getTime() - loginT.getTime();
			// unix服务器自动截取月份，所以这里不做月份的判断
			// 判断是否为同一天的登录与登出
			if (loginDay == logoutDay) {
				// 判断是否为一天多次登录
				if (serviceDailyDaoImpl.getServiceDailyBeanByLoginDate(dateToSave) == null) {
					ServiceDailyBean sd = new ServiceDailyBean();
					sd.setDay(dateToSave);
					sd.setOnlineTime(onlineTime);
					sd.setService(sb);
					sd.setServiceMonthly(sm);
					serviceDailyDaoImpl.saveServiceDailyBean(sd);
				} else {
					ServiceDailyBean sd = serviceDailyDaoImpl.getServiceDailyBeanByLoginDate(dateToSave);
					sd.setOnlineTime(sd.getOnlineTime() + onlineTime);
					serviceDailyDaoImpl.updateServiceDailyBean(sd);
				}
				// 判断是否为跨天登录
			} else if (logoutDay - loginDay == 1) {
				// 拼接在线时长的计算日期
				String count = logoutYear + "-" + logoutMonth + "-" + logoutDay;
				Date countDate = null;
				try {
					countDate = new SimpleDateFormat("yyyy-MM-dd").parse(count);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 判断是否为一天多次登录
				if (serviceDailyDaoImpl.getServiceDailyBeanByLoginDate(dateToSave) == null) {
					ServiceDailyBean sd = new ServiceDailyBean();
					sd.setDay(dateToSave);
					sd.setOnlineTime(countDate.getTime() - loginT.getTime());
					sd.setService(sb);
					sd.setServiceMonthly(sm);
					serviceDailyDaoImpl.saveServiceDailyBean(sd);
				} else {
					ServiceDailyBean sd = serviceDailyDaoImpl.getServiceDailyBeanByLoginDate(dateToSave);
					sd.setOnlineTime(sd.getOnlineTime() + countDate.getTime() - loginT.getTime());
					serviceDailyDaoImpl.updateServiceDailyBean(sd);
				}
				ServiceDailyBean sd2 = new ServiceDailyBean();
				sd2.setDay(countDate);
				sd2.setService(sb);
				sd2.setServiceMonthly(sm);
				sd2.setOnlineTime(logoutT.getTime() - countDate.getTime());
				serviceDailyDaoImpl.saveServiceDailyBean(sd2);
				// 判断是否为跨多天登录
			} else if (logoutDay - loginDay > 1) {
				// 循环存入中间登录状态为一整天的数据
				for (int i = 0; i < logoutDay - loginDay - 1; i++) {
					ServiceDailyBean sd = new ServiceDailyBean();
					String toSaveDate = loginYear + "-" + loginMonth + "-" + (loginDay + i + 1);
					Date toSD = null;
					try {
						toSD = new SimpleDateFormat("yyyy-MM-dd").parse(toSaveDate);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Long onlineT = (long) (24 * 60 * 60 * 1000);
					sd.setDay(toSD);
					sd.setOnlineTime(onlineT);
					sd.setService(sb);
					sd.setServiceMonthly(sm);
				}
				// 拼接登出存入日期
				String outCount = logoutYear + "-" + logoutMonth + "-" + logoutDay;
				Date outCountDate = null;
				try {
					outCountDate = new SimpleDateFormat("yyyy-MM-dd").parse(outCount);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 拼接计算登录当天时长的日期
				String dateToCount = loginYear + "-" + loginMonth + "-" + (loginDay + 1);
				Date dtc = null;
				try {
					dtc = new SimpleDateFormat("yyyy-MM-dd").parse(dateToCount);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 判断是否为一天多次登录
				if (serviceDailyDaoImpl.getServiceDailyBeanByLoginDate(dateToSave) == null) {
					ServiceDailyBean sd = new ServiceDailyBean();
					sd.setOnlineTime(dtc.getTime() - loginT.getTime());
					sd.setDay(dateToSave);
					sd.setService(sb);
					sd.setServiceMonthly(sm);
					serviceDailyDaoImpl.saveServiceDailyBean(sd);
				} else {
					ServiceDailyBean sd = serviceDailyDaoImpl.getServiceDailyBeanByLoginDate(dateToSave);
					sd.setOnlineTime(sd.getOnlineTime() + dtc.getTime() - loginT.getTime());
					serviceDailyDaoImpl.updateServiceDailyBean(sd);
				}
				ServiceDailyBean sd2 = new ServiceDailyBean();
				sd2.setDay(outCountDate);
				sd2.setService(sb);
				sd2.setServiceMonthly(sm);
				sd2.setOnlineTime(logoutT.getTime() - outCountDate.getTime());
				serviceDailyDaoImpl.saveServiceDailyBean(sd2);
			}

		}

	};

	@Override
	public void saveAsMonthlyService() {
		// TODO Auto-generated method stub
		// 获取当前时间
		Date nowTime = new Date();
		// 拼接起始查询时间
		int beginMonth = nowTime.getMonth() + 1;
		int beginYear = nowTime.getYear() + 1900;
		if (beginMonth == 0) {
			beginMonth = 12;
			beginYear = beginYear - 1;
		}
		String beginTime = beginYear + "-" + beginMonth;
		System.out.println(beginYear);
		List<Map<String, String>> allOsName = findAllOsName(beginTime);
		for (Map<String, String> map : allOsName) {
			ServiceYearlyBean sy = new ServiceYearlyBean();
			String osName = map.get("osName");
			ServiceBean sb = serviceBeanDaoImpl.getServiceBeanByOsName(osName);
			CostBean cost = sb.getCost();
			String hql2 = "select sum(online_time)  from ServiceTimeBean as s where s.osName = ?";
			Query query = getSession().createQuery(hql2);
			query.setString(0, osName);
			Long sumTime = (Long) query.uniqueResult();
			Double totalCost = null;
			if (cost.getType() == 0L) {
				totalCost = sumTime * cost.getUnitCost();
			} else if (cost.getType() == 1L) {
				totalCost = cost.getBasicCost();
			} else if (cost.getType() == 2L) {
				Integer basicTime = cost.getBasicTime();
				if (sumTime <= cost.getBasicTime()) {
					totalCost = cost.getBasicCost();
				} else {
					totalCost = cost.getBasicCost() + (sumTime - cost.getBasicTime()) * cost.getUnitCost();
				}
			}
			ServiceMonthlyBean sm = new ServiceMonthlyBean();
			sm.setCost(totalCost);
			sm.setMonth(beginMonth + "");
			sm.setOnlineTime(sumTime);
			sm.setService(sb);
			// 判断该年该业务是否有对应记录，有则update，没有则save
			if (serviceYearlyImpl.getServiceYearlyBeanByYearAndService(beginYear + "", osName) == null) {
				sy.setOnlineTime(sumTime);
				sy.setService(sb);
				sy.setCost(totalCost);
				sy.setYear(beginYear + "");
				serviceYearlyImpl.saveServiceYearlyBean(sy);
			} else {
				sy = serviceYearlyImpl.getServiceYearlyBeanByYearAndService(beginYear + "", osName);
				sy.setOnlineTime(sy.getOnlineTime() + sumTime);
				sy.setCost(sy.getCost() + totalCost);
				serviceYearlyImpl.updateServiceYearlyBean(sy);
			}
			sm.setServiceYearly(sy);
			serviceMonthlyDaoImpl.saveServiceMonthlyBean(sm);
		}
	}

	public List<Map<String, String>> findAllOsName(String beginTime) {

		System.out.println(beginTime);
		String hql = "select new map(s.osName as osName)  from ServiceTimeBean as s where  s.loginTime like CONCAT(?,'%') group by s.osName";
		Query query = getSession().createQuery(hql);
		query.setString(0, beginTime);
		return query.list();
	}
}
