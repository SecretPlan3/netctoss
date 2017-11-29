package testBillTime;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
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
	
	
	
	public void testUserName() {
		UserBean user = userServiceImpl.findUserByLoginName("123");
		System.out.println("user+++++++++++++++++++" + user);
	
	}
	
	@Test
	public void testUserPwd() {
		UserBean user = userServiceImpl.findUserByLoginNameAndPassword("123", "202cb962ac59075b964b07152d234b70");
		System.out.println("user+++++++++++++++++++" + user);
	
	}
	

	
	public void testFindAllServicessBillTimeByCondition() {
		
		System.out.println("hello+++++++++++++++++++");
		Map<String, String> params = new HashMap<>();
		PagerBean page = new PagerBean(1, 3, params);
		
		page = billTimeserviceImpl.findAllServicessBillTimeByCondition(page);
		System.out.println("page+++++++++++++++++++" + page);
	
	}
	
	
	public void testFindAllUsersBillTimeByCondition() {
		
		System.out.println("hello+++++++++++++++++++");
		Map<String, String> params = new HashMap<>();
		PagerBean page = new PagerBean(1, 3, params);
		
		
		page = billTimeserviceImpl.findAllUsersBillTimeByCondition(page);
		System.out.println("page+++++++++++++++++++" + page);
	}
	
}
