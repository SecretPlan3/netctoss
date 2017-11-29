package testService;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.netctoss.beans.ServiceBean;
import org.project.netctoss.beans.ServiceDailyBean;
import org.project.netctoss.beans.ServiceMonthlyBean;
import org.project.netctoss.servicemag.service.IServiceBeanService;
import org.project.netctoss.servicemag.service.IServiceDailyService;
import org.project.netctoss.servicemag.service.IServiceMonthlyService;
import org.project.netctoss.servicemag.service.IServiceTimeService;
import org.project.netctoss.servicemag.service.IServiceYearlyService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestService {
	@Resource
	private IServiceBeanService serviceBeanServiceImpl;
	@Resource
	private IServiceDailyService serviceDailyServiceImpl;
	@Resource
	private IServiceMonthlyService serviceMonthlyServiceImpl;
	@Resource
	private IServiceTimeService serviceTimeServiceImpl;
	@Resource
	private IServiceYearlyService serviceYearlyServiceImpl;
	@Ignore
	public void test1() {
		ServiceBean sb = serviceBeanServiceImpl.getServiceBeanByID(7L);
		System.out.println(sb);
	}
	@Test
	public void testGL() {
		ServiceDailyBean sd=serviceDailyServiceImpl.getServiceDailyBeanByID(11L);
		ServiceMonthlyBean sm = serviceMonthlyServiceImpl.getServiceMonthlyBeanByID(9L);
		ServiceBean sb = serviceBeanServiceImpl.getServiceBeanByID(7L);
		
		sd.setServiceMonthly(sm);
		sd.setService(sb);
		sm.setService(sb);
		serviceDailyServiceImpl.updateServiceDailyBean(sd);
		serviceMonthlyServiceImpl.updateServiceMonthlyBean(sm);
	}
}
