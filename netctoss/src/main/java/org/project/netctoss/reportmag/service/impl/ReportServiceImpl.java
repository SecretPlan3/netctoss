package org.project.netctoss.reportmag.service.impl;

import javax.annotation.Resource;

import org.project.netctoss.pojos.PagerBean;
import org.project.netctoss.reportmag.dao.IReportDao;
import org.project.netctoss.reportmag.service.IReportService;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements IReportService {
	
	@Resource
	private IReportDao reportDaoImpl;
	
	@Override
	public PagerBean findAllYear(PagerBean page) {
		// TODO Auto-generated method stub
		return reportDaoImpl.findAllYear(page);
	}

	@Override
	public PagerBean findAllServiceByUser(PagerBean page) {
		// TODO Auto-generated method stub
		return reportDaoImpl.findAllServiceByUser(page);
	}

}
