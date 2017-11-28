package org.project.netctoss.usermag.dao.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.project.netctoss.beans.UserBean;
import org.project.netctoss.pojos.PagerBean;
import org.project.netctoss.usermag.dao.UserDao;
import org.project.netctoss.utils.BaseDao;

public class UserDaoImpl extends BaseDao implements UserDao {

	

	@Override
	public UserBean findUserById(Long id) {  
		
		// TODO Auto-generated method stub
		return (UserBean)getSession().get(UserBean.class, id);
	}

	public void deleteUserById(UserBean user) {
		// TODO Auto-generated method stub
		getSession().delete(user);
	}

	public void addUser(UserBean user) {
		// TODO Auto-generated method stub
		 getSession().save(user);
	}

	public void updateUser(UserBean user) {
		// TODO Auto-generated method stub
		getSession().update(user);
	}
	
	public PagerBean findUserByPager(PagerBean pager) {
		String hql = "select count(b.id) from UserBean as b where b.userName like CONCAT(?,'%') and b.loginName like CONCAT(?,'%') and b.idcard like CONCAT(?,'%') and b.status like CONCAT(?,'%')";
		Query query = getSession().createQuery(hql);
		query.setString(0, pager.getParams().get("userName").toString());
		query.setString(1, pager.getParams().get("loginName").toString());
		query.setString(1, pager.getParams().get("idcard").toString());
		query.setString(1, pager.getParams().get("status").toString());
		long totalRows = (Long) query.uniqueResult();
		pager.setTotalRows(Integer.valueOf(String.valueOf(totalRows)));
		
		hql = "From UserBean as b where b.userName like CONCAT(?,'%') and b.loginName like CONCAT(?,'%') and b.idcard like CONCAT(?,'%') and b.status like CONCAT(?,'%')";
		query = getSession().createQuery(hql);
		query.setString(0, pager.getParams().get("userName").toString());
		query.setString(1, pager.getParams().get("loginName").toString());
		query.setString(1, pager.getParams().get("idcard").toString());
		query.setString(1, pager.getParams().get("status").toString());
		query.setFirstResult(pager.getIndex());
		query.setMaxResults(pager.getRows());
		List<?> datas = query.list();
		pager.setDatas(datas);
		return pager;
	}

	
	public UserBean findUserByLoginNameAndPassword(String loginName,String passWord) {
		// TODO Auto-generated method stub
		String hql = "From UserBean as b where b.loginName like CONCAT(?,'%') and b.passWord like CONCAT(?,'%')";
		Query query = getSession().createQuery(hql);
		query.setString(0, loginName);
		query.setString(1, passWord);
		return  (UserBean) query.uniqueResult();//;
	}
	

	public UserBean findUserByLoginName(String LoginName) {
		String hql = "From UserBean as b where b.loginName like CONCAT(?,'%') ";
		Query query = getSession().createQuery(hql);
		query.setString(0, LoginName);
		return  (UserBean) query.uniqueResult();//;
	}
	
}
