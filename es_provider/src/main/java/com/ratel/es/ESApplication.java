package com.ratel.es;


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
@SpringBootApplication(scanBasePackages = "com.ratel.es" +
		",com.ratel.common")
@EnableDiscoveryClient
public class ESApplication {
	public static void main(String[] args) {
		SpringApplication.run(ESApplication.class, args);
	}
}
