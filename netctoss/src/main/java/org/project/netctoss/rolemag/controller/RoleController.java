package org.project.netctoss.rolemag.controller;

import javax.annotation.Resource;

import org.project.netctoss.beans.RoleBean;
import org.project.netctoss.pojos.PagerBean;
import org.project.netctoss.rolemag.service.IRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/rolemag")
@RestController
public class RoleController {

	@Resource
	private IRoleService roleServiceImpl;

	/**
	 * 添加或修改
	 * 
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/roleadd", method = RequestMethod.POST)
	public void manageraddorupdate(RoleBean roleBean) {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + roleBean);
		roleServiceImpl.addOrUpdateRole(roleBean);
		;
	}

	/**
	 * 删除一个角色
	 * 
	 * @param 
	 */
	@RequestMapping(value = "/roledelete", method = RequestMethod.POST)
	public void userdel(RoleBean roleBean) {
		System.out.println("~~~~~~~~~~~~~~~~~~~" + roleBean);
		roleServiceImpl.deleteRoleById(roleBean);
	}

	/**
	 * 查询单个
	 * 
	 * @return
	 */
	@RequestMapping(value = "/findone", method = RequestMethod.POST)
	public RoleBean userquery(Long id) {
		System.out.println("进入了查询单个方法，id：" + id);
		RoleBean rb = roleServiceImpl.selectRoleById(id);
		System.out.println("查到的单个ManagerBean：" + rb);
		return rb;
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
		PagerBean pb = roleServiceImpl.findAllRolesByPager(pager);
		System.out.println("查到的pager：" + pb.getDatas().size());
		return pb; 
	}

}
