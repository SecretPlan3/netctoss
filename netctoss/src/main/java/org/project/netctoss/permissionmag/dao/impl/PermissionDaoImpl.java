package org.project.netctoss.permissionmag.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.project.netctoss.beans.PermissionBean;
import org.project.netctoss.permissionmag.dao.IPermissionDao;
import org.project.netctoss.pojos.PagerBean;
import org.project.netctoss.utils.BaseDao;
import org.springframework.stereotype.Repository;
@Repository
public class PermissionDaoImpl extends BaseDao implements IPermissionDao {

	
	public void addOrUpdatePermission(PermissionBean permissionBean) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(permissionBean);
	}

	public void deletePermissionById(PermissionBean permissionBean) {
		// TODO Auto-generated method stub
		getSession().delete(permissionBean);
	}

	public PermissionBean selectPermissionById(Long id) {
		// TODO Auto-generated method stub
		return (PermissionBean) getSession().get(PermissionBean.class, id);
	}

	public PagerBean findAllPermissionsByPager(PagerBean pager) {
		// TODO Auto-generated method stub
		String hql = "select count(p.id) from PermissionBean as p where p.name like CONCAT(?,'%')";
		Query query = getSession().createQuery(hql);
		query.setString(0, pager.getParams().get("name").toString());
		long totalRows = (Long) query.uniqueResult();
		pager.setTotalRows(Integer.valueOf(String.valueOf(totalRows)));
		
		hql = "From PermissionBean as p where p.name like CONCAT(?,'%')";
		query = getSession().createQuery(hql);
		query.setString(0, pager.getParams().get("name").toString());
		query.setFirstResult(pager.getIndex());
		query.setMaxResults(pager.getRows());
		List<?> datas = query.list();
		pager.setDatas(datas);
		return pager;
	}

}
