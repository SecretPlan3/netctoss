package org.project.netctoss.logmag.service.impl;

import javax.annotation.Resource;

import org.project.netctoss.logmag.dao.ILogmagDao;
import org.project.netctoss.logmag.service.ILogmagService;
import org.project.netctoss.pojos.PagerBean;
import org.springframework.stereotype.Service;
@Service
public class LogmagServiceImpl implements ILogmagService {
	@Resource
	private ILogmagDao logmagDaoImpl;
	@Override
	public PagerBean findManagerLog(PagerBean pagerBean) {
		// TODO Auto-generated method stub
		return logmagDaoImpl.findManagerLog(pagerBean);
	}

	@Override
	public PagerBean findManagerOperationLog(PagerBean pagerBean) {
		// TODO Auto-generated method stub
		return logmagDaoImpl.findManagerOperationLog(pagerBean);
	}

}
