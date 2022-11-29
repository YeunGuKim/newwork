package com.test.member.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Member {
	private String userId;
	private String password;
	private String userName;
	private int age;
	private String email;
	private String phone;
	private String address;
	private char gender;
	private String[] hobby;
}
