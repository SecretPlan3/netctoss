package org.project.netctoss.costmag.service.impl;

import javax.annotation.Resource;

import org.project.netctoss.beans.CostBean;
import org.project.netctoss.costmag.dao.ICostDao;
import org.project.netctoss.costmag.service.ICostService;
import org.project.netctoss.pojos.PagerBean;
import org.springframework.stereotype.Service;
@Service
public class CostServiceImpl implements ICostService {
	@Resource
	private ICostDao costDaoImpl;
	@Override
	public void insertCosts(CostBean costBean) {
		// TODO Auto-generated method stub
		costDaoImpl.insertCosts(costBean);
	}

	@Override
	public CostBean selectCosts(long id) {
		// TODO Auto-generated method stub
		return costDaoImpl.selectCosts(id);
	}

	@Override
	public void deleteCosts(CostBean costBean) {
		// TODO Auto-generated method stub
		costDaoImpl.deleteCosts(costBean);
	}

	@Override
	public void updateCosts(CostBean costBean) {
		// TODO Auto-generated method stub
		costDaoImpl.updateCosts(costBean);
	}

	@Override
	public PagerBean findAllCostsByPager(PagerBean pager) {
		// TODO Auto-generated method stub
		return costDaoImpl.findAllCostsByPager(pager);
	}

}
