package com.jw.test.asm.jproto.exception;

@SuppressWarnings("serial")
public class ProtoFieldTypeException extends RuntimeException{
	public ProtoFieldTypeException(String fieldName, String fieldType){
		super(String.format("GRPC 不支持的数据类型：fieldName(%s),fieldType(%s)", fieldName, fieldType));
	}

	public String getErrorCode(){
		return "8001";
	}
}
