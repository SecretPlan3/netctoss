package org.project.netctoss.rolemag.service;



import org.project.netctoss.beans.RoleBean;
import org.project.netctoss.pojos.PagerBean;



public interface IRoleService {

	/**
	 * 添加或者修改一个角色
	 * @param manegerbean
	 */
	public void addOrUpdateRole(RoleBean roleBean);
	
	
	/**
	 * 根据id删除一个角色
	 * @param id
	 */
	public void deleteRoleById(RoleBean roleBean);
	
	
	/**
	 * 根据id查看权限的具体信息
	 * @param id
	 * @return
	 */
	public RoleBean selectRoleById(Long id);
	
	
	/**
	 * 分页+模糊查询
	 * @return
	 */
	public PagerBean findAllRolesByPager(PagerBean pager);
}
