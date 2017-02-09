package com.jw.test.grpc.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.TYPE})
//@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Grpc {
	String value() default "";
//	Class serviceInterface();
//	String server() default "";
}
