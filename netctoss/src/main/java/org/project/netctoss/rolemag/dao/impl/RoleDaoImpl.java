package org.project.netctoss.rolemag.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.project.netctoss.beans.RoleBean;
import org.project.netctoss.pojos.PagerBean;
import org.project.netctoss.rolemag.dao.IRoleDao;
import org.project.netctoss.utils.BaseDao;
import org.springframework.stereotype.Repository;
@Repository
public class RoleDaoImpl extends BaseDao implements IRoleDao {

	public void addOrUpdateRole(RoleBean roleBean) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(roleBean);
	}

	public void deleteRoleById(RoleBean roleBean) {
		// TODO Auto-generated method stub
		getSession().delete(roleBean);
	}

	public RoleBean selectRoleById(Long id) {
		// TODO Auto-generated method stub
		return (RoleBean) getSession().get(RoleBean.class,id);
	}

	public PagerBean findAllRolesByPager(PagerBean pager) {
		// TODO Auto-generated method stub
		String hql = "select count(r.id) from RoleBean as r where r.name like CONCAT(?,'%') and r.type = ?";
		Query query = getSession().createQuery(hql);
		query.setString(0, pager.getParams().get("name").toString());
		query.setString(1, pager.getParams().get("type").toString());
		long totalRows = (Long) query.uniqueResult();
		pager.setTotalRows(Integer.valueOf(String.valueOf(totalRows)));
		
		hql = "From RoleBean as r left join fetch r.pers as p where r.name like CONCAT(?,'%') and r.type = ?";
		query = getSession().createQuery(hql);
		query.setString(0, pager.getParams().get("name").toString());
		query.setString(1, pager.getParams().get("type").toString());
		query.setFirstResult(pager.getIndex());
		query.setMaxResults(pager.getRows());
		List<?> datas = query.list();
		pager.setDatas(datas);
		return pager;
	}

}
