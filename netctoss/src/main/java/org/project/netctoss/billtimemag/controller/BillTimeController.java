package org.project.netctoss.billtimemag.controller;

import javax.annotation.Resource;

import org.project.netctoss.billtimemag.service.IBillTimeService;
import org.project.netctoss.billtimemag.service.impl.BillTimeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/billtime")
public class BillTimeController {
	
	@Resource
	private IBillTimeService BillTimeServiceImpl;
	
	@RequestMapping(value="/findAll")
	public ModelAndView findBillTeme() {
		
		
		return null;
		
	}
	
}
