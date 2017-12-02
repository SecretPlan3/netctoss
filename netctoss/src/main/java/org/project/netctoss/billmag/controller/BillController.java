package org.project.netctoss.billmag.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.project.netctoss.beans.ServiceYearlyBean;
import org.project.netctoss.billmag.service.IBillService;
import org.project.netctoss.pojos.PagerBean;
import org.project.netctoss.utils.DateUtils;
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
		System.err.println(page);
		return page;
	}
	
	@RequestMapping(value="/findUserBill",method = { RequestMethod.GET },produces= {"application/json;charset=utf-8"})
	public PagerBean findUserBill(PagerBean page) {
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
	
	@RequestMapping(value="/findServiceTimeBill",method = { RequestMethod.GET },produces= {"application/json;charset=utf-8"})
	public PagerBean findServiceTimeBill(PagerBean page) {
		Date loginTime = DateUtils.parseDate(page.getParams().get("loginTime"));
		Date logoutTime = DateUtils.parseDate(page.getParams().get("logoutTime"));
		page.getParams().put("loginTime", loginTime);
		page.getParams().put("logoutTime", logoutTime);
		page = billServiceImpl.findAllServiceTimeBillByCondition(page);
		System.out.println(page);
		return page;
	}
	
}
