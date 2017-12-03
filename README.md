# microservice-springboot-springcloud-eureka

Zuul, Spring Cloud Eureka and Hystrix(fallbackMethod and Circuit Breaker) 

Components : 
Spring Cloud Eureka : service registry

Zuul : (edge server) This is the Gateway/Edge Service which is registered with Eureka and routes the requests to Client and Server using Eureka Service


Hystrix : fallbackMethod and Circuit Breaker


Application:

edureka-spring-service  - The Eureka service which is the Service Registry

ms-spring-service - The Service which is going to give data to the Client.

ms-spring-service-client - The Service which is going to get data from Server via the Discovery Service from the Service Registry (eureka-service).

ms-spring-zuul-proxy - This is the Gateway/Edge Service which is registered with Eureka and routes the requests to Client and Server using Eureka Service
                                
                                
