package com.jw.test.asm.jproto.fieldTypes.impl;

import com.jw.test.asm.jproto.fieldTypes.IFieldType;

public class MTVoidImpl implements IFieldType{

	@Override
	public String getDescriptor(){
		return "V";
	}

	@Override
	public void generatorIntfMethod(){
		
	}

}
