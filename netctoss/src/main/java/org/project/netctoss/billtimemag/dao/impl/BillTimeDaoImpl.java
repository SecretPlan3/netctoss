package org.project.netctoss.billtimemag.dao.impl;

import org.hibernate.Query;
import org.project.netctoss.billtimemag.dao.IBillTimeDao;
import org.project.netctoss.pojos.PagerBean;
import org.project.netctoss.utils.BaseDao;

public class BillTimeDaoImpl  extends BaseDao implements IBillTimeDao{

	@Override
	public PagerBean findAllUsersBillTimeByCondition(PagerBean pb) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder( "from PlayerBean as p left join fetch p.teamBean as t where 1=1");//select new map(p.age as age,p.playerName as playerName,p.gender as gender) 
//		if (pb.getParams().get("playerName") != null  ) {
//			hql.append(	" and p.playerName like CONCAT(:playerName,'%') ");
//		}
//		if (pb.getMap().get("age") != null ) {
//			hql.append("and p.age = :age ");
//		}
//		if (pb.getMap().get("gender") != null ) {
//			hql.append(	"and p.gender = :gender ");
//		}
//		if (pb.getMap().get("teamName") != null ) {
//			hql.append(	"and t.teamName = :teamName ");
//		}
		Query query = getSession().createQuery(hql.toString());// 这行代码，除了创建一个Query接口实例以外，例外一个作用就是预编译上面的HQL语句
//		query.setProperties(pb.getMap());// 要求map键值对中的键，一定要跟我们这里参数别名，保持一致
//		query.setFirstResult(pb.getBeginRow());//相当于limit第一个参数
//		query.setMaxResults(pb.getRow());//相当于limit第二个参数
		return null;
	}

	@Override
	public PagerBean findAllServicessBillTimeByCondition(PagerBean page) {
		// TODO Auto-generated method stub
		return null;
	}

}
