package org.project.netctoss.logmag.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.project.netctoss.logmag.dao.ILogmagDao;
import org.project.netctoss.pojos.PagerBean;
import org.project.netctoss.utils.BaseDao;
import org.springframework.stereotype.Repository;
@Repository
public class LogmagDaoImpl extends BaseDao implements ILogmagDao {

	@Override
	public PagerBean findManagerLog(PagerBean pager) {
		// TODO Auto-generated method stub
		//根据管理查询登陆/退出系统时间
		StringBuilder hql = new StringBuilder("select count(l.id) from ManagerLogBean as l left join l.managerOperation as m where 1 = 1");
		if(pager.getParams().get("managerId") != null) {
			hql.append(" and m.id = :managerId");
		}
		Query query = getSession().createQuery(hql.toString());
		query.setProperties(pager.getParams());
		long totalRows = (long) query.uniqueResult();
		pager.setTotalRows(Integer.valueOf(String.valueOf(totalRows)));
		hql = new StringBuilder("from ManagerLogBean as l left join l.managerOperation as m  where 1 = 1");
		if(pager.getParams().get("managerId") != null) {
			hql.append(" and m.id = :managerId");
		}
		query = getSession().createQuery(hql.toString());
		query.setProperties(pager.getParams());
		query.setFirstResult(pager.getIndex());
		query.setMaxResults(pager.getRows());
		List<?> datas = query.list();
		pager.setDatas(datas);
		return pager;
	}

	@Override
	public PagerBean findManagerOperationLog(PagerBean pager) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder("select count(l.id) from ManagerOperationLogBean as l left join l.operationManager as m where 1 = 1");
		if(pager.getParams().get("managerId") != null) {
			//根据管理员查询该管理操作信息
			hql.append(" and m.id = :managerId");
		}
		if(pager.getParams().get("LoginTime") != null) {
			//根据登陆日期范围查询该管理员操作信息
			hql.append(" and l.operation_time > :LoginTime");
		}
		if(pager.getParams().get("LogoutTime") != null) {
			//根据退出日期范围查询该管理员操作信息
			hql.append(" and l.operation_time < :LogoutTime");
		}
		Query query = getSession().createQuery(hql.toString());
		query.setProperties(pager.getParams());
		long totalRows = (Long) query.uniqueResult();
		pager.setTotalRows(Integer.valueOf(String.valueOf(totalRows)));
		
		hql = new StringBuilder("from ManagerOperationLogBean as l left join l.operationManager as m where 1 = 1");
		if(pager.getParams().get("managerId") != null) {
			//根据管理员查询该管理操作信息
			hql.append(" and m.id = :managerId");
		}
		if(pager.getParams().get("LoginTime") != null) {
			//根据登陆日期范围查询该管理员操作信息
			hql.append(" and l.operation_time > :LoginTime");
		}
		if(pager.getParams().get("LogoutTime") != null) {
			//根据退出日期范围查询该管理员操作信息
			hql.append(" and l.operation_time < :LogoutTime");
		}
		
		query = getSession().createQuery(hql.toString());
		query.setProperties(pager.getParams());
		query.setFirstResult(pager.getIndex());
		query.setMaxResults(pager.getRows());
		List<?> datas = query.list();
		pager.setDatas(datas);
		return pager;
	}

}
