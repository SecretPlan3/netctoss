package org.project.netctoss.servicemag.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.project.netctoss.beans.ServiceBean;
import org.project.netctoss.beans.UserBean;
import org.project.netctoss.pojos.PagerBean;
import org.project.netctoss.servicemag.dao.IServiceBeanDao;
import org.project.netctoss.utils.BaseDao;
import org.springframework.stereotype.Repository;
@Repository
public class ServiceBeanDaoImpl extends BaseDao  implements IServiceBeanDao  {

	@Override
	public void saveServiceBean(ServiceBean sb) {
		// TODO Auto-generated method stub
        getSession().save(sb);
	}

	@Override
	public void updateServiceBean(ServiceBean sb) {
		// TODO Auto-generated method stub
		getSession().update(sb);
	}

	@Override
	public void deleteServiceBean(ServiceBean sb) {
		// TODO Auto-generated method stub
		getSession().delete(sb);
	}

	@Override
	public ServiceBean getServiceBeanByID(Long ID) {
		// TODO Auto-generated method stub
		return (ServiceBean) getSession().get(ServiceBean.class, ID);
	}

	@Override
	public Set<ServiceBean> getServiceBeansByUserBean(UserBean ub) {
		// TODO Auto-generated method stub
		
		String hql ="From ServiceBean as s left join fetch s.user as u where u.id=?";
//		if(ub.getLoginName() != null || "".equals(ub.getLoginName())==false) {
//			hql = hql+" and u.loginName =:loginName";
//		}
		Query query = getSession().createQuery(hql);
		query.setLong(0, ub.getUserId());
		Set result = new HashSet(query.list());
		return result;
	}

	@Override
	public ServiceBean getServiceBeanByOsName(String osName) {
		// TODO Auto-generated method stub
		String hql = "From ServiceBean as s where s.osName =?";
		Query query = getSession().createQuery(hql);
		query.setString(0, osName);
		return (ServiceBean) query.uniqueResult();
	}

//	@Override
//	public PagerBean getServiceBeansByPage(PagerBean page) {
//		// TODO Auto-generated method stub
//		 
//		return null;
//	}

}
