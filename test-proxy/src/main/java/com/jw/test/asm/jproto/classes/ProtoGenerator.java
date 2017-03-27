package com.jw.test.asm.jproto.classes;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import com.jw.test.asm.AsmUtil;
import com.jw.test.asm.jproto.general.RegisterHelper;

public class ProtoGenerator implements Opcodes{
	private String pkg = null;
	private String className = null;
	public static Class<?> generator(String internalName){
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
		cw.visit(V1_7, ACC_PUBLIC, internalName, null, "java/lang/Object", null);
		AsmUtil.defaultConstruct(cw);
		
		RegisterHelper.generatorRegister(cw, internalName);
		
		return null;
	}
}
