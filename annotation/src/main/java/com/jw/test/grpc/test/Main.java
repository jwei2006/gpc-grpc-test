package com.jw.test.grpc.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.jw.test.grpc.annotation.Grpc;
import com.jw.test.grpc.t.CustomizeScanTest;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();                
	    annotationConfigApplicationContext.register(CustomizeScanTest.class);
//	    annotationConfigApplicationContext.register(Main.class);
	    annotationConfigApplicationContext.refresh();
	    TestAnno test = annotationConfigApplicationContext.getBean(TestAnno.class);
	    test.test();
	}
}
