package testCostService;

import javax.annotation.Resource;

import org.junit.Ignore;
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
	
	@Ignore
	public void testUpdateCosts() {
		CostBean cb = new CostBean();
		cb.setId(2);
		cb.setName("超级卡");
		cb.setDescription("哎哟不错哦");
		costServiceImpl.updateCosts(cb);
	}
	@Test
	public void testDelectCosts() {
		//程序执行成功但是数据库没有反应
		CostBean cb = costServiceImpl.selectCosts(1);
		cb = new CostBean();
		System.out.println(cb);
		costServiceImpl.deleteCosts(cb);
	}
	@Ignore
	public void testInsertCosts() {
		CostBean cb = new CostBean();
		cb.setName("冰淇淋套餐");
		cb.setCostNumber("xx120");
		costServiceImpl.insertCosts(cb);
		
	}
	@Ignore
	public void TestSelectCosts() {
		CostBean cb = costServiceImpl.selectCosts(1);
		System.out.println(cb);
	}
	
}
