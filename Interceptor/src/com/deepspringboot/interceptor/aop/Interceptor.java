package com.deepspringboot.interceptor.aop;

import java.lang.reflect.InvocationTargetException;

public interface Interceptor {
    //事前方法
    public void before();
    //事后方法
    public void after();
    //方法执行
    public Object arround(Invocation invocation) throws InvocationTargetException,IllegalAccessException;
    //事后返回方法，事件没有发生异常执行
    public void afterReturning();
    //事后异常方法，事件发生异常时执行
    public void afterThrowing();
    //是否使用around方法
    public boolean useAround();
}
