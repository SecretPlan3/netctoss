package org.project.netctoss.permissionmag.service.serviceImpl;

import javax.annotation.Resource;

import org.project.netctoss.beans.PermissionBean;
import org.project.netctoss.permissionmag.dao.IPermissionDao;
import org.project.netctoss.permissionmag.service.IPermissionService;
import org.project.netctoss.pojos.PagerBean;
import org.springframework.stereotype.Service;
@Service
public class PermissionServiceImpl implements IPermissionService {

	@Resource
	private IPermissionDao permissionDaoImpl;
	
	public void addOrUpdatePermission(PermissionBean permissionBean) {
		// TODO Auto-generated method stub
		permissionDaoImpl.addOrUpdatePermission(permissionBean);
	}

	public void deletePermissionById(PermissionBean permissionBean) {
		// TODO Auto-generated method stub
		permissionDaoImpl.deletePermissionById(permissionBean);
	}

	public PermissionBean selectPermissionById(Long id) {
		// TODO Auto-generated method stub
		return permissionDaoImpl.selectPermissionById(id);
	}

	public PagerBean findAllPermissionsByPager(PagerBean pager) {
		// TODO Auto-generated method stub
		
		return permissionDaoImpl.findAllPermissionsByPager(pager);
	}

}
