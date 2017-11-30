package org.project.netctoss.costmag.controller;

import javax.annotation.Resource;

import org.project.netctoss.beans.CostBean;
import org.project.netctoss.costmag.service.ICostService;
import org.project.netctoss.pojos.PagerBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/cost")
@ResponseBody
public class CostController {
	@Resource
	private ICostService costServiceImpl;
	
	private String success = "操作成功！";
	private String failed = "操作失败！";
	
	@RequestMapping(value="/selectCost")
	public CostBean selectCosts(long id) {
		//通过资费套餐Id查询资费套餐
		System.out.println("进入CostController的selectCost方法");
		System.out.println("传入的ID为：" + id);
		CostBean costBean = costServiceImpl.selectCosts(id);
		System.out.println("查询后：" + costBean);
		return costBean;
	}
	
	@RequestMapping(value="/deleteCosts")
	public String deleteCosts(CostBean costBean) {
		//删除出资费套餐
		System.out.println("进入CostController的deleteCosts方法");
		System.out.println("传入的costBean:" + costBean);
		
		try {
			costServiceImpl.deleteCosts(costBean);
			return success;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return failed;
		}
	}
	
	@RequestMapping(value="/updateCosts")
	public String updateCosts(CostBean costBean) {
		//修改资费套餐
		System.out.println("进入CostController的updateCosts方法");
		System.out.println("传入的costBean:" + costBean);
				
		try {
			costServiceImpl.updateCosts(costBean);
			return success;
		} catch (Exception e) {
					// TODO: handle exception
			e.printStackTrace();
			return failed;
		}
	}
	
	@RequestMapping(value="/insertCosts")
	public String insertCosts(CostBean costBean) {
		//修改资费套餐
		System.out.println("进入CostController的insertCosts方法");
		System.out.println("传入的costBean:" + costBean);
						
		try {
			costServiceImpl.insertCosts(costBean);
			return success;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return failed;
		}	
	}
	
	@RequestMapping(value="/findAllCosts")
	public PagerBean findAllCostsByPager(PagerBean pager) {
		//查询所有的资费套餐
		System.out.println("进入CostController的findAllCostsByPager方法");
		System.out.println("传入的pager为：" + pager);
		pager = costServiceImpl.findAllCostsByPager(pager);
		System.out.println("查询后：" + pager);
		return pager;
	}
}
