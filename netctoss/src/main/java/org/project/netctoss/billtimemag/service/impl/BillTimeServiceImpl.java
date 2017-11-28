package org.project.netctoss.billtimemag.service.impl;

import javax.annotation.Resource;

import org.project.netctoss.billtimemag.service.IBillTimeService;
import org.project.netctoss.pojos.PagerBean;
import org.springframework.stereotype.Service;

@Service
public class BillTimeServiceImpl implements IBillTimeService{
	
	@Resource
	private IBillTimeService billTimeServiceImpl;
	
	@Override
	public PagerBean findAllUsersBillTimeByCondition(PagerBean page) {
		// TODO Auto-generated method stub
		return billTimeServiceImpl.findAllUsersBillTimeByCondition(page);
	}

	@Override
	public PagerBean findAllServicessBillTimeByCondition(PagerBean page) {
		// TODO Auto-generated method stub
		return billTimeServiceImpl.findAllServicessBillTimeByCondition(page);
	}

}
