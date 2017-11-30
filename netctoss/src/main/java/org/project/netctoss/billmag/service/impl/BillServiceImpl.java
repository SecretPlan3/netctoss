package org.project.netctoss.billmag.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.project.netctoss.beans.ServiceYearlyBean;
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
		return billDaoImpl.findAllUserBillByCondition(page);
	}
 
	@Override
	public PagerBean findAllServiceBillByCondition(PagerBean page) {
		// TODO Auto-generated method stub
		return billDaoImpl.findAllServiceBillByCondition(page);
	}

	@Override
	public PagerBean findAllServiceTimeBillByCondition(PagerBean page) {
		// TODO Auto-generated method stub
		return billDaoImpl.findAllServiceTimeBillByCondition(page);
	}

	@Override
	public PagerBean findAllYear() {
		// TODO Auto-generated method stub
		return billDaoImpl.findAllYear();
	}

}
