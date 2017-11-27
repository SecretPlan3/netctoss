package org.project.netctoss.billmag.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.project.netctoss.billmag.dao.IBillDao;
import org.project.netctoss.pojos.PagerBean;
import org.project.netctoss.utils.BaseDao;
import org.springframework.stereotype.Repository;

@Repository
public class BillDaoImpl extends BaseDao implements IBillDao {

	@Override
	public PagerBean findAllUserBillByCondition(PagerBean page) {
		// 得到数据总数
		String hql = "select COUNT(u.userID) from UserBean as u";
		Query query = getSession().createQuery(hql);
		page.setTotalRows(Integer.valueOf(query.uniqueResult() + ""));

		hql = "from UserBean ";
		query = getSession().createQuery(hql);
		query.setFirstResult(page.getIndex());
		query.setMaxResults(page.getRows());

		return null;
	}

	@Override
	public PagerBean findAllServiceBillByCondition(PagerBean page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagerBean findAllServiceTimeBillByCondition(PagerBean page) {
		// TODO Auto-generated method stub
		return null;
	}

}
