package cn.com.controller;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cn.com.pojo.User;
import cn.com.service.UserService;

@Component(value="productController2")
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private RestTemplate restTemplate=null;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/ribbon")
	public User testRibbon() {
		User userPo=null;
		for (int i = 0; i <20; i++) {
			userPo=restTemplate.getForObject("http://WMCUSER/user/user/"+(i+1), User.class);
		}
		return userPo;
	}
	
	//addUser
		@GetMapping("/addUser")
		public Map<String,Object> addUser(){
			Map<String, Object> map=new HashedMap();
			User user=new User();
			user.setId(222222);
			user.setLevel(789);
			user.setNote("22222note");
			user.setUserName("222wmcUserNs");
			Map<String,Object> aa=userService.addUser(user);
			return aa;
		}
		
	
	

}
