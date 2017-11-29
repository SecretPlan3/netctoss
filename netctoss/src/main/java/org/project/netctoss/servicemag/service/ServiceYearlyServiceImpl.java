package org.project.netctoss.servicemag.service;

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
public class ServiceYearlyServiceImpl extends BaseDao implements IServiceYearlyDao {

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
	public ServiceYearlyBean getServiceYearlyBeanByYear(String year) {
		// TODO Auto-generated method stub
		String hql = "From ServiceYearlyBean as s where s.year=?";
		Query query = getSession().createQuery(hql);
		query.setString(0, year);
		return (ServiceYearlyBean) query.uniqueResult();
	}

}
