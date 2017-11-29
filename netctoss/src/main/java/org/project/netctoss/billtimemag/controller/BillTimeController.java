package org.project.netctoss.billtimemag.controller;

import javax.annotation.Resource;

import org.project.netctoss.billtimemag.service.IBillTimeService;
import org.project.netctoss.billtimemag.service.impl.BillTimeServiceImpl;
import org.project.netctoss.pojos.PagerBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/billtime")
public class BillTimeController {
	
	@Resource
	private IBillTimeService billTimeServiceImpl;
	
	@RequestMapping(value="/findAll")
	public PagerBean findBillTeme(PagerBean pb) {
		//查询所有用户账号
		System.out.println("进入了findAllController");
		System.out.println("查询前"+pb);
		pb = billTimeServiceImpl.findAllUsersBillTimeByCondition(pb);
		System.out.println("查询后"+pb);
		return pb;
	}
	
}
