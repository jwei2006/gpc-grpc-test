package com.jw.test.grpc.netty;

import java.util.concurrent.TimeUnit;

//import com.test.grpc.service.TestRpcServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;

public class Client {
	private String host = "";
	private int port = 50010;
	/*public Client(){
		ManagedChannel channel =  NettyChannelBuilder.forAddress(host, port).usePlaintext(true).build();
        client = TestRpcServiceGrpc.newBlockingStub(channel).withDeadlineAfter(60000, TimeUnit.MILLISECONDS);
	}*/
}
