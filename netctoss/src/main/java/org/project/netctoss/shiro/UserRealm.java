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
import org.project.netctoss.beans.UserBean;
import org.project.netctoss.usermag.service.IUserService;
import org.project.netctoss.utils.CustomizedToken;
import org.springframework.stereotype.Service;

//这个类 要继承AuthorizingRealm ，重写下列方法供shiro 做登陆以及权限的管理
//@Service
public class UserRealm extends AuthorizingRealm {

	@Resource
	private IUserService userServiceImpl;

	// 权限认证（登陆成功后 自动进入次方法，将用户的权限信息，添加到shiro的info对象中，以便shiro管理）
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		// String LoginName=(String)principals.fromRealm(getName()).iterator().next();
		String LoginName = (String) principals.getPrimaryPrincipal();
		if (LoginName != null) {
			UserBean user = userServiceImpl.findUserByLoginName(LoginName); // 从数据库获取用户（包括其角色，权限的完整信息）
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

	// 登录认证 homeController中的login方法 跳到此处
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {

		// UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		// String loginName = token.getUsername();
		// char[] userPwd = token.getPassword();

		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		// 1. 把AuthenticationToken转换为CustomizedToken
		CustomizedToken customizedToken = (CustomizedToken) authcToken;
		// 2. 从CustomizedToken中获取username,password
		String loginName = customizedToken.getUsername();
		char[] userPwd = customizedToken.getPassword();

		System.out.println(loginName + "------------------");

		if (loginName != null && !"".equals(loginName)) {
			// 以下信息从数据库中获取
			System.out.println(String.valueOf(userPwd) + "-----666666---------");
			UserBean user = userServiceImpl.findUserByLoginNameAndPassword(loginName, String.valueOf(userPwd)); // 我们自己写的登陆验证方法，匹配好账号密码
			System.out.println("查到的user是：" + user);

			// 用框架获取session对象（相当于HTTPSession，jsp中可以从session隐式对象获取）
			Subject currentUser = SecurityUtils.getSubject();
			Session s = currentUser.getSession();
			s.setAttribute("user", user);

			if (user != null) {
				// 4.
				// 根据用户的情况，来构建AuthenticationInfo对象并返回，通常使用的实现类为SimpleAuthenticationInfo
				System.out.println("登录+++++++++++++" + user);
				return new SimpleAuthenticationInfo(user.getLoginName(), user.getPassWord(), getName()); // 登陆成功将含有账号密码的
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
