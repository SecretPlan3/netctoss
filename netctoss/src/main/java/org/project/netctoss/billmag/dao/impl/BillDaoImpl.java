package org.project.netctoss.billmag.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.project.netctoss.beans.BillBean;
import org.project.netctoss.beans.ServiceMonthlyBean;
import org.project.netctoss.beans.UserBean;
import org.project.netctoss.billmag.dao.IBillDao;
import org.project.netctoss.pojos.PagerBean;
import org.project.netctoss.utils.BaseDao;
import org.springframework.stereotype.Repository;

@Repository
public class BillDaoImpl extends BaseDao implements IBillDao {
//
	@Override
	public PagerBean findAllUserBillByCondition(PagerBean page) {
		// 得到数据总数
		StringBuilder hql = new StringBuilder(
				"SELECT COUNT(b.id) FROM BillBean AS b JOIN FETCH b.user AS u WHERE b.year = :year AND b.month = :month");
		UserBean user = (UserBean) page.getParams().get("user");
		if (user.getUserName() != "") {
			hql.append(" AND u.userName LIKE CONCAT(:user.userName,'%') ");
		}
		if (user.getLoginName() != "") {
			hql.append(" AND u.loginName LIKE CONCAT(:user.loginName,'%') ");
		}
		if (user.getIdcard() != "") {
			hql.append(" AND u.idcard LIKE CONCAT(:user.idcard,'%') ");
		}

		Query query = getSession().createQuery(hql.toString());
		query.setProperties(page.getParams());
		page.setTotalRows(Integer.valueOf(query.uniqueResult() + ""));

		hql.delete(0, 19);
		if (user.getUserName() != "") {
			hql.append(" AND u.userName LIKE CONCAT(:user.userName,'%') ");
		}
		if (user.getLoginName() != "") {
			hql.append(" AND u.loginName LIKE CONCAT(:user.loginName,'%') ");
		}
		if (user.getIdcard() != "") {
			hql.append(" AND u.idcard LIKE CONCAT(:user.idcard,'%') ");
		}
		query = getSession().createQuery(hql.toString());
		query.setFirstResult(page.getIndex());
		query.setMaxResults(page.getRows());
		// 设置Map类型的参数
		query.setProperties(page.getParams());
		List<BillBean> allUser = query.list();
		page.setDatas(allUser);

		return page;
	}

	@Override
	public PagerBean findAllServiceBillByCondition(PagerBean page) {
		// 模拟参数
		Map<String, Object> params = new HashMap<>();
		params.put("userID", 1);
		params.put("year", 2017);
		params.put("month", 4);
		page.setParams(params);
		page.setPage(1);
		page.setRows(5);

		String hql = "SELECT COUNT(s.id) FROM ServiceMonthlyBean AS m JOIN y.ServiceYearlyBean AS y JOIN y.ServiceBean AS s JOIN s.CostBean AS c WHERE y.year = :year AND m.month = :month AND s.user = :userID";
		Query query = getSession().createQuery(hql.toString());
		page.setTotalRows(Integer.valueOf(query.uniqueResult() + ""));

		hql = "SELECT COUNT(s.id) FROM ServiceMonthlyBean AS m JOIN y.ServiceYearlyBean AS y JOIN y.ServiceBean AS s JOIN s.CostBean AS c WHERE y.year = :year AND m.month = :month AND s.user = :userID";
		query = getSession().createQuery(hql.toString());
		query.setProperties(page.getParams());
		query.setFirstResult(page.getIndex());
		query.setMaxResults(page.getRows());
		List<ServiceMonthlyBean> allMonthly = query.list();
		page.setDatas(allMonthly);

		return page;
	}

	@Override
	public PagerBean findAllServiceTimeBillByCondition(PagerBean page) {
		// 模拟参数
		Map<String, Object> params = new HashMap<>();
		params.put("osName", "aaa");
		params.put("theDate", "2017-04");
		page.setParams(params);
		page.setPage(1);
		page.setRows(5);
		 
		String hql = "SELECT COUNT(s.id) FROM ";
		Query query = getSession().createQuery(hql.toString());
		page.setTotalRows(Integer.valueOf(query.uniqueResult() + ""));
		
		hql = "";
		query = getSession().createQuery(hql.toString());
		query.setProperties(page.getParams());
		query.setFirstResult(page.getIndex());
		query.setMaxResults(page.getRows());
		

		return null;
	}

}
