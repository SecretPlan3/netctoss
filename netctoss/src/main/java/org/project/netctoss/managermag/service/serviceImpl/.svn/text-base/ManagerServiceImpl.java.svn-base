package org.project.netctoss.managermag.service.serviceImpl;

import javax.annotation.Resource;

import org.project.netctoss.beans.ManagerBean;
import org.project.netctoss.managermag.dao.IManagerDao;
import org.project.netctoss.managermag.service.IManagerService;
import org.project.netctoss.pojos.PagerBean;
import org.springframework.stereotype.Service;


@Service
public class ManagerServiceImpl implements IManagerService {

	@Resource
	private IManagerDao managerImpl;
	
	public void addOrUpdateManeger(ManagerBean managerbean) {
		// TODO Auto-generated method stub
		managerImpl.addOrUpdateManeger(managerbean);
	}

	public void deleteManegerById(ManagerBean managerbean) {
		// TODO Auto-generated method stub
		managerImpl.deleteManegerById(managerbean);
	}

	public ManagerBean selectManegerById(Long id) {
		// TODO Auto-generated method stub
		return managerImpl.selectManegerById(id);
	}

	public PagerBean findAllManagersByPager(PagerBean pager) {
		// TODO Auto-generated method stub
		
		return managerImpl.findAllManagersByPager(pager);
	}

}
