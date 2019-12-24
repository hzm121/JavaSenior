package com.deepspringboot.interceptor.service;

public class HelloServiceImpl implements HelloService {
    @Override
    public void sayhello() {
        System.out.println("Hello");
    }
}
