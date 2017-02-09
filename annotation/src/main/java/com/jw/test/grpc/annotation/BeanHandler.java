package com.jw.test.grpc.annotation;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

public class BeanHandler implements InvocationHandler {

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("ObjectProxy execute:" + method.getName());
		return method.invoke(proxy, args);
	}

	public static <T> T newInstance(Class<T> innerInterface) {
		ClassLoader classLoader = innerInterface.getClassLoader();
		Class[] interfaces = new Class[] { innerInterface };
		BeanHandler proxy = new BeanHandler();
		return (T) Proxy.newProxyInstance(classLoader, interfaces, proxy);
	}
}
