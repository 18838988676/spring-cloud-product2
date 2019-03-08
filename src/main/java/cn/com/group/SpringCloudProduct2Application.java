package cn.com.group;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages="cn.com")
public class SpringCloudProduct2Application {
	
	//初始化负载均衡
		@LoadBalanced  //多借点负载均衡
		@Bean(name="restTemplate")
		public RestTemplate initRestTemplate() {
			return new RestTemplate();
		}
		

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudProduct2Application.class, args);
	}

}
