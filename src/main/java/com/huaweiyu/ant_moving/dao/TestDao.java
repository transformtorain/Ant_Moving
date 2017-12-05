package com.huaweiyu.ant_moving.dao;

import java.util.List;

import com.huaweiyu.ant_moving.model.Test;

public interface TestDao {
	
	public List<Test> getAll();
	
	public void doTest();//第一次测试提交
	
}
