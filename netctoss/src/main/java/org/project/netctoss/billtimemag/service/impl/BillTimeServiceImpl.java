package org.project.netctoss.billtimemag.service.impl;

import javax.annotation.Resource;

import org.project.netctoss.billtimemag.dao.IBillTimeDao;
import org.project.netctoss.billtimemag.service.IBillTimeService;
import org.project.netctoss.pojos.PagerBean;
import org.springframework.stereotype.Service;

@Service
public class BillTimeServiceImpl implements IBillTimeService{
	
	@Resource
	private IBillTimeDao billTimeDaoImpl;
	
	@Override
	public PagerBean findAllUsersBillTimeByCondition(PagerBean page) {
		// TODO Auto-generated method stub
		return billTimeDaoImpl.findAllUsersBillTimeByCondition(page);
	}

	@Override
	public PagerBean findAllServicesBillTimeByCondition(PagerBean page) {
		// TODO Auto-generated method stub
		return billTimeDaoImpl.findAllServicesBillTimeByCondition(page);
	}

}
