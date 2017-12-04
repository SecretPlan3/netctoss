package org.project.netctoss.reportmag.service;

import org.project.netctoss.pojos.PagerBean;

public interface IReportService {
	
	public PagerBean findAllYear(PagerBean page);
	
	public PagerBean findAllServiceByUser(PagerBean page);
	
}
