package com.jw.test.asm.jproto.fieldTypes.impl;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Type;

import com.google.protobuf.ByteString;
import com.jw.test.asm.jproto.classes.AbstractGenerator;
import com.jw.test.asm.jproto.fieldTypes.IFieldType;

public class FTStringImpl extends AbstractGenerator implements IFieldType{
	private String fieldName = null;
	private String halfFieldName = null;
	private ClassWriter cw = null;
	
	public static FTStringImpl getInstance(ClassWriter cw, String fieldName){
		return new FTStringImpl(cw, fieldName);
	}
	
	public FTStringImpl(ClassWriter cw, String fieldName){
		this.cw = cw;
		this.fieldName = fieldName;
		buildHalfMethodName();
	}
	public void generatorIntfMethod(){
		genIntfGet();
		genIntfByteGet();
	}
	
	private void genIntfGet(){
		cw.visitMethod(ACC_PUBLIC, buildGetMethodName(), "()" + Type.getDescriptor(String.class), null, null);
	}
	
	private void genIntfByteGet(){
		cw.visitMethod(ACC_PUBLIC, buildByteGetMethodName(), "()" + Type.getDescriptor(ByteString.class), null, null);
	}
	
	private String buildGetMethodName(){
		return "get" + halfFieldName;
	}
	
	private String buildByteGetMethodName(){
		return "get" + halfFieldName + "Bytes";
	}
	
	private void buildHalfMethodName(){
		halfFieldName = fieldName.length() == 1 ? fieldName.toUpperCase() : fieldName.substring(0, 1).toUpperCase().concat(fieldName.substring(1));
	}

	@Override
	public String getDescriptor(){
		return Type.getDescriptor(String.class);
	}
}
