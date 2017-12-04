package org.project.netctoss.reportmag.dao;

import org.project.netctoss.pojos.PagerBean;

public interface IReportDao {

	public PagerBean findAllYear(PagerBean page);
	
	public PagerBean findAllServiceByUser(PagerBean page);
	
}
