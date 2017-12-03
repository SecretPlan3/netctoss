package org.project.netctoss.usermag.dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.project.netctoss.beans.UserBean;
import org.project.netctoss.pojos.PagerBean;
import org.project.netctoss.usermag.dao.IUserDao;
import org.project.netctoss.utils.BaseDao;
import org.springframework.stereotype.Repository;
@Repository
public class UserDaoImpl extends BaseDao implements IUserDao {

	

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
	
	public PagerBean findUserByPager(PagerBean pb) {
		StringBuilder hql = new StringBuilder( "from UserBean as u  where 1=1");
		if (pb.getParams().get("id") != null ) {
			hql.append("and u.id like CONCAT(:id ,'%') ");
		}
		if (pb.getParams().get("userName") != null  ) {
			hql.append(	" and u.userName like CONCAT(:userName,'%') ");
		}
		if (pb.getParams().get("idcard") != null ) {
			hql.append(	"and u.idcard like CONCAT(:idcard ,'%')");
		}
		if (pb.getParams().get("loginName") != null ) {
			hql.append(	"and u.loginName like CONCAT(:loginName ,'%') ");
		}
		Query query = getSession().createQuery(hql.toString());// 这行代码，除了创建一个Query接口实例以外，例外一个作用就是预编译上面的HQL语句
		query.setProperties(pb.getParams());// 要求map键值对中的键，一定要跟我们这里参数别名，保持一致
		query.setFirstResult(pb.getIndex());//相当于limit第一个参数
		query.setMaxResults(pb.getRows());//相当于limit第二个参数
		
		List<?> list = query.list();
		pb.setDatas(list);

		// 得到数据总数
		hql = new StringBuilder( "select count(*) from UserBean as u  where 1=1 ");
		if (pb.getParams().get("id") != null ) {
			hql.append("and u.id like CONCAT(:id ,'%') ");
		}
		if (pb.getParams().get("userName") != null  ) {
			hql.append(	" and u.userName like CONCAT(:userName,'%') ");
		}
		if (pb.getParams().get("idcard") != null ) {
			hql.append(	"and u.idcard like CONCAT(:idcard ,'%')");
		}
		if (pb.getParams().get("loginName") != null ) {
			hql.append(	"and u.loginName like CONCAT(:loginName ,'%') ");
		}
		query = getSession().createQuery(hql.toString());
		query.setProperties(pb.getParams());
		pb.setTotalRows(Integer.valueOf(query.uniqueResult() + ""));
		
		return pb;
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
		String hql = "From UserBean  as b  left join fetch b.roler as r   left join fetch r.pers  as p    where b.loginName like CONCAT(?,'%') ";
		Query query = getSession().createQuery(hql);
		query.setString(0, LoginName);
		return  (UserBean) query.uniqueResult();//;
	}

	@Override
	public void addUsersById(Set<UserBean> users) {
		// TODO Auto-generated method stub
		
	}
	
}
