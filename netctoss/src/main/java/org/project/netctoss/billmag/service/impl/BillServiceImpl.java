package org.project.netctoss.billmag.service.impl;

import javax.annotation.Resource;

import org.project.netctoss.billmag.dao.IBillDao;
import org.project.netctoss.billmag.service.IBillService;
import org.project.netctoss.pojos.PagerBean;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements IBillService {
	
	@Resource
	private IBillDao billDaoImpl;

	@Override
	public PagerBean findAllUserBillByCondition(PagerBean page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagerBean findAllServiceBillByCondition(PagerBean page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagerBean findAllServiceTimeBillByCondition(PagerBean page) {
		// TODO Auto-generated method stub
		return null;
	}

}
