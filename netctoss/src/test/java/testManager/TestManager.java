package testManager;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.netctoss.beans.ManagerBean;
import org.project.netctoss.beans.RoleBean;
import org.project.netctoss.managermag.service.IManagerService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestManager {

	@Resource
	private IManagerService managerserviceImpl;
	
	@Test
	public void testAddOrUpdate() {
		ManagerBean manager = new ManagerBean();
		manager.setLoginName("三");
		manager.setLoginName("san");
		manager.setPassword("123");
		manager.setTel("18000530404");
		manager.setEmail("673978993@qq.com");
		
		RoleBean rb = new RoleBean();
		rb.setName("新角色");
//		manager.setTheRole(rb);
		
		managerserviceImpl.addOrUpdateManeger(manager);
	}
}
