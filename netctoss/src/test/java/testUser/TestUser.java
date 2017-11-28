package testUser;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.netctoss.beans.UserBean;
import org.project.netctoss.pojos.PagerBean;
import org.project.netctoss.usermag.service.UserService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestUser {
	
	@Resource
	private UserService UserServiceImpl;
	
	@Test
	public void findUserById() {
		UserBean Users = new UserBean();
		UserServiceImpl.findUserById(1L);
		System.out.println(UserServiceImpl.findUserById(1L));
	}
	
	 
}
