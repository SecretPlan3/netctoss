package testCostService;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.netctoss.beans.CostBean;
import org.project.netctoss.costmag.service.ICostService;
import org.project.netctoss.pojos.PagerBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestCostService {
	@Resource
	private ICostService costServiceImpl;
	@Test
	public void testFindAllCostsBypage() {
		PagerBean pb = new PagerBean();
		pb.setIndex(1);
		pb.setRows(3);
		Map<String,Object> params = new HashMap<>();
		params.put("type", 1);
		pb.setParams(params);
		
		pb = costServiceImpl.findAllCostsByPager(pb);
	}
	@Ignore
	public void testUpdateCosts() {
		CostBean cb = new CostBean();
		cb.setId(2);
		cb.setName("超级卡");
		cb.setDescription("哎哟不错哦");
		costServiceImpl.updateCosts(cb);
	}
	@Ignore
	public void testDelectCosts() {
		CostBean cb = costServiceImpl.selectCosts(4);
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
		costServiceImpl.deleteCosts(cb);
		System.out.println(cb);
	}	
}
