package com.deepspringboot.interceptor.aop;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Invocation {
    Object target;
    Object[] params;
    Method method;

    public Invocation(Object target,Object[] params,Method method){
        this.method = method;
        this.params = params;
        this.target = target;
    }

    public Object proceed() throws InvocationTargetException, IllegalAccessException {
        return method.invoke(target,params);
    }
}
