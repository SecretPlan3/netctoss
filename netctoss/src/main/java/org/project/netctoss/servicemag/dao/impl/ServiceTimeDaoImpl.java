package org.project.netctoss.servicemag.dao.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.project.netctoss.beans.CostBean;
import org.project.netctoss.beans.ServiceBean;
import org.project.netctoss.beans.ServiceDailyBean;
import org.project.netctoss.beans.ServiceMonthlyBean;
import org.project.netctoss.beans.ServiceTimeBean;
import org.project.netctoss.beans.ServiceYearlyBean;
import org.project.netctoss.servicemag.dao.IServiceTimeDao;
import org.project.netctoss.servicemag.service.IServiceBeanService;
import org.project.netctoss.servicemag.service.IServiceDailyService;
import org.project.netctoss.servicemag.service.IServiceMonthlyService;
import org.project.netctoss.servicemag.service.IServiceYearlyService;
import org.project.netctoss.utils.BaseDao;
import org.springframework.stereotype.Repository;

@Repository
public class ServiceTimeDaoImpl extends BaseDao implements IServiceTimeDao {
	@Resource
	IServiceBeanService serviceBeanServiceImpl;
	@Resource
	IServiceDailyService serviceDailyServiceImpl;
	@Resource
	IServiceMonthlyService serviceMonthlyServiceImpl;
	@Resource
	IServiceYearlyService serviceYearlyServiceImpl;

	/**
	 * 将unix服务器传来的ServiceTime表解析后转化为ServiceDailyBean存入数据库
	 */
	@Override
	public void saveAsDailyService() {
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
		// 查询当月ServiceTime结果集
		String hql = "From ServiceTimeBean as s where  s.loginTime like CONCAT(?,'%')";
		Query query = getSession().createQuery(hql);
		query.setString(0, beginTime);
		List<ServiceTimeBean> allServiceTime = query.list();
		// 循环转存为ServiceDailyBean
		for (ServiceTimeBean serviceTimeBean : allServiceTime) {
			// 获取对应的业务账号
			ServiceBean sb = serviceBeanServiceImpl.getServiceBeanByOsName(serviceTimeBean.getOsName());
			// 获取登录时间
			Date loginT = serviceTimeBean.getLoginTime();
			int loginDay = loginT.getDate();
			int loginMonth = loginT.getMonth() + 1;
			int loginYear = loginT.getYear() + 1900;
			// 获取对应的月对象
			ServiceMonthlyBean sm = serviceMonthlyServiceImpl.getServiceMonthlyBeanByMonthAndServiceAndYear(
					loginMonth + "", serviceTimeBean.getOsName(), loginYear + "");
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
			int logoutYear = logoutT.getYear() + 1900;
			Long onlineTime = logoutT.getTime() - loginT.getTime();
			// unix服务器自动截取月份，所以这里不做月份的判断
			// 判断是否为同一天的登录与登出
			if (loginDay == logoutDay) {
				// 判断是否为一天多次登录
				if (serviceDailyServiceImpl.getServiceDailyBeanByLoginDate(dateToSave) == null) {
					ServiceDailyBean sd = new ServiceDailyBean();
					sd.setDay(dateToSave);
					sd.setOnlineTime(onlineTime);
					sd.setService(sb);
					sd.setServiceMonthly(sm);
					serviceDailyServiceImpl.saveServiceDailyBean(sd);
				} else {
					ServiceDailyBean sd = serviceDailyServiceImpl.getServiceDailyBeanByLoginDate(dateToSave);
					sd.setOnlineTime(sd.getOnlineTime() + onlineTime);
					serviceDailyServiceImpl.updateServiceDailyBean(sd);
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
				if (serviceDailyServiceImpl.getServiceDailyBeanByLoginDate(dateToSave) == null) {
					ServiceDailyBean sd = new ServiceDailyBean();
					sd.setDay(dateToSave);
					sd.setOnlineTime(countDate.getTime() - loginT.getTime());
					sd.setService(sb);
					sd.setServiceMonthly(sm);
					serviceDailyServiceImpl.saveServiceDailyBean(sd);
				} else {
					ServiceDailyBean sd = serviceDailyServiceImpl.getServiceDailyBeanByLoginDate(dateToSave);
					sd.setOnlineTime(sd.getOnlineTime() + countDate.getTime() - loginT.getTime());
					serviceDailyServiceImpl.updateServiceDailyBean(sd);
				}
				ServiceDailyBean sd2 = new ServiceDailyBean();
				sd2.setDay(countDate);
				sd2.setService(sb);
				sd2.setServiceMonthly(sm);
				sd2.setOnlineTime(logoutT.getTime() - countDate.getTime());
				serviceDailyServiceImpl.saveServiceDailyBean(sd2);
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
					serviceDailyServiceImpl.saveServiceDailyBean(sd);
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
				if (serviceDailyServiceImpl.getServiceDailyBeanByLoginDate(dateToSave) == null) {
					ServiceDailyBean sd = new ServiceDailyBean();
					sd.setOnlineTime(dtc.getTime() - loginT.getTime());
					sd.setDay(dateToSave);
					sd.setService(sb);
					sd.setServiceMonthly(sm);
					serviceDailyServiceImpl.saveServiceDailyBean(sd);
				} else {
					ServiceDailyBean sd = serviceDailyServiceImpl.getServiceDailyBeanByLoginDate(dateToSave);
					sd.setOnlineTime(sd.getOnlineTime() + dtc.getTime() - loginT.getTime());
					serviceDailyServiceImpl.updateServiceDailyBean(sd);
				}
				ServiceDailyBean sd2 = new ServiceDailyBean();
				sd2.setDay(outCountDate);
				sd2.setService(sb);
				sd2.setServiceMonthly(sm);
				sd2.setOnlineTime(logoutT.getTime() - outCountDate.getTime());
				serviceDailyServiceImpl.saveServiceDailyBean(sd2);
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
		List<Map<String, String>> list = findAllOsName(beginTime);
		List<Map<String, String>> allOsName = list;
		for (Map<String, String> map : allOsName) {
			ServiceYearlyBean sy = new ServiceYearlyBean();
			String osName = map.get("osName");
			System.out.println(osName);
			ServiceBean sb = serviceBeanServiceImpl.getServiceBeanByOsName(osName);
			CostBean cost = sb.getCost();
			Long sumTime = getSumTimeByOsName(osName);
			System.out.println("sumTime:" + sumTime);
			Double totalCost = null;
			System.out.println("type" + cost.getType());
			if (cost.getType() == 0) {
				totalCost = sumTime * cost.getUnitCost();
			} else if (cost.getType() == 1) {
				totalCost = cost.getBasicCost();
			} else if (cost.getType() == 2) {
				Integer basicTime = cost.getBasicTime();
				if (sumTime <= cost.getBasicTime()) {
					totalCost = cost.getBasicCost();
				} else {
					totalCost = cost.getBasicCost() + (sumTime - cost.getBasicTime()) * cost.getUnitCost();
				}
			}
			System.out.println("totalCost" + totalCost);
			ServiceMonthlyBean sm = new ServiceMonthlyBean();
			sm.setCost(totalCost);
			sm.setMonth(beginMonth + "");
			sm.setOnlineTime(sumTime);
			sm.setService(sb);
			// 判断该年该业务是否有对应记录，有则update，没有则save
			if (serviceYearlyServiceImpl.getServiceYearlyBeanByYearAndService(beginYear + "", osName) == null) {
				sy.setOnlineTime(sumTime);
				sy.setService(sb);
				sy.setCost(totalCost);
				sy.setYear(beginYear + "");
				serviceYearlyServiceImpl.saveServiceYearlyBean(sy);
			} else {
				sy = serviceYearlyServiceImpl.getServiceYearlyBeanByYearAndService(beginYear + "", osName);
				sy.setOnlineTime(sy.getOnlineTime() + sumTime);
				sy.setCost(sy.getCost() + totalCost);
				serviceYearlyServiceImpl.updateServiceYearlyBean(sy);
			}
			sm.setServiceYearly(sy);
			serviceMonthlyServiceImpl.saveServiceMonthlyBean(sm);
		}
	}

	/**
	 * 查找t_service_time表里所有的业务账号
	 */
	public List<Map<String, String>> findAllOsName(String beginTime) {

		System.out.println(beginTime);
		String hql = "select new map(s.osName as osName)  from ServiceTimeBean as s where  s.loginTime like CONCAT(?,'%') group by s.osName";
		Session session = getSession();
		Query query = session.createQuery(hql);
		System.out.println("session:" + session);
		System.out.println("Query:" + query);
		query.setString(0, beginTime);
		System.out.println("AllOsName" + query.list());
		return query.list();
	}

	/**
	 * 得到表里对应业务账号的总时长
	 */

	public Long getSumTimeByOsName(String osName) {
		String hql = "select SUM(online_time) as sumTime  from t_service_time as s where s.os_username=? ";
		Session session = getSession();
		SQLQuery query = session.createSQLQuery(hql);
		query.setString(0, osName);
		BigDecimal sumTime = (BigDecimal) query.uniqueResult();
		Long sumTTTT = sumTime.longValue();
		System.out.println("sumTime:" + sumTime);
		return sumTTTT;
	}
}
