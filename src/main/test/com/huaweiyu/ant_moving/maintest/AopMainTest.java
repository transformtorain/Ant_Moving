package com.huaweiyu.ant_moving.maintest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huaweiyu.ant_moving.bean.test.AopTestBean;

public class AopMainTest {
	
	public static void main(String[] args) {
		ApplicationContext bf = new ClassPathXmlApplicationContext("spring-aop.xml");
		AopTestBean bean = (AopTestBean)bf.getBean("test");
		bean.test();
	}

}
