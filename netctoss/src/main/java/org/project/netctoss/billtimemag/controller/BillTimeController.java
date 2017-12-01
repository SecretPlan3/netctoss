package org.project.netctoss.billtimemag.controller;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.jboss.logging.annotations.Param;
import org.project.netctoss.beans.ServiceBean;
import org.project.netctoss.beans.ServiceDailyBean;
import org.project.netctoss.beans.ServiceMonthlyBean;
import org.project.netctoss.beans.ServiceYearlyBean;
import org.project.netctoss.billtimemag.service.IBillTimeService;
import org.project.netctoss.billtimemag.service.impl.BillTimeServiceImpl;
import org.project.netctoss.pojos.PagerBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/billtime")
public class BillTimeController {
	
	@Resource
	private IBillTimeService billTimeServiceImpl;
	
	@RequestMapping(value="/findAll")
	public @ResponseBody PagerBean findAllBillTime(PagerBean pb) {
		//查询所有用户账号
		System.out.println("进入了用户查询");
		System.out.println("查询前1"+pb);
		int page = pb.getPage() <= 0 ?1:pb.getPage();
		int rows = pb.getRows() <= 0 ?5:pb.getRows();
		pb.setPage(page);
		pb.setRows(rows);
		System.out.println("查询前2"+pb);
		pb = billTimeServiceImpl.findAllUsersBillTimeByCondition(pb);
		System.out.println("查询后"+pb);
		return pb;
	}
	
	@RequestMapping(value="/monthly")
	public ModelAndView BillTimeMonthly(Long userId){
		System.out.println("首次进入月查询");
		System.out.println("id" + userId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("userId", userId);
		mv.setViewName("jsp/billtime/billtimeDetailMonthly");
		return mv;
	}
	
	@RequestMapping(value="/findMonthly")
	public @ResponseBody PagerBean findBillTimeMonthly(PagerBean pb) {
		//查询所有用户账号
		System.out.println("ajax进入了 月查询");
		System.out.println("查询前1"+pb);
		int page = pb.getPage() <= 0 ?1:pb.getPage();
		int rows = pb.getRows() <= 0 ?5:pb.getRows();
		pb.setPage(page);
		pb.setRows(rows);
		System.out.println("查询前2"+pb);
		pb = billTimeServiceImpl.findAllServicesBillTimeByCondition(pb);
		List<?> list = pb.getDatas();
		for (int i = 0; i < list.size(); i++) {
			ServiceBean sb =  (ServiceBean) list.get(i);
			System.out.println("业务bean " + sb) ;
			System.out.println("用户bean " + sb.getUser()) ;
			
			
			Set<ServiceYearlyBean> ys = sb.getServiceYear();
			for (ServiceYearlyBean y : ys) {
				System.out.println("\t年bean " + y) ;
				
				Set<ServiceMonthlyBean> ms = y.getServiceMonthly();
				for (ServiceMonthlyBean m : ms) {
					System.out.println("\t \t 月bean " + m) ;
					
//					Set<ServiceDailyBean> ds = m.getServiceDaily();
//					for (ServiceDailyBean d : ds) {
//						System.out.println("\t \t \t 日bean " + d) ;
//						
//					}
				}
			}
			}
		System.out.println("查询后"+pb);
		return pb;
	}
	
	@RequestMapping(value="/daily")
	public ModelAndView BillTimeDaily(Long serviceId){
		System.out.println("首次进入日查询");
		System.out.println("id" + serviceId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("serviceId", serviceId);
		mv.setViewName("jsp/billtime/billtimeDetailDaily");
		return mv;
	}
	
	@RequestMapping(value="/findDaily")
	public @ResponseBody PagerBean findBillTimeDaily(PagerBean pb) {
		//查询所有用户账号
		System.out.println("ajax进入了 日查询");
		System.out.println("查询前1"+pb);
		int page = pb.getPage() <= 0 ?1:pb.getPage();
		int rows = pb.getRows() <= 0 ?5:pb.getRows();
		pb.setPage(page);
		pb.setRows(rows);
		System.out.println("查询前2"+pb);
		pb = billTimeServiceImpl.findAllServicesBillTimeByCondition(pb);
		List<?> list = pb.getDatas();
		for (int i = 0; i < list.size(); i++) {
			ServiceBean sb =  (ServiceBean) list.get(i);
			System.out.println("业务bean " + sb) ;
			System.out.println("用户bean " + sb.getUser()) ;
			
			Set<ServiceYearlyBean> ys = sb.getServiceYear();
			for (ServiceYearlyBean y : ys) {
				System.out.println("\t年bean " + y) ;
				
				Set<ServiceMonthlyBean> ms = y.getServiceMonthly();
				for (ServiceMonthlyBean m : ms) {
					System.out.println("\t \t 月bean " + m) ;
					
					Set<ServiceDailyBean> ds = m.getServiceDaily();
					for (ServiceDailyBean d : ds) {
						System.out.println("\t \t \t 日bean " + d) ;
						
					}
				}
			}
		}
		System.out.println("查询后"+pb);
		return pb;
	}
}
