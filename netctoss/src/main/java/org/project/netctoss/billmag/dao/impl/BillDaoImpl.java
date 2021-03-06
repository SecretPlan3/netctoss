package org.project.netctoss.billmag.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.project.netctoss.beans.BillBean;
import org.project.netctoss.beans.ServiceBean;
import org.project.netctoss.beans.ServiceDetailCostBean;
import org.project.netctoss.beans.ServiceMonthlyBean;
import org.project.netctoss.beans.ServiceYearlyBean;
import org.project.netctoss.beans.ServiceYearlyVO;
import org.project.netctoss.beans.UserBean;
import org.project.netctoss.billmag.dao.IBillDao;
import org.project.netctoss.pojos.PagerBean;
import org.project.netctoss.utils.BaseDao;
import org.project.netctoss.utils.DateUtils;
import org.springframework.stereotype.Repository;

@Repository
public class BillDaoImpl extends BaseDao implements IBillDao {

	@Override
	public PagerBean findAllUserBillByCondition(PagerBean page) {
		// 得到数据总数
		StringBuilder hql = new StringBuilder(
				"SELECT COUNT(b.id) FROM BillBean AS b JOIN b.user AS u WHERE b.year = :year AND b.month = :month ");
		if (!page.getParams().get("userName").equals("")) {
			hql.append(" AND u.userName LIKE CONCAT(:userName,'%') ");
		}
		if (!page.getParams().get("loginName").equals("")) {
			hql.append(" AND u.loginName LIKE CONCAT(:loginName,'%') ");
		}
		if (!page.getParams().get("idcard").equals("")) {
			hql.append(" AND u.idcard LIKE CONCAT(:idcard,'%') ");
		}
		Query query = getSession().createQuery(hql.toString());
		query.setProperties(page.getParams());
		page.setTotalRows(Integer.valueOf(query.uniqueResult() + ""));
		
		
		StringBuilder hql2 = new StringBuilder(
				"FROM BillBean AS b JOIN FETCH b.user AS u WHERE b.year = :year AND b.month = :month ");
		if (!page.getParams().get("userName").equals("")) {
			hql2.append(" AND u.userName LIKE CONCAT(:userName,'%') ");
		}
		if (!page.getParams().get("loginName").equals("")) {
			hql2.append(" AND u.loginName LIKE CONCAT(:loginName,'%') ");
		}
		if (!page.getParams().get("idcard").equals("")) {
			hql2.append(" AND u.idcard LIKE CONCAT(:idcard,'%') ");
		}
		hql2.append(" ORDER BY b.id");
		query = getSession().createQuery(hql2.toString());
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
		String hql = "SELECT COUNT(s.id) from ServiceBean as s join s.serviceYear as y join y.serviceMonthly as m join s.cost as c join s.user as u WHERE y.year = :year AND m.month = :month AND u.userId = :userID ";
		Query query = getSession().createQuery(hql.toString());
		query.setProperties(page.getParams());
		page.setTotalRows(Integer.valueOf(query.uniqueResult() + ""));

		hql = "from ServiceBean as s join fetch s.serviceYear as y join fetch y.serviceMonthly as m join fetch s.cost as c join fetch s.user as u WHERE y.year = :year AND m.month = :month AND u.userId = :userID ORDER BY s.id ";
		query = getSession().createQuery(hql.toString());
		query.setProperties(page.getParams());
		query.setFirstResult(page.getIndex());
		query.setMaxResults(page.getRows());
		List<ServiceBean> allservice = query.list();
		page.setDatas(allservice);
		return page;
	}
 
	@Override
	public PagerBean findAllServiceTimeBillByCondition(PagerBean page) {
		 
		String hql = "SELECT COUNT(sdc.id) FROM ServiceDetailCostBean AS sdc JOIN sdc.serviceTime AS st JOIN sdc.costbean AS c WHERE st.loginTime > :loginTime AND st.logoutTime < :logoutTime AND st.osName = :osName ORDER BY st.loginTime";
		Query query = getSession().createQuery(hql);
		query.setProperties(page.getParams());
		page.setTotalRows(Integer.valueOf(query.uniqueResult() + ""));
		
		hql = "FROM ServiceDetailCostBean AS sdc JOIN FETCH sdc.serviceTime AS st JOIN FETCH sdc.costbean AS c WHERE st.loginTime > :loginTime AND st.logoutTime < :logoutTime AND st.osName = :osName ORDER BY st.loginTime";
		query = getSession().createQuery(hql);
		query.setProperties(page.getParams());
		query.setFirstResult(page.getIndex());
		query.setMaxResults(page.getRows());
		List<ServiceDetailCostBean> ServiceDetailCostList = query.list();
		page.setDatas(ServiceDetailCostList);

		return page;
	}

	@Override
	public PagerBean findAllYear() {
		String hql = "FROM ServiceYearlyVO as y GROUP BY y.year ORDER BY y.year DESC";
		Query query = getSession().createQuery(hql);
		PagerBean page = new PagerBean();
		List<ServiceYearlyVO> yearList = query.list();
		page.setDatas(yearList);
		return page;
	}

}
