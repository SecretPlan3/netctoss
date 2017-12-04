package org.project.netctoss.reportmag.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.project.netctoss.beans.ServiceBean;
import org.project.netctoss.beans.ServiceVO;
import org.project.netctoss.beans.UserBean;
import org.project.netctoss.pojos.PagerBean;
import org.project.netctoss.reportmag.service.IReportService;
import org.project.netctoss.servicemag.service.IServiceBeanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/report")
public class ReportController {
	
	@Resource
	private IReportService reportServiceImpl;
	@Resource
	private IServiceBeanService serviceBeanServiceImpl;
	
	@RequestMapping(value="/findAllYear",method = { RequestMethod.GET },produces= {"application/json;charset=utf-8"})
	public PagerBean findAllYear(PagerBean page) {
		
		return null;
	}
	
	@RequestMapping(value="/findAllServcie",method = { RequestMethod.GET },produces= {"application/json;charset=utf-8"})
	public PagerBean findAllServcie(PagerBean page) {
		UserBean ub = new UserBean();
		ub.setUserId(Long.parseLong((String) page.getParams().get("userID")));
		Set<ServiceBean> serviceList = serviceBeanServiceImpl.getServiceBeansByUserBean(ub);
		List<ServiceVO> allService = new ArrayList<>();
		for (ServiceBean serviceBean : serviceList) {
			ServiceVO service = new ServiceVO();
			service.setId(serviceBean.getId());
			service.setOsName(serviceBean.getOsName());
			service.setUnixHost(serviceBean.getUnixHost());
			allService.add(service);
		}
		
		page.setDatas(allService);

		System.out.println(page);
		return page;
	}
}
