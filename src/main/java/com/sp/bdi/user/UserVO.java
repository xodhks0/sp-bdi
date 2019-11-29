package com.sp.bdi.user;

import lombok.Data;

@Data
public class UserVO {

	private Integer uiNum;
	private String uiName;
	private String uiId;
	private String uiPwd;
	private String credat;
	private String cretim;
	private String moddat;
	private String modtim;
	private String active;
	private String[] search;
	private String searchStr;
}
