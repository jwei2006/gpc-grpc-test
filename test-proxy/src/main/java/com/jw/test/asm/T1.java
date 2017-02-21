package com.jw.test.asm;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

public class T1{
	public byte[] c(){
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
		cw.visit(Opcodes.V1_7, Opcodes.ACC_PUBLIC, "com/jw/test/asm/n/TT1", null, "java/lang/Object", null);

		MethodVisitor construct = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
		construct.visitCode();
		construct.visitVarInsn(Opcodes.ALOAD, 0);
		construct.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
		construct.visitInsn(Opcodes.RETURN);
		construct.visitMaxs(0, 0);
		construct.visitEnd();

		FieldVisitor userName = cw.visitField(Opcodes.ACC_PRIVATE + Opcodes.ACC_FINAL, "userName", "Ljava/lang/String;", null, "ui89");
		userName.visitEnd();
		
		FieldVisitor classType = cw.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "classType", Type.getDescriptor(Class.class), Type.getDescriptor(Type.class), null);
		classType.visitEnd();
		
		cw.visitEnd();

		return cw.toByteArray();

	}

	public Object instance(final byte[] code) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Class<?> clazz = new ClassLoader(){
			protected Class<?> findClass(String name) throws ClassNotFoundException{
				return defineClass(name, code, 0, code.length);
			}
		}.loadClass("com.jw.test.asm.n.TT1");
		return clazz.newInstance();
	}
	
	public void save(String classPath, byte[] code) throws IOException{
		FileOutputStream fos = new FileOutputStream(classPath);
		fos.write(code);
		fos.close();
	}
	
	public static void main(String[] args){
		System.out.println(Type.getDescriptor(String.class));
		System.out.println(Type.getDescriptor(T1.class));
		
		T1 t1 = new T1();
		final byte[] code = t1.c();
		try{
			t1.save("TT1.class", code);
			Object obj = t1.instance(code);
			System.out.println(obj);
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(InstantiationException e){
			e.printStackTrace();
		}catch(IllegalAccessException e){
			e.printStackTrace();
		}
	}
}
