package com.kepco.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kepco.common.exception.IdPasswordNotMatchingException;
import com.kepco.user.service.UserService;
import com.kepco.user.util.AuthInfo;
import com.kepco.user.util.LoginCommand;
import com.kepco.user.util.RegisterRequest;

@Controller
public class LoginController {
	
	@Autowired
    Sha256 sha;
	
	@Resource(name="userService")
	private UserService userSer;

	@RequestMapping(value="/loginIn", method=RequestMethod.GET)
	public ModelAndView loginInGET(LoginCommand loginCommand,
			@CookieValue(value="REMEMBER", required=false) Cookie rememberCookie) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		System.out.println("loginIn.GET 진입");
		if(rememberCookie != null) {
			loginCommand.setId(rememberCookie.getValue());
			loginCommand.setRememberId(true);
		}
		
		mv.setViewName("/user/loginForm2");
		mv.addObject("loginCommand", new LoginCommand());
		return mv;
	}
	
	@RequestMapping(value="/loginIn", method=RequestMethod.POST)
	public ModelAndView loginInPOST(@Valid LoginCommand loginCommand, BindingResult bindingResult,
			HttpSession session, HttpServletResponse response) throws Exception {
		
		System.out.println("loginIn.POST 진입");
		String encryptSHA256 = sha.encrypt(loginCommand.getPassword());
		loginCommand.setPassword(encryptSHA256);
		
		ModelAndView mv = new ModelAndView();
		
		
		if(bindingResult.hasErrors()) {
			mv.setViewName("/user/loginForm2");
			return mv;
		}
		
		
		try {
			AuthInfo authInfo = userSer.loginAuth(loginCommand);
			session.setAttribute("authInfo", authInfo);
			//System.out.println(" loginCommand.getname() : " +  authInfo.getName());
			
			session.setAttribute("userName", authInfo.getName());
			
			Cookie rememberCookie = new Cookie("REMEMBER", loginCommand.getId());
			rememberCookie.setPath("/");
			
			if(loginCommand.isRememberId()) {
                rememberCookie.setMaxAge(60*60*24*7);
            } else {
                rememberCookie.setMaxAge(0);
            }
            response.addCookie(rememberCookie);
			
		} catch(IdPasswordNotMatchingException e) {
			System.out.println("password 진입2");
			bindingResult.rejectValue("password", "notMatch", "아이디 혹은 비밀번호를 확인하세요.");
			mv.setViewName("/user/loginForm2");
			return mv;
			
		}
		//redirect:/main.do
		//main.jsp
		mv.setViewName("redirect:/check/operation_list");
		return mv;
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		
		System.out.println("logout 진입!");
		
		return "redirect:/login.jsp";
	}
	
}