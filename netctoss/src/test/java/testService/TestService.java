package testService;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.netctoss.beans.ServiceBean;
import org.project.netctoss.servicemag.dao.IServiceDailyDao;
import org.project.netctoss.servicemag.dao.IServiceMonthlyDao;
import org.project.netctoss.servicemag.dao.IServiceTimeDao;
import org.project.netctoss.servicemag.dao.IServiceYearlyDao;
import org.project.netctoss.servicemag.service.IServiceBeanService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestService {
	@Resource
	private IServiceBeanService serviceBeanServiceImpl;
	@Resource
	private IServiceDailyDao serviceDailyDaoImpl;
	@Resource
	private IServiceMonthlyDao serviceMonthlyDaoImpl;
	@Resource
	private IServiceTimeDao serviceTimeDaoImpl;
	@Resource
	private IServiceYearlyDao serviceYearlyDaoImpl;
	@Test
	public void test1() {
		ServiceBean sb = serviceBeanServiceImpl.getServiceBeanByID(1L);
		System.out.println(sb);
	}
}
