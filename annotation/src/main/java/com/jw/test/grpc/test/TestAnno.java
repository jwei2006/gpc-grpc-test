package com.jw.test.grpc.test;

import com.jw.test.grpc.annotation.Grpc;
import com.jw.test.grpc.annotation.GrpcResource;

@Grpc
public class TestAnno {
	@GrpcResource(server="http://127.0.0.1:50010")
	private ITest test;
	
	public String test(){
		return test.getTitle();
	}
}
