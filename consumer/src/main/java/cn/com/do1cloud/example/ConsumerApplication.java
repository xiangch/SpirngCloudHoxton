package cn.com.do1cloud.example;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zengxc
 * @since 2020/11/10
 */
@EnableDiscoveryClient
@EnableAutoConfiguration
@ComponentScan(basePackages = {"cn.com.do1","cn.com.do1cloud"})
public class ConsumerApplication {


    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }






}
