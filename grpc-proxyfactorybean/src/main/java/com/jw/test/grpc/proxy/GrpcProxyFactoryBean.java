package com.jw.test.grpc.proxy;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.FactoryBean;

public class GrpcProxyFactoryBean extends GrpcClientInterceptor implements FactoryBean<Object>{
	private Object serviceProxy;
	
	@Override
	public void afterPropertiesSet() {
		super.afterPropertiesSet();
		this.serviceProxy = new ProxyFactory(getServiceInterface(), this).getProxy(getBeanClassLoader());
	}

	@Override
	public Object getObject() throws Exception{
		return serviceProxy;
	}

	@Override
	public Class<?> getObjectType(){
		return getServiceInterface();
	}

	@Override
	public boolean isSingleton(){
		return false;
	}

}
