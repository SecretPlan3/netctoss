package org.project.netctoss.costmag.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.project.netctoss.beans.CostBean;
import org.project.netctoss.costmag.dao.ICostDao;
import org.project.netctoss.pojos.PagerBean;
import org.project.netctoss.utils.BaseDao;
import org.springframework.stereotype.Repository;
@Repository
public class CostDaoImpl extends BaseDao implements ICostDao {

	public void insertCosts(CostBean costBean) {
		// TODO Auto-generated method stub
		getSession().save(costBean);
	}

	public CostBean selectCosts(long id) {
		// TODO Auto-generated method stub
		return (CostBean) getSession().get(CostBean.class, id);
	}

	public void deleteCosts(CostBean costBean) {
		// TODO Auto-generated method stub
		getSession().delete(costBean);
	}

	public void updateCosts(CostBean costBean) {
		// TODO Auto-generated method stub
		getSession().update(costBean);
	}

	public PagerBean findAllCostsByPager(PagerBean pager) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder("select count(c.id) from CostBean as c where 1 = 1");
		if(pager.getParams().get("costType") != null) {
			//根据套餐类型查询该套餐类型所有套餐，前台传入的type类型应该为int类型
			hql.append(" and c.type = :costType");
		}
		if(pager.getParams().get("costName") != null) {
			//根据套餐名字进行模糊查询
			hql.append(" and c.name like CONCAT(:costName,'%')");
		}
		if(pager.getParams().get("costNumber") != null) {
			//根据套餐编号进行模糊查询
			hql.append(" and c.costNumber like CONCAT(:costNumber,'%')");
		}
		Query query = getSession().createQuery(hql.toString());
		query.setProperties(pager.getParams());
		long totalRows = (Long) query.uniqueResult();
		pager.setTotalRows(Integer.valueOf(String.valueOf(totalRows)));
		
		hql = new StringBuilder("from CostBean as c where 1 = 1");
		if(pager.getParams().get("costType") != null) {
			//根据套餐类型查询该套餐类型所有套餐，前台传入的type类型应该为int类型
			hql.append(" and c.type = :costType");
		}
		if(pager.getParams().get("costName") != null) {
			//根据套餐名字进行模糊查询
			hql.append(" and c.name like CONCAT(:costName,'%')");
		}
		if(pager.getParams().get("costNumber") != null) {
			//根据套餐编号进行模糊查询
			hql.append(" and c.costNumber like CONCAT(:costNumber,'%')");
		}
		
		query = getSession().createQuery(hql.toString());
		query.setProperties(pager.getParams());
		query.setFirstResult(pager.getIndex());
		query.setMaxResults(pager.getRows());
		List<?> datas = query.list();
		pager.setDatas(datas);
		return pager;
	}

	private Object Integer(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}
