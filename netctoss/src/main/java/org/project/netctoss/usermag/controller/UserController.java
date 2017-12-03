package org.project.netctoss.usermag.controller;

import java.io.IOException;
import java.util.Iterator;

import javax.annotation.Resource;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.project.netctoss.beans.UserBean;
import org.project.netctoss.pojos.PagerBean;
import org.project.netctoss.usermag.dao.impl.UserDaoImpl;
import org.project.netctoss.usermag.service.IUserService;
import org.project.netctoss.utils.CustomizedToken;
import org.project.netctoss.utils.LoginType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/usermag")
@ResponseBody
public class UserController {

	private static final String USER_LOGIN_TYPE = LoginType.USER.toString();

	@Resource
	private IUserService userServiceImpl;

	@RequestMapping(value = "/login")
	public ModelAndView login(UserBean user) {
		System.out.println("进入了登陆控制器");
		ModelAndView mav = new ModelAndView();

		System.out.println(user);
		// 获取凭据
		// UsernamePasswordToken token = new
		// UsernamePasswordToken(user.getUserName(),user.getPassWord());
		// token.setRememberMe(true);
		CustomizedToken customizedToken = new CustomizedToken(user.getUserName(), user.getPassWord(), USER_LOGIN_TYPE);
		customizedToken.setRememberMe(true);
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
			try {

				// 提交凭据
				currentUser.login(customizedToken);// 调用shiro包中的类中的方法
				mav.setViewName("redirect:/jsp/userself/userselfmain.jsp");
				mav.addObject("message", 0);
				return mav;

			} catch (UnknownAccountException ex) {// 用户名没有找到
				System.out.println("用户名没有找到");
				mav.setViewName("redirect:/userLogin.jsp");
				mav.addObject("message", 1);
				return mav;
			} catch (IncorrectCredentialsException ex) {// 用户名密码不匹配
				System.out.println("用户名密码不匹配");
				mav.setViewName("redirect:/userLogin.jsp");
				mav.addObject("message", 1);
				return mav;
			} catch (LockedAccountException lae) {
				System.out.println(lae);
				mav.setViewName("redirect:/userLogin.jsp");
				mav.addObject("message", 1);
				return mav;
			} catch (ExcessiveAttemptsException eae) {
				System.out.println(eae);
				mav.setViewName("redirect:/userLogin.jsp");
				mav.addObject("message", 1);
				return mav;
			} catch (AuthenticationException ae) {
				System.out.println(ae);
				mav.setViewName("redirect:/userLogin.jsp");
				mav.addObject("message", 1);
				return mav;
			}
		}
		mav.setViewName("redirect:/userLogin.jsp");
		mav.addObject("message", 1);
		return mav;
	}

	// 退出
	@RequestMapping(value = "/loginout")
	public String loginOut() {

		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		return "userLogin"; // 退出后跳转的页面（此处有待验证，为何推出后还可以访问该资源）（一般写login.jsp即可）
	}

	@RequestMapping(value = "/add")
	public void useradd(UserBean user) {
		System.out.println(user);
		System.out.println(user.getGender());
		userServiceImpl.addUser(user);

	}

	@RequestMapping(value = "/delete")
	public void userdel(UserBean user) {
		System.out.println("delete……");
		System.out.println("user" + user);
		userServiceImpl.deleteUserById(user);
	}

	@RequestMapping(value = "/update")
	public String userupdate() {

		return "jsp/update";
	}

	@RequestMapping(value = "/query")
	public String userquery() {

		return "jsp/query";
	}

	public String uplodeEXCEL(@RequestParam("file") CommonsMultipartFile file) {

		try {
			// poi 对Excel 读取修改的框架
			// “The supplied data appears to be in the Office 2007+ XML.
			// You are calling the part of POI that deals with OLE2 Office Documents.
			// You need to call a different part of POI to process this data
			// (eg XSSF instead of HSSF)”
			// 用xssf 代替 hssfWorkbook 读取2007excl后版本出现的问题 用poi-ooxml包 如果是2003版本的Excel用poi 包

			// Excel 如果有整合的单元格,那是能读取出来的,但是还是原来的格数,但是是空的
			// Excel 如果有空单元格,然后后面还有内容就读取不出来,迭代是算的下一个单元格是不是空

			// 得到excl工作簿
			XSSFWorkbook wb = new XSSFWorkbook(file.getInputStream());
			// 迭代工作簿,得到每张表
			Iterator<Sheet> itSheet = wb.iterator();
			while (itSheet.hasNext()) {
				Sheet sheet = itSheet.next();
				System.out.println(sheet.getSheetName());
				System.out.println("/////////");// 表与表之间隔开瞅一下
				// 每个表迭代得到每一行
				Iterator<Row> itRow = sheet.iterator();
				while (itRow.hasNext()) {
					Row row = itRow.next();
					// 行再迭代出每一个单元格
					Iterator<Cell> itCell = row.iterator();
					while (itCell.hasNext()) {
						Cell cell = itCell.next();
						// 这里要设置单元格里面数值类型才能正常输出,

						System.out.println(cell.getStringCellValue());
					}
					System.out.println(".............");
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "success";
	}

	@RequestMapping(value = "/findUserByPager", produces = { "application/json;charset=utf-8" })
	public @ResponseBody PagerBean findUserByPager(PagerBean pager) {
		System.out.println("qwerfghwersdfghsdfghjsdfh");
		// Long userId = Long.parseLong((String) pager.getParams().get("userId"));
		// pager.getParams().put("userID", userId);
		pager = userServiceImpl.findUserByPager(pager);
		System.out.println(pager);
		return pager;
	}
}
