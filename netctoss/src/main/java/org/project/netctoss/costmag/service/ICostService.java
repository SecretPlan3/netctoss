package org.project.netctoss.costmag.service;

import org.project.netctoss.beans.CostBean;
import org.project.netctoss.pojos.PagerBean;

public interface ICostService {

	/**
	 * 增加资费套餐 （包括包月套餐/计时套餐/自助资费三种）
	 * 
	 * @param costBean
	 */
	public void insertCosts(CostBean costBean);

	/**
	 * 通过套餐编号查询资费套餐
	 * 
	 * @param costBean
	 * @return
	 */
	public CostBean selectCosts(long id);

	/**
	 * 删除资费套餐
	 * 
	 * @param costBean
	 */
	public void deleteCosts(CostBean costBean);

	/**
	 * 修改资费套餐（状态/资费金额等）
	 * 
	 * @param costBean
	 */
	public void updateCosts(CostBean costBean);

	/**
	 * 分页查询/模糊查询
	 * 
	 * @return
	 */
	public PagerBean findAllCostsByPager(PagerBean pager);
}
