package org.project.netctoss.managermag.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.project.netctoss.beans.ManagerBean;
import org.project.netctoss.managermag.dao.IManagerDao;
import org.project.netctoss.pojos.PagerBean;
import org.project.netctoss.utils.BaseDao;
import org.springframework.stereotype.Repository;
@Repository
public class ManagerDaoImpl extends BaseDao implements IManagerDao {

	public void addOrUpdateManeger(ManagerBean managerbean) {
		// TODO Auto-generated method stub
		getSession().save(managerbean);
	}

	public void deleteManegerById(ManagerBean managerbean) {
		// TODO Auto-generated method stub
		getSession().delete(managerbean);
	}

	public ManagerBean selectManegerById(Long id) {
		// TODO Auto-generated method stub
		return (ManagerBean) getSession().get(ManagerBean.class, id);
	}

	public PagerBean findAllManagersByPager(PagerBean pager) {
		// TODO Auto-generated method stub
		String hql = "select count(m.id) from ManagerBean as m where m.magName like CONCAT(?,'%') and m.tel like CONCAT(?,'%')";
		Query query = getSession().createQuery(hql);
		query.setString(0, pager.getParams().get("magName").toString());
		query.setString(1, pager.getParams().get("tel").toString());
		long totalRows = (Long) query.uniqueResult();
		pager.setTotalRows(Integer.valueOf(String.valueOf(totalRows)));
		
		hql = "From ManagerBean as m where m.magName like CONCAT(?,'%') and m.tel like CONCAT(?,'%')";
		query = getSession().createQuery(hql);
		query.setString(0, pager.getParams().get("magName").toString());
		query.setString(1, pager.getParams().get("tel").toString());
		query.setFirstResult(pager.getIndex());
		query.setMaxResults(pager.getRows());
		List<?> datas = query.list();
		pager.setDatas(datas);
		return pager;
	}

	@Override
	public ManagerBean findManagerByLoginName(String loginName) {
		// TODO Auto-generated method stub
		String hql = "From ManagerBean as m where m.loginName = ?";
		Query query = getSession().createQuery(hql);
		query.setString(0, loginName);
		return (ManagerBean) query.uniqueResult();
	}

	@Override
	public ManagerBean findManagerByLoginNameAndPassword(String loginName, String password) {
		// TODO Auto-generated method stub
		String hql = "From ManagerBean as m where m.loginName = ? and m.password = ?";
		Query query = getSession().createQuery(hql);
		query.setString(0, loginName);
		query.setString(1, password);
		return (ManagerBean) query.uniqueResult();
	}

}
