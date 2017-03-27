package com.jw.test.asm.e4;

import java.io.IOException;
import java.lang.reflect.Method;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.InnerClassNode;

import com.jw.test.asm.AsmUtil;

public class InnerClass implements Opcodes{
	private String innerClassName = "com/jw/test/asm/e4/E4";
	private String fullClassName = "com.jw.test.asm.e4.E4";
	public static void main(String[] args){
		InnerClass t = new InnerClass();
		t.create();
	}
	
	public void create(){
		
		
		ClassWriter cwInner = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
		cwInner.visit(V1_7, ACC_PUBLIC, "com/jw/test/asm/e4/E4$TInner", null, "java/lang/Object", null);
		AsmUtil.defaultConstruct(cwInner);
		
		cwInner.visitField(ACC_PRIVATE, "innerField", Type.getDescriptor(String.class), null, "dsaojf");
		cwInner.visitOuterClass("com/jw/test/asm/e4/E4", null, null);
		
		MethodVisitor mv = cwInner.visitMethod(ACC_PUBLIC, "print", "(Ljava/lang/String;)V", null, null);
		mv.visitCode();
		mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
//		mv.visitLdcInsn("阿斯法律框架阿斯");
		mv.visitVarInsn(ALOAD, 1);
		mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
		mv.visitInsn(RETURN);
		mv.visitMaxs(0, 0);
		mv.visitEnd();
		cwInner.visitEnd();
		
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
		cw.visit(V1_7, ACC_PUBLIC, innerClassName, null, "java/lang/Object", null);
		AsmUtil.defaultConstruct(cw);
		cw.visitInnerClass("com/jw/test/asm/e4/E4$TInner", "com/jw/test/asm/e4/E4", "TInner", ACC_PUBLIC + ACC_STATIC);
		
		cw.visitField(ACC_PUBLIC, "f1", Type.getDescriptor(String.class), null, "799");
		
		MethodVisitor mv1 = cw.visitMethod(ACC_PUBLIC, "oPrint", "()V", null, null);
		mv1.visitCode();
		mv1.visitTypeInsn(NEW, "com/jw/test/asm/e4/E4$TInner");
		mv1.visitInsn(DUP);
		mv1.visitMethodInsn(INVOKESPECIAL, "com/jw/test/asm/e4/E4$TInner", "<init>", "()V", false);
		
//		mv1.visitVarInsn(ALOAD, 1);
		mv1.visitLdcInsn("访问内部类");
		mv1.visitMethodInsn(INVOKEVIRTUAL, "com/jw/test/asm/e4/E4$TInner", "print", "(Ljava/lang/String;)V", false);
		mv1.visitInsn(RETURN);
		mv1.visitMaxs(0, 0);
		mv1.visitEnd();
		
		cw.visitEnd();
		
		final byte[] codeInner = cwInner.toByteArray();
		final byte[] code = cw.toByteArray();
		
		try{
			AsmUtil.save("/data/tmp/E4.class", code);
			AsmUtil.save("/data/tmp/E4$TInner.class", codeInner);
			
			Class<?> clazzInner = new ClassLoader(){
				protected Class<?> findClass(String name) throws ClassNotFoundException{
					return defineClass(name, codeInner, 0, codeInner.length);
				}
			}.loadClass("com.jw.test.asm.e4.E4$TInner");
			
			Class<?> clazz = new ClassLoader(){
				protected Class<?> findClass(String name) throws ClassNotFoundException{
					defineClass("com.jw.test.asm.e4.E4$TInner", codeInner, 0, codeInner.length);
					return defineClass(name, code, 0, code.length);
				}
			}.loadClass(fullClassName);
			
			
			Object o1 = clazz.newInstance();
			Method m1 = clazz.getMethod("oPrint", null);
			m1.invoke(o1, null);
			
			
//			Object o = clazzInner.newInstance();
//			Method m = clazzInner.getMethod("print", String.class);
//			m.invoke(o, "asdfm");
			 
			
		}catch(IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
