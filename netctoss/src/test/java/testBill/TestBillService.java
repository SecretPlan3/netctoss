package testBill;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.netctoss.beans.ManagerBean;
import org.project.netctoss.beans.RoleBean;
import org.project.netctoss.beans.ServiceDetailCostBean;
import org.project.netctoss.beans.UserBean;
import org.project.netctoss.billmag.service.IBillService;
import org.project.netctoss.managermag.service.IManagerService;
import org.project.netctoss.pojos.PagerBean;
import org.project.netctoss.utils.DateUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestBillService {

	@Resource
	private IBillService billServiceImpl;
	
	
	public void testFindAllBill() {
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
		
		page = billServiceImpl.findAllUserBillByCondition(page);
		
		System.err.println(page.getDatas());
	}
	
	
	public void testFindUserAllService() {
		PagerBean page = new PagerBean();
		// 模拟参数
		Map<String, Object> params = new HashMap<>();
		params.put("userID", 1L);
		params.put("year", "2017");
		params.put("month", "4");
		page.setParams(params);
		page.setPage(1);
		page.setRows(5);
		
		page = billServiceImpl.findAllServiceBillByCondition(page);
		System.err.println(page.getDatas());
	}
	
	@Test
	public void testFindServiceAllBill() {
		PagerBean page = new PagerBean();
		// 模拟参数
		Map<String, Object> params = new HashMap<>();
		params.put("osName", "ttt");
		Date loginTime = DateUtils.parseDate("2017-10-01");
		Date logoutTime = DateUtils.parseDate("2017-10-32");
		params.put("loginTime", loginTime);
		params.put("logoutTime", logoutTime);
		page.setParams(params);
		page.setPage(1);
		page.setRows(5);
		
		page = billServiceImpl.findAllServiceTimeBillByCondition(page);
		List<ServiceDetailCostBean> sdc =  (List<ServiceDetailCostBean>) page.getDatas();
		System.err.println(page);
		for (ServiceDetailCostBean serviceDetailCostBean : sdc) {
			System.err.println(serviceDetailCostBean.getCostbean());
		}
	}
}
