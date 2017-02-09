package com.jw.test.grpc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;

import com.jw.test.grpc.proxy.intf.IServiceProxyFactory;

public class GrpcProxyFactory implements IServiceProxyFactory, ObjectFactory{
	private ClassLoader loader;

	public GrpcProxyFactory(){
		this(Thread.currentThread().getContextClassLoader());
	}
	
	public GrpcProxyFactory(ClassLoader loader){
		this.loader = loader;
	}

	@Override
	public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment) throws Exception{
		return null;
	}

	@Override
	public Object create(Class<?> api, String url){
		return create(api, url, loader);
	}

	public Object create(Class<?> api, String url, ClassLoader classLoader){
		String[] _url = url.split(":");
		if(null == _url || _url.length != 2) throw new NullPointerException("invalid remote url");
		InvocationHandler handler = new GrpcProxy(_url[0], Integer.parseInt(_url[1]));

		return Proxy.newProxyInstance(classLoader, new Class[]{api}, handler);
	}
}
