package org.project.netctoss.servicemag.dao.impl;

import org.project.netctoss.beans.ServiceDailyBean;
import org.project.netctoss.servicemag.dao.IServiceDailyDao;
import org.project.netctoss.utils.BaseDao;

import java.util.Date;
import java.util.Set;

import org.hibernate.Query;
import org.project.netctoss.beans.ServiceBean;
import org.project.netctoss.beans.UserBean;
import org.project.netctoss.pojos.PagerBean;
import org.project.netctoss.servicemag.dao.IServiceBeanDao;
import org.project.netctoss.utils.BaseDao;
import org.springframework.stereotype.Repository;
@Repository
public class ServiceDailyDaoImpl extends BaseDao implements IServiceDailyDao {

	@Override
	public void saveServiceDailyBean(ServiceDailyBean sd) {
		// TODO Auto-generated method stub
			getSession().save(sd);
	}

	@Override
	public void deleteServiceDailyBean(ServiceDailyBean sd) {
		// TODO Auto-generated method stub
		getSession().delete(sd);
	}

	@Override
	public void updateServiceDailyBean(ServiceDailyBean sd) {
		// TODO Auto-generated method stub
		getSession().update(sd);
	}

	@Override
	public ServiceDailyBean getServiceDailyBeanByID(Long ID) {
		// TODO Auto-generated method stub
		return (ServiceDailyBean) getSession().get(ServiceDailyBean.class, ID);
	}

	@Override
	public ServiceDailyBean getServiceDailyBeanByLoginDate(Date loginDate) {
		// TODO Auto-generated method stub
		String hql ="From ServiceDailyBean as s where s.day  = ?";
		Query query =  getSession().createQuery(hql);
		query.setDate(0, loginDate);
		return (ServiceDailyBean) query.uniqueResult();
	}

}
