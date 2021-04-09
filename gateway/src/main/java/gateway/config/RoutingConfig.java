package gateway.config;//package com.tosantechno.gateway.config;
//
//import com.netflix.client.config.IClientConfig;
//import com.netflix.loadbalancer.IPing;
//import com.netflix.loadbalancer.IRule;
//import com.netflix.loadbalancer.PingUrl;
//import com.netflix.loadbalancer.WeightedResponseTimeRule;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author masoumeh moradi on 7/26/2020
// * Email: masoom.moradi2000@gmail.com
// */
//@Configuration
//public class RoutingConfig {
//
//
//    //@Autowired
//   // IClientConfig iClientConfig;
//
//    @Bean
//    public IRule ribbonRuleConfig(IClientConfig iClientConfig){
//        return new WeightedResponseTimeRule();
//    }
//    @Bean
//    public IPing ribbonPing(IClientConfig config) {
//        return new PingUrl();
//    }
//
//}
