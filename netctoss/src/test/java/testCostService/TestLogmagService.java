package testCostService;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.netctoss.logmag.service.ILogmagService;
import org.project.netctoss.pojos.PagerBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestLogmagService {
	@Resource
	private ILogmagService logmagServiceImpl;
	@Test
	public void testFindManagerOperationLog() {
		PagerBean pb = new PagerBean();
		pb.setIndex(1);
		pb.setRows(3);
		Map<String,Object> params = new HashMap<>();
		params.put("managerId", 1l);
		pb.setParams(params);
		pb = logmagServiceImpl.findManagerOperationLog(pb);
		System.out.println(pb);
	}
	@Ignore
	public void testFindManagerLog() {
		PagerBean pb = new PagerBean();
		pb.setIndex(1);
		pb.setRows(3);
		Map<String,Object> params = new HashMap<>();
		params.put("managerId", 1l);
		pb.setParams(params);
		pb = logmagServiceImpl.findManagerLog(pb);
		System.out.println(pb);
	};
}
