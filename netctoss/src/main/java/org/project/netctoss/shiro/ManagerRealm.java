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
import org.project.netctoss.beans.ManagerBean;
import org.project.netctoss.beans.RoleBean;
import org.project.netctoss.managermag.service.IManagerService;
import org.springframework.stereotype.Service;

@Service
public class ManagerRealm extends AuthorizingRealm{

	@Resource
	private IManagerService managerServiceImpl;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		String LoginName=(String)principals.fromRealm(getName()).iterator().next();  
        if( LoginName != null ){  
            ManagerBean manager = managerServiceImpl.findManagerByLoginName(LoginName); //从数据库获取用户（包括其角色，权限的完整信息）
            System.out.println("权限"+manager);
            if( manager != null && manager.getTheRole().size() != 0 ){  
                SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();  
                for(RoleBean ro : manager.getTheRole()) {
                	info.addRole(ro.getType());//加角色信息,后面根据角色类型来区分登录到什么页面
                }
                
//                info.addRole(user.getRoler().getType());  //加角色信息,根据角色类型来区分登录到什么页面
//                info.addStringPermissions(user.getRoler().getPermissionsName());//加权限信息  
               
                return info;//info对象可以被shiro识别  
            }  
        }  
	return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		// TODO Auto-generated method stub
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;  
        String loginName = token.getUsername(); 
        char[] managerPwd = token.getPassword();

        System.out.println(loginName+"------------------");
       
        if( loginName != null && !"".equals(loginName) ){  
        	System.out.println(String.valueOf(managerPwd)+"-----666666---------");
            ManagerBean manager = managerServiceImpl.findManagerByLoginNameAndPassword(loginName, String.valueOf(managerPwd));  //我们自己写的登陆验证方法，匹配好账号密码
            
            //用框架获取session对象（相当于HTTPSession，jsp中可以从session隐式对象获取）
            Subject currentUser = SecurityUtils.getSubject();
            Session s=currentUser.getSession();
	        s.setAttribute("user", manager);
	        
            if( manager != null ) { 
            	System.out.println("登录+++++++++++++"+manager);
                return new SimpleAuthenticationInfo(manager.getLoginName(),manager.getPassword(), getName()); //登陆成功将含有账号密码的 这个对象返回 
            }else {
            	
            	 return null;
            }
          }else {
        	
		
        	  return null;
          }  
	
	}

}
