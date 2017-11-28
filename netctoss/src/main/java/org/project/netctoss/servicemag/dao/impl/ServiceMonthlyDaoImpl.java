package org.project.netctoss.servicemag.dao.impl;

import org.project.netctoss.beans.ServiceMonthlyBean;
import org.project.netctoss.servicemag.dao.IServiceMonthlyDao;
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
public class ServiceMonthlyDaoImpl extends BaseDao implements IServiceMonthlyDao {

	@Override
	public void saveServiceMonthlyBean(ServiceMonthlyBean sd) {
		// TODO Auto-generated method stub
			getSession().save(sd);
	}

	@Override
	public void deleteServiceMonthlyBean(ServiceMonthlyBean sd) {
		// TODO Auto-generated method stub
		getSession().delete(sd);
	}

	@Override
	public void updateServiceMonthlyBean(ServiceMonthlyBean sd) {
		// TODO Auto-generated method stub
		getSession().update(sd);
	}

	@Override
	public ServiceMonthlyBean getServiceMonthlyBeanByID(Long ID) {
		// TODO Auto-generated method stub
		return (ServiceMonthlyBean) getSession().get(ServiceMonthlyBean.class, ID);
	}

}
