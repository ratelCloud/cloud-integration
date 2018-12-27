package com.ratel.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
* demo启动
* <p>
* @author niexiang
* @version  1.0.0
* @date 2018/12/26
*/
@SpringBootApplication(scanBasePackages = "com.ratel.common"
									+ ",com.ratel.demo")
@EnableDiscoveryClient
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
