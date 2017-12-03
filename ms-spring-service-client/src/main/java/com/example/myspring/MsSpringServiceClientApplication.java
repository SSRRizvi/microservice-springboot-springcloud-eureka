package com.example.myspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
@ComponentScan(basePackages="com.example.myspring")
public class MsSpringServiceClientApplication {

	public static void main(String[] args) {
		 SpringApplication.run(MsSpringServiceClientApplication.class, args);
		/*ApplicationContext ctx = SpringApplication.run(MsSpringServiceClientApplication.class, args);
		
		System.out.println("--------Circuit breaker------------------code---test---");
		
		ClientController cc = (ClientController)ctx.getBean(ClientController.class);
		for(int i=0;i<1000;i++)
		cc.callService();*/
	}
	
	/*@Bean
	public  ClientController  clientController()
	{
		return  new ClientController();
	}*/

}
