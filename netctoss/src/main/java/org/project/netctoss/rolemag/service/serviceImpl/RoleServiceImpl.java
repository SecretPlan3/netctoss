package org.project.netctoss.rolemag.service.serviceImpl;

import javax.annotation.Resource;

import org.project.netctoss.beans.RoleBean;
import org.project.netctoss.pojos.PagerBean;
import org.project.netctoss.rolemag.dao.IRoleDao;
import org.project.netctoss.rolemag.service.IRoleService;
import org.springframework.stereotype.Service;
@Service
public class RoleServiceImpl implements IRoleService {

	@Resource
	private IRoleDao roleDaoImpl;
	
	public void addOrUpdateRole(RoleBean roleBean) {
		// TODO Auto-generated method stub
		roleDaoImpl.addOrUpdateRole(roleBean);
	}

	public void deleteRoleById(RoleBean roleBean) {
		// TODO Auto-generated method stub
		roleDaoImpl.deleteRoleById(roleBean);
	}

	public RoleBean selectRoleById(Long id) {
		// TODO Auto-generated method stub
		return roleDaoImpl.selectRoleById(id);
	}

	public PagerBean findAllRolesByPager(PagerBean pager) {
		// TODO Auto-generated method stub
		
		return roleDaoImpl.findAllRolesByPager(pager);
	}

}
