package org.project.netctoss.billtimemag.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.project.netctoss.billtimemag.dao.IBillTimeDao;
import org.project.netctoss.pojos.PagerBean;
import org.project.netctoss.utils.BaseDao;
import org.springframework.stereotype.Repository;
@Repository
public class BillTimeDaoImpl  extends BaseDao implements IBillTimeDao{

	@Override
	public PagerBean findAllUsersBillTimeByCondition(PagerBean pb) {
		// TODO Auto-generated method stub
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

	//查询（业务id下的）所有业务 ，包括年、月、日 ，以及各自的总时长 和总花费
	@Override
	public PagerBean findAllServicesBillTimeByCondition(PagerBean pb) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder( "from ServiceBean as s   left join fetch s.cost as c  left join fetch s.user as u   left join fetch s.serviceYear as y    left join fetch y.serviceMonthly as m     left join fetch m.serviceDaily as d  where 1=1");//select new map(p.age as age,p.playerName as playerName,p.gender as gender) 
		if (pb.getParams().get("year") != null && ! pb.getParams().get("year").equals("") ) {
			hql.append(	" and y.year = :year ");
		}
		if (pb.getParams().get("month") != null && ! pb.getParams().get("month").equals("")  ) {
			hql.append(" and m.month = :month ");
		}
		if (pb.getParams().get("id") != null ) {
			hql.append(" and s.id = :id ");
		}
		if (pb.getParams().get("userId") != null  ) {
			hql.append(	" and u.userId like CONCAT(:userId,'%') ");
		}
		if (pb.getParams().get("userName") != null  ) {
			hql.append(	" and u.userName like CONCAT(:userName,'%') ");
		}

		Query query = getSession().createQuery(hql.toString());// 这行代码，除了创建一个Query接口实例以外，例外一个作用就是预编译上面的HQL语句
		query.setProperties(pb.getParams());// 要求map键值对中的键，一定要跟我们这里参数别名，保持一致
		query.setFirstResult(pb.getIndex());//相当于limit第一个参数
		query.setMaxResults(pb.getRows());//相当于limit第二个参数
		
		List<?> list = query.list();
		pb.setDatas(list);
		
		
		// 得到数据总数
		StringBuilder hql2 = new StringBuilder( "select count(*) from ServiceBean as s    left join s.cost as c    left join  s.serviceYear as y    left join  y.serviceMonthly as m     left join  m.serviceDaily as d  where 1=1");//select new map(p.age as age,p.playerName as playerName,p.gender as gender) 
		if (pb.getParams().get("year") != null  ) {
			hql2.append(	" and y.year =:year ");
		}
		if (pb.getParams().get("month") != null ) {
			hql2.append("and m.month = :month ");
		}
		if (pb.getParams().get("id") != null ) {
			hql2.append("and s.id = :id ");
		}
		if (pb.getParams().get("userId") != null  ) {
			hql.append(	" and u.userId like CONCAT(:userId,'%') ");
		}
		if (pb.getParams().get("userName") != null  ) {
			hql.append(	" and u.userName like CONCAT(:userName,'%') ");
		}
		query = getSession().createQuery(hql2.toString());
		query.setProperties(pb.getParams());
		pb.setTotalRows(Integer.valueOf(query.uniqueResult() + ""));
		
		return pb;
	}

}

