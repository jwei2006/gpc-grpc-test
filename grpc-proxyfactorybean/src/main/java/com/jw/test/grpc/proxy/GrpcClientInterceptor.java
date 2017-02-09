package com.jw.test.grpc.proxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.remoting.support.UrlBasedRemoteAccessor;
import org.springframework.util.Assert;

public class GrpcClientInterceptor extends UrlBasedRemoteAccessor implements MethodInterceptor{
	private GrpcProxyFactory proxyFactory = new GrpcProxyFactory();
	
	
	
	@Override
	public void afterPropertiesSet(){
		super.afterPropertiesSet();
		
	}
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		return null;
	}

	public void prepare(){
		
	}
	
	protected Object createHessianProxy(){
		Assert.notNull(getServiceInterface(), "'serviceInterface' is required");
		return proxyFactory.create(getServiceInterface(), getServiceUrl(), getBeanClassLoader());
	}
}
