package com.huaweiyu.ant_moving.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaweiyu.ant_moving.dao.TestDao;
import com.huaweiyu.ant_moving.model.Test;
import com.huaweiyu.ant_moving.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService{

	@Autowired
	private TestDao testDao;

	public List<Test> getAll() {
		return testDao.getAll();
	}
	

}
