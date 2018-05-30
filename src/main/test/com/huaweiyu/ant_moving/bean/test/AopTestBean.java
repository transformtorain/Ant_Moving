package com.huaweiyu.ant_moving.bean.test;

public class AopTestBean {
	
	private String testStr = "testStr";

	public String getTestStr() {
		return testStr;
	}

	public void setTestStr(String testStr) {
		this.testStr = testStr;
	}
	
	//切入的目标方法
	public void test(){
		System.out.println("test");
	}

}
