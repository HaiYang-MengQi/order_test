package org.haiyang.orderdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;
@EnableScheduling
@SpringBootApplication
@MapperScan("org.haiyang.orderdemo.dao")
public class OrderDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(OrderDemoApplication.class, args);
//        Arrays.stream(configurableApplicationContext.getBeanDefinitionNames()).filter(s -> s.contains("redis")).forEach(System.out::println);
    }

}
