package com.jw.test.asm.jproto.fieldTypes.impl;

import org.objectweb.asm.ClassWriter;

import com.jw.test.asm.jproto.classes.AbstractGenerator;
import com.jw.test.asm.jproto.fieldTypes.IFieldType;

public class FTProtoImpl extends AbstractGenerator implements IFieldType{
	private String fieldName = null;
	private String halfFieldName = null;
	private ClassWriter cw = null;
	private String fieldFullType;
	
	public static FTProtoImpl getInstance(ClassWriter cw, String fieldName, String fieldFullType){
		return new FTProtoImpl(cw, fieldName, fieldFullType);
	}
	
	public FTProtoImpl(ClassWriter cw, String fieldName, String fieldFullType){
		this.cw = cw;
		this.fieldName = fieldName;
		this.fieldFullType = fieldFullType;
		buildHalfMethodName();
	}
	
	private void buildHalfMethodName(){
		halfFieldName = fieldName.length() == 1 ? fieldName.toUpperCase() : fieldName.substring(0, 1).toUpperCase().concat(fieldName.substring(1));
	}
	@Override
	public String getDescriptor(){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void generatorIntfMethod(){
		// TODO Auto-generated method stub

	}

}
