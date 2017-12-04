package org.project.netctoss.shiro;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.project.netctoss.beans.ManagerBean;
import org.project.netctoss.beans.RoleBean;
import org.project.netctoss.beans.UserBean;
import org.project.netctoss.managermag.service.IManagerService;
import org.project.netctoss.usermag.service.IUserService;
import org.project.netctoss.utils.CustomizedToken;
import org.springframework.stereotype.Service;

@Service
public class MyRealm extends AuthorizingRealm {

	@Resource
	private IUserService userServiceImpl;

	@Resource
	private IManagerService managerServiceImpl;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		// String LoginName=(String)principals.fromRealm(getName()).iterator().next();
		System.out.println("getName()得到的名字：" + getName());
		String nameAndType = (String) principals.getPrimaryPrincipal();
		String loginName = nameAndType.substring(0,nameAndType.indexOf("&"));
		String loginType = nameAndType.substring(nameAndType.indexOf("&") + 1);
		System.out.println("权限回调**********"+loginName);
		System.out.println("权限回调**********"+loginType);
		
		//一下 的if-else为通过type 来区分调用谁的数据库查询
		if (loginName != null && !"".equals(loginName) && loginType.equals("Manager")) {
			ManagerBean manager = managerServiceImpl.findManagerByLoginName(loginName); // 从数据库获取用户（包括其角色，权限的完整信息）
			System.out.println("权限" + manager);

			if (manager != null && manager.getTheRole().size() != 0) {
				SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
				System.out.println("添加权限");
				for (RoleBean ro : manager.getTheRole()) {
					info.addRole(ro.getName());// 加角色信息,后面根据角色类型来区分登录到什么页面
					info.addStringPermissions(ro.getPermissionsName());// 加权限信息
				}
				return info;// info对象可以被shiro识别
			}
		}else if(loginName != null && !"".equals(loginName) && loginType.equals("User")) {
			UserBean user = userServiceImpl.findUserByLoginName(loginName); // 从数据库获取用户（包括其角色，权限的完整信息）
			System.out.println("权限" + user);
			if (user != null && user.getRoler() != null) {
				SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
				info.addRole(user.getRoler().getName()); // 加角色信息,根据角色类型来区分登录到什么页面
				info.addStringPermissions(user.getRoler().getPermissionsName());// 加权限信息
				return info;// info对象可以被shiro识别
			}
		}
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {

		// 1. 把AuthenticationToken转换为CustomizedToken
		CustomizedToken customizedToken = (CustomizedToken) authcToken;
		
		// 2. 从CustomizedToken中获取username
		String loginName = customizedToken.getUsername();
		char[] password = customizedToken.getPassword();
		String loginType = customizedToken.getLoginType();

		System.out.println(loginName + "------------------");

		if (loginName != null && !"".equals(loginName) && loginType.equals("Manager")) {
			// 以下信息从数据库中获取
			System.out.println(String.valueOf(password) + "-----666666---------");
			ManagerBean manager = managerServiceImpl.findManagerByLoginNameAndPassword(loginName,
					String.valueOf(password)); // 我们自己写的登陆验证方法，匹配好账号密码

			// 用框架获取session对象（相当于HTTPSession，jsp中可以从session隐式对象获取）
			Subject currentUser = SecurityUtils.getSubject();
			Session s = currentUser.getSession();
			s.setAttribute("user", manager);

			if (manager != null) {
				// 4.
				// 根据用户的情况，来构建AuthenticationInfo对象并返回，通常使用的实现类为SimpleAuthenticationInfo
				System.out.println("登录+++++++++++++" + manager);
				return new SimpleAuthenticationInfo(manager.getLoginName()  + "&" + loginType, manager.getPassword(), getName()); // 登陆成功将含有账号密码的这个对象返回

			} else {
				// 3. 若用户不存在，抛出UnknownAccountException异常
				System.out.println("管理员不存在");
				return null;
			}
		} else if (loginName != null && !"".equals(loginName) && loginType.equals("User")) {
			// 以下信息从数据库中获取
			System.out.println(String.valueOf(password) + "-----666666---------");
			UserBean user = userServiceImpl.findUserByLoginNameAndPassword(loginName, String.valueOf(password)); // 我们自己写的登陆验证方法，匹配好账号密码
			System.out.println("查到的user是：" + user);

			// 用框架获取session对象（相当于HTTPSession，jsp中可以从session隐式对象获取）
			Subject currentUser = SecurityUtils.getSubject();
			Session s = currentUser.getSession();
			s.setAttribute("user", user);

			if (user != null) {
				// 4.
				// 根据用户的情况，来构建AuthenticationInfo对象并返回，通常使用的实现类为SimpleAuthenticationInfo
				System.out.println("登录+++++++++++++" + user);
				return new SimpleAuthenticationInfo(user.getLoginName()  + "&" + loginType, user.getPassWord(), getName()); // 登陆成功将含有账号密码的
																											// 这个对象返回
			} else {
				// 3. 若用户不存在，打印不存在
				System.out.println("用户不存在");
				return null;
			}
		} else {
			return null;
		}

	}

}
