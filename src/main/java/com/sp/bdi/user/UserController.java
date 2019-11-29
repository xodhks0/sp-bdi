package com.sp.bdi.user;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {
	@Autowired
	@Qualifier("userService")
	private UserService us;

	@RequestMapping("/user/list")//model 은 requestScope에 저장? JSTL기반이라면 이게 맞지만 ajax기반이라면 이렇게 할 필요가 없다
	public String getUserList(Model model) {
		model.addAttribute("List",us.getUserList());
		return "user/list";
	}
	
//	@ResponseBody 때문에 library에 3개만 추가하면
	@RequestMapping(value="/user/list/ajax", method=RequestMethod.GET)
	public @ResponseBody List<UserVO> getUserList(@ModelAttribute UserVO user){//@ModelAttribute 만 생략 가능하다
		log.debug("user : {} ",user);
		return us.getUserVOList(user);
	}
	
	@RequestMapping(value="/user/login", method=RequestMethod.POST)
	public @ResponseBody UserVO login(@RequestBody UserVO user, HttpSession hs){//HttpServletRequest request 해서 보내도 된다
		user = us.login(user);
		log.debug("select user : {} ",user);
		if(user!=null) {
			hs.setAttribute("user", user);
		}
		return user;
	}
	
	@RequestMapping(value="/user/list/ajax", method=RequestMethod.POST)
	public @ResponseBody Map<String,String> insertUser(@RequestBody UserVO user){//@ModelAttribute 만 생략 가능하다 원래 폼 태그 방식으로는 application/json으로 받을수없다 json으로 받을거면 RequestBody로 한다
		log.debug("user : {} ",user);
		return us.insertUserInfo(user);
	}
	
	@RequestMapping(value="/user/list/ajax", method=RequestMethod.PUT)//원래는 patch
	public @ResponseBody Map<String,String> updateUser(@RequestBody UserVO user){
		log.debug("user : {} ",user);
		return us.updateUserInfo(user);
	}
	
	@RequestMapping(value="/user/list/ajax", method=RequestMethod.DELETE)
	public @ResponseBody Map<String,String> deleteUser(@RequestBody UserVO user){
		log.debug("user : {} ",user);
		return us.deleteUserInfo(user);
	}
}
