package com.founder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * 整个工程的启动入口
 */
@ServletComponentScan
@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
@EnableScheduling
public class StartAppMain extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(StartAppMain.class,args);
    }
}
