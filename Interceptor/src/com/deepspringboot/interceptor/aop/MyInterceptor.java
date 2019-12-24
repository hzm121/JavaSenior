package com.deepspringboot.interceptor.aop;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

public class MyInterceptor implements Interceptor {
    @Override
    public void before() {
        System.out.println("事前方法---------"+new Date());
    }

    @Override
    public void after() {
        System.out.println("事后方法---------"+new Date());
    }

    @Override
    public Object arround(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        System.out.println("arround方法前---------"+new Date());
        Object o = invocation.proceed();
        System.out.println("arround方法后---------"+new Date());
        return o;
    }

    @Override
    public void afterReturning() {
        System.out.println("事后返回方法---------"+new Date());
    }

    @Override
    public void afterThrowing() {
        System.out.println("事后异常方法---------"+new Date());
    }

    @Override
    public boolean useAround() {
        return false;
    }
}
