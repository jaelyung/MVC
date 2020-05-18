package com.human.dto;

import java.util.Date;

public class PersonDto {
	private int no;
	private String name;
	private double height;
	private Date birth;//import java.util
	private Date regist;
	//생성자 추가, toString(), Getter setter 추가
	public PersonDto() {}
	public PersonDto(int no, String name, double height, Date birth, Date regist) {
		this.no = no;
		this.name = name;
		this.height = height;
		this.birth = birth;
		this.regist = regist;
	}
	@Override
	public String toString() {
		return "PersonDto [no=" + no + ", name=" + name + ", height=" + height + ", birth=" + birth + ", regist="
				+ regist + "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public Date getRegist() {
		return regist;
	}
	public void setRegist(Date regist) {
		this.regist = regist;
	}

	
}
