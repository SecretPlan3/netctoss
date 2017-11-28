package org.project.netctoss.permissionmag.dao;

import org.project.netctoss.beans.PermissionBean;
import org.project.netctoss.pojos.PagerBean;

public interface IPermissionDao {

	/**
	 * 添加或者修改一个权限
	 * @param manegerbean
	 */
	public void addOrUpdatePermission(PermissionBean permissionBean);
	
	
	/**
	 * 根据id删除一个权限
	 * @param id
	 */
	public void deletePermissionById(PermissionBean permissionBean);
	
	
	/**
	 * 根据id查看权限的具体信息
	 * @param id
	 * @return
	 */
	public PermissionBean selectPermissionById(Long id);
	
	
	/**
	 * 分页+模糊查询
	 * @return
	 */
	public PagerBean findAllPermissionsByPager(PagerBean pager);
}
