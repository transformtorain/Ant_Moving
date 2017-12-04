package com.huaweiyu.ant_moving.controller;

public class TestTwoController {
	
	private int num;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getNum() {
		return num;
	}

	
	public void setNum(int num) {
		this.num = num;
	}
	
	public void getTest(){
		num++;
		System.out.println("仅仅是测试回滚");
	}

}
