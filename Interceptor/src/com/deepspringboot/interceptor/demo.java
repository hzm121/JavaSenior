package com.deepspringboot.interceptor;

import com.deepspringboot.interceptor.aop.MyInterceptor;
import com.deepspringboot.interceptor.aop.ProxyBean;
import com.deepspringboot.interceptor.service.HelloService;
import com.deepspringboot.interceptor.service.HelloServiceImpl;

public class demo {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        MyInterceptor myInterceptor = new MyInterceptor();
        HelloService proxyHelloservice = (HelloService)ProxyBean.getBean(helloService, myInterceptor);
        proxyHelloservice.sayhello();

    }
}
