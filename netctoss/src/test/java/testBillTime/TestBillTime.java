package testBillTime;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.netctoss.beans.ServiceBean;
import org.project.netctoss.beans.ServiceDailyBean;
import org.project.netctoss.beans.ServiceMonthlyBean;
import org.project.netctoss.beans.ServiceYearlyBean;
import org.project.netctoss.beans.UserBean;
import org.project.netctoss.billtimemag.service.IBillTimeService;
import org.project.netctoss.managermag.service.IManagerService;
import org.project.netctoss.pojos.PagerBean;
import org.project.netctoss.usermag.service.IUserService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestBillTime {
	
	@Resource
	private IBillTimeService billTimeserviceImpl;
	
	@Resource
	private IUserService userServiceImpl;
	
	
	//测试用户名
	public void testUserName() {
		UserBean user = userServiceImpl.findUserByLoginName("123");
		System.out.println("user+++++++++++++++++++" + user);
	
	}
	
	//测试用户密码验证
	public void testUserPwd() {
		UserBean user = userServiceImpl.findUserByLoginNameAndPassword("123", "202cb962ac59075b964b07152d234b70");
		System.out.println("user+++++++++++++++++++" + user);
	
	}
	
	@Test
	//查用户id下的 各个业务使用时长详情 （按年 月 日  都支持延迟加载）
	public void testFindAllServicessBillTimeByCondition() {
		
		System.out.println("hello+++++++++++++++++++");
		Map<String, String> params = new HashMap<>();
		params.put("year", "2016");
		params.put("month", "1");
		params.put("userId", "1");
		PagerBean page = new PagerBean(1, 3, params);
		
		page = billTimeserviceImpl.findAllServicesBillTimeByCondition(page);
		List<?> list = page.getDatas();
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
//		System.out.println("page+++++++++++++++++++" + page);
	
	}

	//查所有用户
	public void testFindAllUsersBillTimeByCondition() {
		
		System.out.println("hello+++++++++++++++++++");
		Map<String, String> params = new HashMap<>();
		PagerBean page = new PagerBean(1, 5, params);
		
		
		page = billTimeserviceImpl.findAllUsersBillTimeByCondition(page);
		System.out.println("page+++++++++++++++++++" + page);
	}
	
}
