package org.project.netctoss.logmag.controller;

import javax.annotation.Resource;

import org.project.netctoss.logmag.service.ILogmagService;
import org.project.netctoss.pojos.PagerBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/logmag")
@ResponseBody
public class LogmagController {
	@Resource
	private ILogmagService logmagService;
	
	@RequestMapping(value="/findManagerLog")
	public @ResponseBody PagerBean findAllCostsByPager(PagerBean pager) {
		//查询所有的资费套餐
		System.out.println("进入LogmagController的findManagerLog方法");
		System.out.println("传入的pager为：" + pager);
		int page = pager.getPage() <= 0 ?1:pager.getPage();
		int rows = pager.getRows() <= 0 ?5:pager.getRows();
		pager.setPage(page);
		pager.setRows(rows);
		pager = logmagService.findManagerLog(pager);
		System.out.println("查询后：" + pager);
		return pager;
	}
	
	@RequestMapping(value="/findManagerOperationLog")
	public @ResponseBody PagerBean findManagerOperationLog(PagerBean pager) {
		//查询所有的资费套餐
		System.out.println("进入LogmagController的findManagerOperationLog方法");
		System.out.println("传入的pager为：" + pager);
		int page = pager.getPage() <= 0 ?1:pager.getPage();
		int rows = pager.getRows() <= 0 ?5:pager.getRows();
		pager.setPage(page);
		pager.setRows(rows);
		pager = logmagService.findManagerOperationLog(pager);
		System.out.println("查询后：" + pager);
		return pager;
	}
}
