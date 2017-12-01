package org.project.netctoss.usermag.controller;



import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.project.netctoss.beans.UserBean;
import org.project.netctoss.usermag.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;





@Controller
@RequestMapping(value="/usermag")
public class UserController{
	
	@Resource
	private IUserService userServiceImpl;
	
	@RequestMapping(value="/login")
	public ModelAndView login(UserBean user){
		System.out.println("进入了登陆控制器");
		 ModelAndView mav = new ModelAndView();
		 
	    System.out.println(user);
       //获取凭据
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getPassWord());
        token.setRememberMe(true);
       
        Subject currentUser = SecurityUtils.getSubject();
	    try {

	    	//提交凭据
	        currentUser.login(token);//调用shiro包中的类中的方法
	        mav.setViewName("redirect:/jsp/user.jsp");
	        mav.addObject("message", 0);
	        return mav;
	           
	        
	    } catch (UnknownAccountException ex) {//用户名没有找到  
	        System.out.println("用户名没有找到");
	        mav.setViewName("redirect:/message");
	        mav.addObject("message", 1);
	        return mav;
	    } catch (IncorrectCredentialsException ex) {//用户名密码不匹配  
	        System.out.println("用户名密码不匹配");  
	        mav.setViewName("redirect:/message");
	        mav.addObject("message", 1);
	        return mav;
	    }catch (LockedAccountException lae ) {  
	    	 System.out.println(lae);  
	    	 mav.setViewName("redirect:/message");
		        mav.addObject("message", 1);
		        return mav;
	    }catch (ExcessiveAttemptsException eae ) {  
	    	System.out.println(eae);  
	    	 mav.setViewName("redirect:/message");
	        mav.addObject("message", 1);
	        return mav;
	    }catch (AuthenticationException ae ) {  
	    	System.out.println(ae);  
	    	 mav.setViewName("redirect:/message");
	        mav.addObject("message", 1);
	        return mav;
	    }  
	    	
	}
	
	//退出
	@RequestMapping(value="/loginout")
	public String loginOut() {
		 
		Subject currentUser = SecurityUtils.getSubject();		 
			currentUser.logout();
		 return "jsp/user"; //退出后跳转的页面（此处有待验证，为何推出后还可以访问该资源）（一般写login.jsp即可）
	}
	@RequestMapping(value="/add")
	public void useradd(UserBean user) {
		 System.out.println(user);
		 System.err.println(user.getGender());
		 userServiceImpl.addUser(user);
		
	}
	@RequestMapping(value="/delete")
	public String userdel() {
		 
		
		 return "jsp/delete";
	}
	@RequestMapping(value="/update")
	public String userupdate() {
		 
		
		 return "jsp/update";
	}
	@RequestMapping(value="/query")
	public String userquery() {
		 
		
		 return "jsp/query";
	}
}
