package com.sp.bdi.user;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("user")
@Data
public class UserInfoVO {
	private int[] uiNums;
	private String uiName;
	private String uiId;
	private String uiPwd;
	private Integer uiNum;
	private String credat;
	private String cretim;
	private String moddat;
	private String modtim;
	private String active;
	private String[] search;
	private String searchStr;
}
