package com.sp.bdi.test.test3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("cook")//id가 없다면 소문자로 된 변수명이나 이름을 따로 적어줄수 있다
public class Cook {
	private Food f;

	public Food getF() {
		return f;
	}
	@Autowired//따로 set을 안해줘도 알아서 해준다 하지만 Food라고 부를수 있는것들이 2개 이상일 경우 에러가 난다 이럴 때는 @Qualifier, 식별자를 써줘야한다
	public void setF(Food f) {
		this.f = f;
	}
	
}
