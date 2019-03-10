package cn.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cn.com.pojo.User;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private RestTemplate restTemplate=null;
	
	@GetMapping("/ribbon")
	public User testRibbon() {
		User userPo=null;
		for (int i = 0; i <20; i++) {
			userPo=restTemplate.getForObject("http://WMCUSER/user/user/"+(i+1), User.class);
		}
		return userPo;
	}
	
	
	
	

}
