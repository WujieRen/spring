package com.cainiaossh.springfirst.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>
 * </p>
 *
 * @author renwujie
 * @since 2018-08-09 16:16
 */
public class SecurityHandler implements InvocationHandler {

    private Object targetObject;

    public Object createProxyInstance(Object targetObject) {
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(),
                this
                );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        checkSecurity();
        //调用目标方法
        Object ret = method.invoke(targetObject, args);
        return ret;
    }

    private void checkSecurity() {
        System.out.println("checkSecurity");
    }
}
