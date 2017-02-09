package com.jw.test.grpc.proxy;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;
import io.netty.util.Constant;

@SuppressWarnings("serial")
public class GrpcProxy implements InvocationHandler, Serializable{
	private String url;
	private int port;
	private ManagedChannel channel;
	
	private final String serviceSuffix = "Grpc";
	private final String blockingStubSuffix = "BlockingStub";
	private final String stubSuffix = "Stub";
	
	
	public GrpcProxy(String url, int port){
		this.url = url;
		this.port = port;
		channel = NettyChannelBuilder.forAddress(this.url, this.port).usePlaintext(true).build();
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
		Class api = method.getClass();
		api.getMethod("newBlockingStub", null);
		return null;
	}

}
