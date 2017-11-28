package org.project.netctoss.billtimemag.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.project.netctoss.billtimemag.dao.IBillTimeDao;
import org.project.netctoss.pojos.PagerBean;
import org.project.netctoss.utils.BaseDao;

public class BillTimeDaoImpl  extends BaseDao implements IBillTimeDao{

	@Override
	public PagerBean findAllUsersBillTimeByCondition(PagerBean pb) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder( "from BillBean as b   left join fetch b.user as u    where 1=1");
		if (pb.getParams().get("userName") != null  ) {
			hql.append(	" and u.userName like CONCAT(:userName,'%') ");
		}
		if (pb.getParams().get("id") != null ) {
			hql.append("and u.id = :id ");
		}
		if (pb.getParams().get("idcard") != null ) {
			hql.append(	"and u.idcard = :idcard ");
		}
		if (pb.getParams().get("loginName") != null ) {
			hql.append(	"and u.loginName = :loginName ");
		}
		Query query = getSession().createQuery(hql.toString());// 这行代码，除了创建一个Query接口实例以外，例外一个作用就是预编译上面的HQL语句
		query.setProperties(pb.getParams());// 要求map键值对中的键，一定要跟我们这里参数别名，保持一致
		query.setFirstResult(pb.getIndex());//相当于limit第一个参数
		query.setMaxResults(pb.getRows());//相当于limit第二个参数
		
		List<?> list = query.list();
		pb.setDatas(list);
		
		return pb;
	}

	@Override
	public PagerBean findAllServicessBillTimeByCondition(PagerBean pb) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder( "from ServiceBillBean as s   left join fetch s.service as ser    left join fetch s.serviceYear as y    left join fetch y.serviceMonthly as m     left join fetch m.serviceDaily as d  where 1=1");//select new map(p.age as age,p.playerName as playerName,p.gender as gender) 
		if (pb.getParams().get("year") != null  ) {
			hql.append(	" and y.year =:year ");
		}
		if (pb.getParams().get("month") != null ) {
			hql.append("and m.month = :month ");
		}
		if (pb.getParams().get("id") != null ) {
			hql.append("and s.id = :id ");
		}
		Query query = getSession().createQuery(hql.toString());// 这行代码，除了创建一个Query接口实例以外，例外一个作用就是预编译上面的HQL语句
		query.setProperties(pb.getParams());// 要求map键值对中的键，一定要跟我们这里参数别名，保持一致
		query.setFirstResult(pb.getIndex());//相当于limit第一个参数
		query.setMaxResults(pb.getRows());//相当于limit第二个参数
		
		List<?> list = query.list();
		pb.setDatas(list);
		
		return pb;
	}

}
