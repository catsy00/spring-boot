package com.kepco.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kepco.common.exception.AlreadyExistingIdException;
import com.kepco.user.service.UserService;
import com.kepco.user.service.UserServiceImpl;
import com.kepco.user.util.RegisterRequest;

@Controller
@RequestMapping(value="/joinup")
public class JoinController {
	
	@Autowired
    Sha256 sha;
	
	@Resource(name="userService")
	private UserService userSer;
	
	@Resource(name="userService")
	private UserServiceImpl userServiceImpl;
	

	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public ModelAndView join(@ModelAttribute RegisterRequest registerRequest) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		System.out.println("join.겟방식으로 접근");
		//if(rememberCookie != null) {
		//	loginCommand.setId(rememberCookie.getValue());
		//	loginCommand.setRememberId(true);
		//}
		
		//registerRequest.setId("0");
		//registerRequest.setEmail("0");
		//registerRequest.setCheckPassword("0");
		//registerRequest.setName("0");
		//registerRequest.setPassword("0");
		//registerRequest.setPower_bizp_cd("0");
		
		mv.addObject("registerRequest", registerRequest);
		mv.setViewName("/user/joinup/join");
		return mv;
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public ModelAndView join(@ModelAttribute RegisterRequest registerRequest ,@RequestParam(value="agree", defaultValue="false") Boolean agree) throws Exception {

		ModelAndView mv = new ModelAndView();
		System.out.println("join.포스트방식으로 접근");
		agree = true;
		
		//registerRequest.setId("0");
		//registerRequest.setEmail("0");
		//registerRequest.setCheckPassword("0");
		//registerRequest.setName("0");
		//registerRequest.setPassword("0");
		//registerRequest.setPower_bizp_cd("0");
		
		mv.addObject("registerRequest", registerRequest);
		mv.setViewName("/user/joinup/join");
		
		return mv;
		
	}
	
	// 아이디 중복 검사
		@RequestMapping(value = "/memberIdChk", method = RequestMethod.POST)
		@ResponseBody
		public int memberIdChkPOST(String memberId) throws Exception{
			
			System.out.println("memberIdChk() 진입");
			System.out.println("memberId : " + memberId);
			int result = userSer.idChk(memberId);
			
			System.out.println("result : " + result);
			return result; 
			
		}
	
    @RequestMapping(value="/step3", method=RequestMethod.POST)
    public ModelAndView step3(@Valid RegisterRequest regReq, BindingResult bindingResult, HttpServletRequest request) throws Exception{
    	
    	System.out.println("step3.포스트방식으로 아웃!");
    	
    	int result = 0;
    	
        ModelAndView mv = new ModelAndView();
        
        if(bindingResult.hasErrors()) {
        	mv.setViewName("/user/joinup/join");
            return mv;
        }
        
        boolean check = regReq.isPwEqualToCheckPw();
        
        String pw = regReq.getPassword();
        String hn = regReq.getPower_bizp_cd();
        String hn2 = "2461";//request.getParameter("hdqrCd");
        int userCnt = 0;
        
        
        pw = sha.encrypt(pw);
        
        if(!check) {
            bindingResult.rejectValue("checkPassword", "noMatch", "비밀번호가 맞지 않습니다.");
            mv.setViewName("/user/joinup/join");
            return mv;
        }
        
        try {
        	regReq.setPower_bizp_cd(hn2);
        	regReq.setPassword(pw);
            userSer.register(regReq);
            
        } catch (AlreadyExistingIdException e) {
        	result = 1;
        	bindingResult.rejectValue("id", "duplicate", "이미 가입된 사번입니다.");
            mv.setViewName("/user/joinup/join");
            return mv;
        }
        mv.setViewName("/user/joinup/step3");
        mv.addObject("registerRequest", new RegisterRequest());
        return mv;
    }

    
    @RequestMapping(value="/step3", method=RequestMethod.GET)
    public ModelAndView step3(@Valid RegisterRequest regReq) throws Exception{
    	
    	
    	int result = 0;
    	
        ModelAndView mv = new ModelAndView();
        
       // System.out.println("regReq" + regReq);
        
        mv.setViewName("/user/joinup/step3");
        mv.addObject("registerRequest", new RegisterRequest());
        return mv;
    }
}