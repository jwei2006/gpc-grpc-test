package com.jw.test.asm.jproto.fieldTypes;

public interface IFieldType{
	public String getDescriptor();
//	public void createClass();
	/**
	 * @param fieldName
	 * @param fieldType
	 * @param fullFieldType proto类型
	 */
	public void generatorIntfMethod();
//	public ClassWriter getClassWriter();
}
