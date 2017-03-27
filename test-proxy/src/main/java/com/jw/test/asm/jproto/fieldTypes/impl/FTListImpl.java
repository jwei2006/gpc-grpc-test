package com.jw.test.asm.jproto.fieldTypes.impl;

import org.objectweb.asm.ClassWriter;

import com.jw.test.asm.jproto.fieldTypes.IFieldType;

public class FTListImpl implements IFieldType{
	private String fieldName = null;
	private String halfFieldName = null;
	private ClassWriter cw = null;
	
	public static FTListImpl getInstance(ClassWriter cw, String fieldName){
		return new FTListImpl(cw, fieldName);
	}
	
	public FTListImpl(ClassWriter cw, String fieldName){
		this.cw = cw;
		this.fieldName = fieldName;
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
