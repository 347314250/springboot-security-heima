package cn.itcast.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	// login-success
	@RequestMapping(value = "/login-success", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String loginSuccess() {
		System.out.println("qqqq");
		System.out.println("aaaa");
		return getUserName() + "登录成功";

	}

	@RequestMapping(value = "/myLogout", produces = "text/plain;charset=utf-8")
	public String myLogout(String str, ModelMap map) {
		map.addAttribute("uname", getUserName());
		return "success";

	}

	@RequestMapping(value = "/success", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String success() {
		System.out.println("ssssss");
		return getUserName() + "success";

	}

	@RequestMapping(value = "/r/r1", produces = "text/plain;charset=utf-8")
	@ResponseBody
	@PreAuthorize("hasAuthority('p1')")
	public String r1(HttpSession session, HttpServletRequest request) {
		String fullname = null;
		return getUserName() + "r1" + "访问了页面";
	}

	@RequestMapping(value = "/r/r2", produces = "text/plain;charset=utf-8")
	@ResponseBody
	@PreAuthorize("hasAuthority('p2')")
	public String r2(HttpSession session, HttpServletRequest request) {
		return getUserName() + "访问了页面  r2";
	}

	private String getUserName() {
		String username = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		Object principal = authentication.getPrincipal();
		if (principal == null) {
			username = "匿名";
		}
		if (principal instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) principal;
			username = userDetails.getUsername();
		} else {
			username = principal.toString();
		}
		return username;
	}

}
