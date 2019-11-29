package com.sp.bdi.testtest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

	@RequestMapping(method=RequestMethod.GET)//12번 라인에서 /test를 한번만 만족하면 된다
	public @ResponseBody Map<String,String> test(){
		Map<String,String> rMap = new HashMap<String,String>();
		return rMap;
	}
	@RequestMapping(method=RequestMethod.POST)//12번 라인에서 /test를 만족해야하고 그 하위에서 /test1가 한번더 만족해야한다
	public @ResponseBody Map<String,String> test(@RequestParam Map<String,String> param){//@ModelAttribute UserVO 넣어주면 UserVO에 맞춰서 들어간다 @ModelAttribute는 생략가능
		log.debug("param : {}", param);//info를 사용하지 않고 debug를 많이 사용한다 info를 사용할때만 한다
		//content-type/x-www-form-urlenconded 가 디폴트다 항상 이걸로 보내줘야함
		//@RequestBody를 사용하면 BufferedReader를 사용해서 while문 돌려서 받을필요가없다
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("key","난 test");
		return rMap;
	}
}
