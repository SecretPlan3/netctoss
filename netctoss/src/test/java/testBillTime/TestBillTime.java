package testBillTime;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.netctoss.billtimemag.service.IBillTimeService;
import org.project.netctoss.managermag.service.IManagerService;
import org.project.netctoss.pojos.PagerBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestBillTime {
	
	@Resource
	private IBillTimeService billTimeserviceImpl;
	
	
	@Test
	public void testFindAllUsersBillTimeByCondition() {
		Map<String, String> params = new HashMap<>();
		PagerBean page = new PagerBean(1, 3, params);
		
		page = billTimeserviceImpl.findAllUsersBillTimeByCondition(page);
		System.out.println(page);
	}
}
