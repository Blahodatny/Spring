package com.project;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.project.service.CustomerService;

class Application {
    public static void main(String[] args) {
        var appContext = new ClassPathXmlApplicationContext("appContext.xml");
        var service = appContext.getBean("customerService", CustomerService.class);
        System.out.println(service.findAll().get(0).getFirstName());
    }
}