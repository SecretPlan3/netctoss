package testCostService;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.netctoss.beans.CostBean;
import org.project.netctoss.costmag.service.ICostService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestCostService {
	@Resource
	private ICostService costServiceImpl;
	
	@Test
	public void TestSelectCosts() {
		CostBean cb = costServiceImpl.selectCosts(1);
		System.out.println(cb);
	}
	
}
