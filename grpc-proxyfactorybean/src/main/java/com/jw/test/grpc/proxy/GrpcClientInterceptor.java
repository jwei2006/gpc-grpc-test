package com.jw.test.grpc.proxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.remoting.support.UrlBasedRemoteAccessor;
import org.springframework.util.Assert;

public class GrpcClientInterceptor extends UrlBasedRemoteAccessor implements MethodInterceptor{
	private GrpcProxyFactory proxyFactory = new GrpcProxyFactory();
	private Object grpcProxy;

	@Override
	public void afterPropertiesSet(){
		super.afterPropertiesSet();
		prepare();
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable{
		if(null == grpcProxy){
			throw new Exception("远程服务获取不到");
		}
		ClassLoader originalClassLoader = overrideThreadContextClassLoader();
		try{
			return invocation.getMethod().invoke(this.grpcProxy, invocation.getArguments());
		}finally{
			resetThreadContextClassLoader(originalClassLoader);
		}
	}

	public void prepare(){
		this.grpcProxy = createGrpcProxy();
	}

	protected Object createGrpcProxy(){
		Assert.notNull(getServiceInterface(), "serviceInterface' is required");
		return proxyFactory.create(getServiceInterface(), getServiceUrl(), getBeanClassLoader());
	}
}
