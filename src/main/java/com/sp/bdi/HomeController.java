package com.sp.bdi;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller//이것 때문에 메모리가 생성된다
public class HomeController {//servlet이 알아서 호출해준다
//	롬복이 깔려있다면 @Slf4j를 사용해서 private static final Logger logger = LoggerFactory.getLogger(HomeController.class); 이걸 알아서 만들어준다
//	log.info 이런식으로 사용할수 있음
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)//하나의 메소드가 urlpatten과 method 를 갖고있다
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);//INFO : com.sp..... 등등 나옴 (파탈, 에러, 인포, 디버그) 가 있다
		// logger 를 자주사용한다 {}사이에 locale이 들어간다 중괄호를 여러개 사용할 수 있다 logger.info("{} {}" , str , name)이런식으로 사용 가능
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );//model에 serverTime 이란 키값으로 formattedDate를 넣어준것
		List<String> strList = new ArrayList<String>();
		strList.add("박도영 바보");
		strList.add("박하늘 바보");
		strList.add("박경훈 바보");
		strList.add("김재빈 바보");
		model.addAttribute("strList",strList);
		
		return "home";//앞에 web-inf/views 의 home.jsp로 간다는뜻 servlet-context의 ViewResolver때문 String만 들어오면 알아서 해줌
	}
	
	@RequestMapping(value = "/test")// method가 없으면 get post delete option 다 상관없이 이걸 탄다
	public String test(Model m) {
		// /WEB-INF/views/test/test.jsp 로 간다
		System.out.println(m);//{}가 나온이유는 어디선가 new를 해줬기때문
		return "test/test";
	}
}