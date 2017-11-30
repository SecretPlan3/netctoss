package testBill;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.netctoss.billmag.controller.BillController;
import org.project.netctoss.pojos.PagerBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml","classpath:springmvc-servlet.xml"})
public class TestBillController {
	
	@Resource
	private BillController billController;

	@Test
	public void testUserBill() {
		PagerBean page = new PagerBean();
		page.setPage(1);
		page.setRows(5);
		Map<String,Object> params = new HashMap<>();
		params.put("year", "2017");
		params.put("month", "10");
		params.put("userName", "");
		params.put("loginName", "");
		params.put("idcard", "");
		page.setParams(params);
		
		page = billController.findUserBill(page);
		System.out.println(page);
		
	}
}
