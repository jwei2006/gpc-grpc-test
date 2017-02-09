package com.jw.test.grpc.proxy.intf;

public interface IServiceProxyFactory {
	public Object create(Class api, String url) throws java.net.MalformedURLException;
}
