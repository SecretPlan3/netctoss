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
	public ModelAndView findBillTeme(PagerBean pb) {
		ModelAndView mv= new ModelAndView();
		//
		
		pb = billTimeServiceImpl.findAllUsersBillTimeByCondition(pb);
		mv.addObject("pb", pb);
		mv.setViewName("jsp/billtime/billtimemain");
		return mv;
		
	}
	
}
