package org.project.netctoss.shiro;





import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;



//这个类 要继承AuthorizingRealm ，重写下列方法供shiro 做登陆以及权限的管理
@Service
public class MyRealm extends AuthorizingRealm{

//   @Resource
//    private IUserService userServiceImpl;
   
    
   
//权限认证（登陆成功后 自动进入次方法，将用户的权限信息，添加到shiro的info对象中，以便shiro管理）
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
// 
//		 String username=(String)principals.fromRealm(getName()).iterator().next();  
//	        if( username != null ){  
//	            User user = userServiceImpl.findByName(username); //从数据库获取用户（包括其角色，权限的完整信息）
//	            System.out.println("权限"+user);
//	            if( user != null && user.getRoleList() != null ){  
//	                SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();  
//	                for(Role each: user.getRoleList() ){  
//	                        info.addRole(each.getRolename());  //加角色信息
//	                        info.addStringPermissions(each.getPermissionsName());//加权限信息  
//	                }  
//	                return info;//info对象可以被shiro识别  
//	            }  
//	        }  
		return null;
	}
//登录认证 homeController中的login方法 跳到此处
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
//		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;  
//        String userName = token.getUsername(); 
//        char[] userPwd = token.getPassword(); 
//        System.out.println(userName+"------------------");
//       
//        if( userName != null && !"".equals(userName) ){  
//        	System.out.println(String.valueOf(userPwd)+"-----666666---------");
////            User user = userServiceImpl.login(userName, String.valueOf(userPwd));  //我们自己写的登陆验证方法，匹配好账号密码
//            
//            //用框架获取session对象（相当于HTTPSession，jsp中可以从session隐式对象获取）
//            Subject currentUser = SecurityUtils.getSubject();
//            Session s=currentUser.getSession();
//	        s.setAttribute("user", user);
//	        
//            if( user != null ) { 
//            	System.out.println("登录+++++++++++++"+user);
//                return new SimpleAuthenticationInfo(user.getUserName(),user.getPassWord(), getName()); //登陆成功将含有账号密码的 这个对象返回 
//            }else {
//            	
//            	 return null;
//            }
//          }else {
//        	
		
        	  return null;
          }  
	}

//}
