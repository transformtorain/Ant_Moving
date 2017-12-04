package com.huaweiyu.ant_moving.model;

import java.io.Serializable;

public class Test implements Serializable{
	
	private static final long serialVersionUID = -4115959763976814506L;
	
	private String id;
	private String code;
	private String name;
	private String age;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
}
