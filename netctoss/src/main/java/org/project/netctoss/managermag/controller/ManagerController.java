package org.project.netctoss.managermag.controller;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.project.netctoss.beans.ManagerBean;
import org.project.netctoss.beans.UserBean;
import org.project.netctoss.managermag.service.IManagerService;
import org.project.netctoss.pojos.PagerBean;
import org.project.netctoss.utils.CustomizedToken;
import org.project.netctoss.utils.LoginType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value = "/managermag")
@RestController
public class ManagerController {

	private static final String MANAGER_LOGIN_TYPE = LoginType.MANAGER.toString();

	@Resource
	private IManagerService managerserviceImpl;

	@RequestMapping(value = "/login")
	public ModelAndView login(ManagerBean manager) {
		System.out.println("进入了登陆控制器");
		ModelAndView mav = new ModelAndView();

		System.out.println(manager);
		// 获取凭据
		// UsernamePasswordToken token = new
		// UsernamePasswordToken(manager.getLoginName(),manager.getPassword());
		// token.setRememberMe(true);
		CustomizedToken customizedToken = new CustomizedToken(manager.getLoginName(), manager.getPassword(),
				MANAGER_LOGIN_TYPE);
		customizedToken.setRememberMe(true);
		Subject currentUser = SecurityUtils.getSubject();
//		if (!currentUser.isAuthenticated()) {
			try {
				System.out.println("准备验证……");
				// 提交凭据
				currentUser.login(customizedToken);// 调用shiro包中的类中的方法
				mav.setViewName("redirect:/jsp/index.jsp");
				mav.addObject("message", 0);
				return mav;

			} catch (UnknownAccountException ex) {// 用户名没有找到
				System.out.println("用户名没有找到");
				mav.setViewName("redirect:/managerLogin.jsp");
				mav.addObject("message", 1);
				return mav;
			} catch (IncorrectCredentialsException ex) {// 用户名密码不匹配
				System.out.println("用户名密码不匹配");
				mav.setViewName("redirect:/managerLogin.jsp");
				mav.addObject("message", 2);
				return mav;
			} catch (LockedAccountException lae) {
				System.out.println(lae);
				mav.setViewName("redirect:/managerLogin.jsp");
				mav.addObject("message", 3);
				return mav;
			} catch (ExcessiveAttemptsException eae) {
				System.out.println(eae);
				mav.setViewName("redirect:/managerLogin.jsp");
				mav.addObject("message", 4);
				return mav;
			} catch (AuthenticationException ae) {
				System.out.println(ae);
				mav.setViewName("redirect:/managerLogin.jsp");
				mav.addObject("message", 5);
				return mav;
			}
//		}
//		mav.setViewName("redirect:/managerLogin.jsp");
//		mav.addObject("message", 1);
//		return mav;

	}

	// 退出
	@RequestMapping(value = "/logout")
	public ModelAndView logout() {
		ModelAndView mav = new ModelAndView();
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		mav.setViewName("redirect:/managerLogin.jsp");
		return mav; // 退出后跳转的页面（此处有待验证，为何推出后还可以访问该资源）（一般写login.jsp即可）
	}

	/**
	 * 添加或修改
	 * 
	 * @param managerbean
	 * @return
	 */
	@RequestMapping(value = "/manageradd", method = RequestMethod.POST)
	public void manageraddorupdate(ManagerBean managerbean) {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + managerbean);
		managerserviceImpl.addOrUpdateManeger(managerbean);
	}

	/**
	 * 删除一个管理员
	 * 
	 * @param managerbean
	 */
	@RequestMapping(value = "/managerdelete", method = RequestMethod.POST)
	public void userdel(ManagerBean managerbean) {
		System.out.println("~~~~~~~~~~~~~~~~~~~" + managerbean);
		managerserviceImpl.deleteManegerById(managerbean);
	}

	/**
	 * 查询单个
	 * 
	 * @return
	 */
	@RequestMapping(value = "/findone", method = RequestMethod.POST)
	public ManagerBean userquery(Long id) {
		System.out.println("进入了查询单个方法，id：" + id);
		ManagerBean mb = managerserviceImpl.selectManegerById(id);
		System.out.println("查到的单个ManagerBean：" + mb);
		return mb;
	}

	/**
	 * 查询所有
	 * 
	 * @param pagerBean
	 * @return
	 */
	@RequestMapping(value = "/findall", method = RequestMethod.POST)
	public PagerBean userqueryall(PagerBean pager) {
		System.out.println("进入了查询所有方法，id：" + pager);
		PagerBean pb = managerserviceImpl.findAllManagersByPager(pager);
		System.out.println("查到的pager：" + pb.getDatas().size());
		return pb;
	}

	/**
	 * 根据登录名和密码查询管理员
	 * 
	 * @return
	 */
	@RequestMapping(value = "/findonebyloginandpwd", method = RequestMethod.POST)
	public ManagerBean findonebyloginandpwd(String loginName, String password) {
		System.out.println("进入了findonebyloginandpwd方法，参数：" + loginName + password);
		ManagerBean mb = managerserviceImpl.findManagerByLoginNameAndPassword(loginName, password);
		System.out.println("查到的单个ManagerBean：" + mb);
		return mb;
	}

	/**
	 * 根据登录名查询管理员
	 * 
	 * @return
	 */
	@RequestMapping(value = "/findonebyloginname", method = RequestMethod.POST)
	public ManagerBean findonebyloginname(String loginName) {
		System.out.println("进入了findonebyloginName方法，参数：" + loginName);
		ManagerBean mb = managerserviceImpl.findManagerByLoginName(loginName);
		System.out.println("查到的单个ManagerBean：" + mb);
		return mb;
	}
}
