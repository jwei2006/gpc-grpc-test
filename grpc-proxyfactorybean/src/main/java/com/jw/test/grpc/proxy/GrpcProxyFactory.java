package com.jw.test.grpc.proxy;

import java.net.MalformedURLException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;

import com.jw.test.grpc.proxy.intf.IServiceProxyFactory;

public class GrpcProxyFactory implements IServiceProxyFactory, ObjectFactory {

	@Override
	public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment)
			throws Exception {
		return null;
	}

	@Override
	public Object create(Class api, String url) throws MalformedURLException {
		return null;
	}

}
