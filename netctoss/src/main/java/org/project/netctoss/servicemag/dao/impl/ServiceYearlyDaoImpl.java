package org.project.netctoss.servicemag.dao.impl;


import org.project.netctoss.beans.ServiceYearlyBean;
import org.project.netctoss.servicemag.dao.IServiceYearlyDao;
import org.project.netctoss.utils.BaseDao;
import java.util.Set;

import org.hibernate.Query;
import org.project.netctoss.beans.ServiceBean;
import org.project.netctoss.beans.UserBean;
import org.project.netctoss.pojos.PagerBean;
import org.project.netctoss.servicemag.dao.IServiceBeanDao;
import org.project.netctoss.utils.BaseDao;
import org.springframework.stereotype.Repository;
@Repository
public class ServiceYearlyDaoImpl extends BaseDao implements IServiceYearlyDao {

	@Override
	public void saveServiceYearlyBean(ServiceYearlyBean sd) {
		// TODO Auto-generated method stub
			getSession().save(sd);
	}

	@Override
	public void deleteServiceYearlyBean(ServiceYearlyBean sd) {
		// TODO Auto-generated method stub
		getSession().delete(sd);
	}

	@Override
	public void updateServiceYearlyBean(ServiceYearlyBean sd) {
		// TODO Auto-generated method stub
		getSession().update(sd);
	}

	@Override
	public ServiceYearlyBean getServiceYearlyBeanByID(Long ID) {
		// TODO Auto-generated method stub
		return (ServiceYearlyBean) getSession().get(ServiceYearlyBean.class, ID);
	}

	@Override
	public ServiceYearlyBean getServiceYearlyBeanByYearAndService(String year,String osName) {
		// TODO Auto-generated method stub
		String hql = "From ServiceYearlyBean as s where s.year=? and s.service.osName=?";
		Query query = getSession().createQuery(hql);
		query.setString(0, year);
		query.setString(2, osName);
		return (ServiceYearlyBean) query.uniqueResult();
	}

}
