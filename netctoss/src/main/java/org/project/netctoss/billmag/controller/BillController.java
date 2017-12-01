package org.project.netctoss.billmag.controller;

import java.util.List;

import javax.annotation.Resource;

import org.project.netctoss.beans.ServiceYearlyBean;
import org.project.netctoss.billmag.service.IBillService;
import org.project.netctoss.pojos.PagerBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value="/bill")
public class BillController {
	
	@Resource
	private IBillService billServiceImpl;
	 
	@RequestMapping(value="/findAllYear",method = { RequestMethod.GET },produces= {"application/json;charset=utf-8"})
	public PagerBean findAllYear(PagerBean page){
		page = billServiceImpl.findAllYear();
		return page;
	}
	
	@RequestMapping(value="/findUserBill",method = { RequestMethod.GET },produces= {"application/json;charset=utf-8"})
	public PagerBean findUserBill(PagerBean page) {
		System.err.println(page);
		page = billServiceImpl.findAllUserBillByCondition(page);
		System.err.println(page);
		return page;
	}
	
	@RequestMapping(value="/findServiceBill",method = { RequestMethod.GET },produces= {"application/json;charset=utf-8"})
	public PagerBean findServiceBill(PagerBean page) {
		
		Long userID = Long.parseLong((String) page.getParams().get("userID"));
		page.getParams().put("userID", userID);
		page = billServiceImpl.findAllServiceBillByCondition(page);
		System.err.println(page);
		return page;
	}
	
	
}
