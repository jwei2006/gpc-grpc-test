package com.jw.test.asm;

import java.io.IOException;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

public class T2 implements Opcodes{
	public byte[] create(){
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
		cw.visit(V1_7, ACC_PUBLIC, "com/jw/test/asm/n/TT2", null, "java/lang/Object", null);
		AsmUtil.defaultConstruct(cw);

		String param1 = Type.getDescriptor(com.google.protobuf.ExtensionRegistryLite.class);
		String des1 =  "(" + param1 + ")V";
		MethodVisitor registerAllExtensions = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "registerAllExtensions", des1, null, null);
		registerAllExtensions.visitCode();
		registerAllExtensions.visitInsn(RETURN);
		registerAllExtensions.visitEnd();

		String param2 = Type.getDescriptor(com.google.protobuf.ExtensionRegistry.class);
		MethodVisitor registerAllExtensions2 = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "registerAllExtensions", "(" + param2 + ")V", null, null);
		registerAllExtensions2.visitCode();
		registerAllExtensions2.visitVarInsn(RET, 1);
		registerAllExtensions2.visitMethodInsn(INVOKESPECIAL, "com/jw/test/asm/n/TT2", "registerAllExtensions", des1);
		registerAllExtensions2.visitInsn(RETURN);
		registerAllExtensions2.visitEnd();

		cw.visitEnd();

		return cw.toByteArray();
	}

	public static void main(String[] args){
		T2 t2 = new T2();
		final byte[] code = t2.create();
		try{
			AsmUtil.save("TT2.class", code);
			Object obj = AsmUtil.instanceFromByte(code, "com.jw.test.asm.n.TT2");
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
