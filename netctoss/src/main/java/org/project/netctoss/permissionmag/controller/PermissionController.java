package org.project.netctoss.permissionmag.controller;

import javax.annotation.Resource;

import org.project.netctoss.beans.PermissionBean;
import org.project.netctoss.permissionmag.service.IPermissionService;
import org.project.netctoss.pojos.PagerBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/permissionmag")
@RestController
public class PermissionController {

	@Resource
	private IPermissionService permissionServiceImpl;

	/**
	 * 添加或修改
	 * 
	 * @param managerbean
	 * @return
	 */
	@RequestMapping(value = "/permissionadd", method = RequestMethod.POST)
	public void manageraddorupdate(PermissionBean permissionBean) {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + permissionBean);
		permissionServiceImpl.addOrUpdatePermission(permissionBean);
		;
	}

	/**
	 * 删除一个权限
	 * 
	 * @param managerbean
	 */
	@RequestMapping(value = "/permissiondelete", method = RequestMethod.POST)
	public void userdel(PermissionBean permissionBean) {
		System.out.println("~~~~~~~~~~~~~~~~~~~" + permissionBean);
		permissionServiceImpl.deletePermissionById(permissionBean);
	}

	/**
	 * 查询单个
	 * 
	 * @return
	 */
	@RequestMapping(value = "/findone", method = RequestMethod.POST)
	public PermissionBean userquery(Long id) {
		System.out.println("进入了查询单个方法，id：" + id);
		PermissionBean pb = permissionServiceImpl.selectPermissionById(id);
		System.out.println("查到的单个ManagerBean：" + pb);
		return pb; 
	}

	/**
	 * 查询所有
	 * 
	 * @param pagerBean
	 * @return
	 */
	@RequestMapping(value = "/findall", method = RequestMethod.POST)
	public PagerBean userqueryall(PagerBean pager) {
		System.out.println("进入了查询所有方法，id：" + pager);
		PagerBean pb = permissionServiceImpl.findAllPermissionsByPager(pager);
		System.out.println("查到的pager：" + pb.getDatas().size());
		return pb;
	}

}
