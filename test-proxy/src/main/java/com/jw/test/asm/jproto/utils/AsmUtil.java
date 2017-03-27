package com.jw.test.asm.jproto.utils;

import java.io.FileOutputStream;
import java.io.IOException;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class AsmUtil{
	public static void defaultConstruct(ClassWriter cw){
		MethodVisitor construct = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
		construct.visitCode();
		construct.visitVarInsn(Opcodes.ALOAD, 0);
		construct.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
		construct.visitInsn(Opcodes.RETURN);
		construct.visitMaxs(0, 0);
		construct.visitEnd();
	}

	public static Object instanceFromByte(final byte[] code, String fullClassName)
	        throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Class<?> clazz = new ClassLoader(){
			protected Class<?> findClass(String name) throws ClassNotFoundException{
				return defineClass(name, code, 0, code.length);
			}
		}.loadClass(fullClassName);
		return clazz.newInstance();
	}

	public static void save(String classPath, byte[] code) throws IOException{
		FileOutputStream fos = new FileOutputStream(classPath);
		fos.write(code);
		fos.close();
	}
}
