package com.jw.test.asm.jproto.general;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

public class RegisterHelper implements Opcodes{
	public static void generatorRegister(ClassWriter cw, String internalName){
		MethodVisitor mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "registerAllExtensions", "(Lcom/google/protobuf/ExtensionRegistryLite;)V", null, null);
		mv.visitCode();
		mv.visitInsn(RETURN);
		mv.visitMaxs(0, 0);
		mv.visitEnd();
		
		MethodVisitor mv1 = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "registerAllExtensions", "(Lcom/google/protobuf/ExtensionRegistry;)V", null, null);
		mv1.visitCode();
		mv1.visitVarInsn(ALOAD, 1);
		mv1.visitTypeInsn(CHECKCAST, Type.getInternalName(com.google.protobuf.ExtensionRegistryLite.class));
		mv1.visitMethodInsn(INVOKESTATIC, internalName, "registerAllExtensions", "(Lcom/google/protobuf/ExtensionRegistryLite;)V", false);
		mv1.visitInsn(RETURN);
		mv1.visitMaxs(0, 0);
		mv1.visitEnd();
	}
}
