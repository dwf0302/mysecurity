package com.bree.web.service.impl;

import com.bree.web.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String greeting(String name) {
        System.out.println("Greeting");
        return "hello"+name;
    }
}
