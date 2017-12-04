package com.huaweiyu.ant_moving.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huaweiyu.ant_moving.model.Test;
import com.huaweiyu.ant_moving.service.TestService;

@Controller
@RequestMapping("/testController")
public class TestController {

	@Autowired
	private TestService testService;
	
	@RequestMapping("/showView")
	public String showView(ModelMap modelMap){
		return "/test";
	}
	
	@RequestMapping("/getList")
	@ResponseBody
	public List<Test> getList(){
		return testService.getAll();
	}
	
 	public String getUserInfo(){
 		return "xiejianfeng";
 	}
}
