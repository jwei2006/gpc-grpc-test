package com.jw.test.asm.jproto.classes;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Type;

import com.jw.test.asm.jproto.NameHelper;
import com.jw.test.asm.jproto.fieldTypes.FieldTypeFactory;
import com.jw.test.asm.jproto.fieldTypes.IFieldType;

public class BuilderIntfGenerator extends AbstractGenerator{
	private ClassWriter cw = null;
	private String pkg = null;
	private String beanName = null;
	
	private final String t1 = String.class.getName();

	public BuilderIntfGenerator(String pkg, String beanName){
//		this.cw = cw;
		this.pkg = pkg;
		this.beanName = beanName;
	}
	/**
	 * @param pkg 包名字
	 * @param beanName bean原始的名字
	 * @return
	 */
	public static BuilderIntfGenerator getInstance(String pkg, String beanName){
		return new BuilderIntfGenerator(pkg, beanName);
	}
	public ClassWriter generator(ClassWriter outer){
		cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
		cw.visit(V1_7, ACC_PUBLIC + ACC_INTERFACE, getInternalName_beanIntf(pkg, beanName), null, getObjectInternal(),
		        new String[]{Type.getInternalName(com.google.protobuf.MessageOrBuilder.class)});
		buildInner(outer, cw, pkg, NameHelper.getBuilderIntf(beanName));
		
		return cw;
	}
	
	/*
	 * proto类型使用fullFieldType
	 * 其他类型使用fieldType
	 * */
	public void generatorMethod(ClassWriter builderIntf, String fieldName, Class<?> fieldType, String fullFieldType){
		IFieldType field = FieldTypeFactory.getType(fieldType, builderIntf, fieldName, fullFieldType);
		field.generatorIntfMethod();
	}
	
	public ClassWriter getClassWriter(){
		return cw;
	}
}
