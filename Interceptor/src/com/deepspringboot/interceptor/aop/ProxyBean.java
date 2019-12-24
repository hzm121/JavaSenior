package com.deepspringboot.interceptor.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBean implements InvocationHandler {

    //目标对象
    private Object target = null;
    //拦截器
    private Interceptor interceptor = null;

    public static Object getBean(Object target, Interceptor interceptor) {
        //代理对象
        ProxyBean proxyBean = new ProxyBean();
        //保存代理对象
        proxyBean.target = target;
        //保存拦截器
        proxyBean.interceptor = interceptor;
        //织入代理对象
        Object object = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), proxyBean);
        return object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //异常标志
        boolean exceptionFlag = false;
        Object obj = null;
        Invocation invocation = new Invocation(this.target, args, method);
        this.interceptor.before();
        try {
            if (this.interceptor.useAround()) {
                obj = interceptor.arround(invocation);
            } else {
                method.invoke(target,args);
            }
        } catch (Exception e) {
            exceptionFlag = true;
        }
        this.interceptor.after();
        if (exceptionFlag) {
            this.interceptor.afterThrowing();
        } else {
            this.interceptor.afterReturning();
        }
        return obj;
    }
}
