package com.example.myspring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController 
public class ClientController {

	@Autowired
	public RestTemplate restTemplate;
	
	/*@Autowired 
	public DiscoveryClient discoveryClient; */
	
	@Autowired
	private LoadBalancerClient loadBalancer;
	
	@RequestMapping(value="/client")
	@HystrixCommand(fallbackMethod="callWhenFail")
	public String callService()
	{
	
		//String url = "http://hello-server/hello";
		/*List<ServiceInstance> serviceInstenceList = discoveryClient.getInstances("hello-server");
		ServiceInstance si = serviceInstenceList.get(0);
		String baseUri = si.getUri().toString();
		String url=  baseUri + "/hello";*/
		System.out.println("--call service----");
		ServiceInstance  serviceInstence = loadBalancer.choose("hello-server");
		String baseUri = serviceInstence.getUri().toString();
		String url=  baseUri + "/hello";
		
		String responseData = restTemplate.getForObject(url, String.class);
		
		return responseData;
		
	}
	
	public String callWhenFail(){
		System.out.println("---failback-------------");
		return "Something went wrong, hystrix call";
	}
	
	
}
