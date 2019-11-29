package com.sp.bdi.test.test3;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component("food")
@Data
public class Food {
//	public Food(String str) {
//		이런식으로 하면 무조건 에러가 난다 기본생성자가 있어야한다
//	}
	private String name;
	private Integer price;
	
}