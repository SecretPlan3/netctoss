package org.project.netctoss.billmag.controller;

import javax.annotation.Resource;

import org.project.netctoss.billmag.service.IBillService;
import org.project.netctoss.pojos.PagerBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/bill")
public class BillController {
	
	@Resource
	private IBillService billServiceImpl;
	
	@RequestMapping(value="/findUserBill",method = { RequestMethod.GET },produces= {"application/json;charset=utf-8"})
	public PagerBean findUserBill(PagerBean pb) {
		System.out.println(pb);
		pb = billServiceImpl.findAllUserBillByCondition(pb);
		return pb;
	} 
	
}
