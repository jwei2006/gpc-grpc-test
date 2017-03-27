package com.jw.test.asm.jproto.classes;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import com.jw.test.asm.jproto.utils.AsmUtil;

public class BeanGenerator extends AbstractGenerator{
	private ClassWriter cw = null;
	private String pkg = null;
	private String beanName = null;
	public static BeanGenerator getInstance(String pkg, String beanName){
		return new BeanGenerator(pkg, beanName);
	}
	public BeanGenerator(String pkg, String beanName){
		this.pkg = pkg;
		this.beanName = beanName;
	}
	public ClassWriter generator(ClassWriter outer){
		cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
		cw.visit(V1_7, ACC_PUBLIC + ACC_STATIC, getInternalName_pre(pkg) + beanName, null, Type.getInternalName(com.google.protobuf.GeneratedMessageV3.class),
		        new String[]{getInternalName_beanIntf(pkg, beanName)});
		
		

		buildInner(outer, cw, pkg, beanName);
		return cw;
	}
	
	public ClassWriter getClassWriter(){
		return cw;
	}
	
	private void buildConstructor(){
		MethodVisitor construct1 = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "(" + Type.getDescriptor(com.google.protobuf.GeneratedMessageV3.Builder.class) + ")V", null, null);
		construct1.visitCode();
		construct1.visitVarInsn(Opcodes.ALOAD, 0);
		construct1.visitVarInsn(Opcodes.ALOAD, 1);
		construct1.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "(" + Type.getDescriptor(com.google.protobuf.GeneratedMessageV3.Builder.class) + ")V", false);
		construct1.visitInsn(Opcodes.RETURN);
		construct1.visitMaxs(0, 0);
		construct1.visitEnd();
		MethodVisitor construct2 = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
		construct2.visitCode();
		construct2.visitVarInsn(Opcodes.ALOAD, 0);
		construct2.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
		
		construct2.visitInsn(Opcodes.RETURN);
		construct2.visitMaxs(0, 0);
		construct2.visitEnd();
	}
	private void fieldInit(MethodVisitor construct){
		
	}
}
