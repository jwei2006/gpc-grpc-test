package com.jw.test.asm.e2;

import java.awt.List;
import java.io.IOException;
import java.util.Map;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import com.jw.test.asm.AsmUtil;

public class CreateByte implements Opcodes{
	private String internalName = "com/jw/test/asm/e2/E2";
	private String fullClassName = "com.jw.test.asm.e2.E2";

	public static void main(String[] args){
		CreateByte c = new CreateByte();
		try{
			c.create();
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

	public void create() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
//		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
		cw.visit(V1_7, ACC_PUBLIC, internalName, null, "java/lang/Object", null);
		AsmUtil.defaultConstruct(cw);

//		_while(cw);
		_for(cw);
//		dowhile(cw);

		byte[] code = cw.toByteArray();

		AsmUtil.save("/data/tmp/E2.class", code);

		AsmUtil.instanceFromByte(code, fullClassName);
	}

	public void _for(ClassWriter cw){
		MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "_for", "()V", null, null);
		mv.visitCode();
		// mv.visitInsn(ICONST_3);
		// mv.visitVarInsn(ISTORE, 2);//int i = 2;
		// mv.visitLdcInsn("first");
		// mv.visitVarInsn(ASTORE, 3);
		// Label l0 = new Label();
		// mv.visitLabel(l0);
		// mv.visitLdcInsn("second");
		// mv.visitVarInsn(ASTORE, 4);

		Label l1 = new Label();
		mv.visitLabel(l1);
		mv.visitInsn(ICONST_2);
		mv.visitVarInsn(ISTORE, 1);// int i = 2;

		Label l3 = new Label();

		Label l2 = new Label();
		mv.visitJumpInsn(GOTO, l2);

		mv.visitLabel(l3);
		mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
//		mv.visitFrame(Opcodes.F_APPEND, 1, new Object[]{Opcodes.INTEGER}, 0, null);
		mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
		mv.visitLdcInsn(">>>>>>>>>>\u6211\u662f\u5e38\u91cf");
		mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
		// mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
		// mv.visitLdcInsn(">>>>>>>>>>\u6211\u662f\u5e38\u91cf");
		// mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println",
		// "(Ljava/lang/String;)V");

		Label l4 = new Label();
		mv.visitLabel(l4);
		mv.visitIincInsn(1, 2);// i++;

		mv.visitLabel(l2);
		mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);

		mv.visitVarInsn(ILOAD, 1);
		mv.visitIntInsn(BIPUSH, 8);
		mv.visitJumpInsn(IF_ICMPLT, l3);

		mv.visitInsn(RETURN);

		mv.visitMaxs(2, 2);
		mv.visitEnd();
	}
	public void _for2(ClassWriter cw){
		MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "_for", "()V", null, null);
		mv.visitCode();
		// mv.visitInsn(ICONST_3);
		// mv.visitVarInsn(ISTORE, 2);//int i = 2;
		// mv.visitLdcInsn("first");
		// mv.visitVarInsn(ASTORE, 3);
		// Label l0 = new Label();
		// mv.visitLabel(l0);
		// mv.visitLdcInsn("second");
		// mv.visitVarInsn(ASTORE, 4);
		
		Label l1 = new Label();
		mv.visitLabel(l1);
		mv.visitInsn(ICONST_2);
		mv.visitVarInsn(ISTORE, 1);// int i = 2;
		
		Label l3 = new Label();
		
		Label l2 = new Label();
		mv.visitJumpInsn(GOTO, l2);
		
		mv.visitLabel(l3);
//		mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
		mv.visitFrame(Opcodes.F_APPEND, 1, new Object[]{Opcodes.INTEGER}, 0, null);
		mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
		mv.visitLdcInsn(">>>>>>>>>>\u6211\u662f\u5e38\u91cf");
		mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
		// mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
		// mv.visitLdcInsn(">>>>>>>>>>\u6211\u662f\u5e38\u91cf");
		// mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println",
		// "(Ljava/lang/String;)V");
		
		Label l4 = new Label();
		mv.visitLabel(l4);
		mv.visitIincInsn(1, 2);// i++;
		
		mv.visitLabel(l2);
		mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
		
		mv.visitVarInsn(ILOAD, 1);
		mv.visitIntInsn(BIPUSH, 8);
		mv.visitJumpInsn(IF_ICMPLT, l3);
		
		mv.visitInsn(RETURN);
		
		mv.visitMaxs(2, 2);
		mv.visitEnd();
	}

	public void dowhile(ClassWriter cw){
		MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "dowhile", "()V", null, null);
		mv.visitCode();

		Label l1 = new Label();
		mv.visitLabel(l1);
		mv.visitInsn(ICONST_2);
		mv.visitVarInsn(ISTORE, 1);// int i = 2;

		Label l3 = new Label();
		mv.visitLabel(l3);
		mv.visitFrame(Opcodes.F_APPEND, 1, new Object[]{Opcodes.INTEGER}, 0, null);
		mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
		mv.visitLdcInsn(">>>>>>>>>>\u6211\u662f\u5e38\u91cf");
		mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");

		Label l4 = new Label();
		mv.visitLabel(l4);
		mv.visitIincInsn(1, 2);// i++;

		Label l2 = new Label();
		mv.visitLabel(l2);
		mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);

		mv.visitVarInsn(ILOAD, 1);
		mv.visitIntInsn(BIPUSH, 8);
		mv.visitJumpInsn(IF_ICMPLT, l3);

		mv.visitInsn(RETURN);

		mv.visitMaxs(2, 2);
		mv.visitEnd();
	}
	
	public void _while3(ClassWriter cw){
		MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "_while", "()V", null, null);
		mv.visitCode();
		
		mv.visitInsn(ICONST_2);
		mv.visitIntInsn(ISTORE, 1);
		
		mv.visitLdcInsn(23l);
		mv.visitVarInsn(LSTORE, 2);
		
		mv.visitLdcInsn(10l);
		mv.visitVarInsn(LSTORE, 3);
//		mv.visitLdcInsn("sadufio");
//		mv.visitVarInsn(ASTORE, 4);
		
		Label l1 = new Label();
		mv.visitJumpInsn(GOTO, l1);
		
		Label l2 = new Label();
		

		
		mv.visitLabel(l2);
//		mv.visitFrame(F_SAME, 0, null, 0, null);
//		System.out.println(Type.getInternalName(Map.class));
//		System.out.println(List.class);
		mv.visitFrame(F_FULL, 4, new Object[]{internalName, INTEGER, TOP, LONG, "java/lang/String"}, 0, new Object[]{});
		mv.visitVarInsn(ILOAD, 1);
//		mv.visitFrame(F_FULL, 4, new Object[]{internalName, INTEGER, LONG, "java/lang/String"}, 0, new Object[]{});
//		mv.visitFrame(F_FULL, 4, new Object[]{internalName, INTEGER, LONG, Type.getInternalName(String.class)}, 0, new Object[]{});
//		mv.visitInsn(ICONST_0);
		mv.visitInsn(ICONST_2);
		mv.visitInsn(IADD);
		mv.visitInsn(POP);
//		mv.visitFrame(F_APPEND, 1, new Object[]{Opcodes.INTEGER}, 0, null);
//		mv.visitFrame(F_APPEND, 2, new Object[]{Opcodes.INTEGER, Opcodes.LONG}, 0, null);
//		mv.visitFrame(F_APPEND, 3, new Object[]{Opcodes.INTEGER, Opcodes.TOP, "java/lang/String"}, 0, null);
		/*mv.visitIntInsn(ILOAD, 2);
		mv.visitInsn(ICONST_1);
		mv.visitInsn(IADD);
		mv.visitVarInsn(ISTORE, 1);*/
		
		
//		mv.visitVarInsn(LLOAD, 2);
//		mv.visitInsn(LCONST_1);
//		mv.visitInsn(LADD);
//		mv.visitVarInsn(LSTORE, 2);
//		mv.visitVarInsn(LLOAD, 2);
//		mv.visitInsn(LCONST_1);
		
//		mv.visitInsn(ICONST_1);
//		mv.visitIntInsn(ISTORE, 4);
		
		/*Label l3 = new Label();
		mv.visitLabel(l3);
		mv.visitIincInsn(1, 1);*/
		
		mv.visitLabel(l1);
		mv.visitFrame(F_SAME, 0, null, 0, null);
//		mv.visitFrame(F_SAME, 0, null, 3, new Object[]{INTEGER, INTEGER, INTEGER, LONG});
//		mv.visitFrame(F_SAME, 3, new Object[]{internalName, INTEGER, LONG, Type.getInternalName(String.class)}, 0, new Object[]{});
//		mv.visitFrame(F_APPEND, 1, new Object[]{Opcodes.INTEGER}, 0, null);
		mv.visitIntInsn(ILOAD, 1);
//		mv.visitInsn(ICONST_3);
		mv.visitInsn(ICONST_2);
		mv.visitInsn(IADD);
		mv.visitInsn(POP);
//		mv.visitJumpInsn(IFNE, l2);
		
		mv.visitInsn(RETURN);
		mv.visitMaxs(20,20);
		mv.visitEnd();
		
	}
	
	public void _while(ClassWriter cw){

		MethodVisitor mv = cw.visitMethod(ACC_PUBLIC + ACC_VARARGS, "testMapList", "(Z[Ljava/util/Map;)V",
		        "(Z[Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;)Ljava/util/List<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;",
		        null);
		mv.visitCode();
		Label l0 = new Label();
		mv.visitLabel(l0);
		mv.visitTypeInsn(NEW, "java/util/ArrayList");
		mv.visitInsn(DUP);
		mv.visitMethodInsn(INVOKESPECIAL, "java/util/ArrayList", "<init>", "()V", false);
		mv.visitVarInsn(ASTORE, 3);
		
		Label l1 = new Label();
		mv.visitLabel(l1);
		mv.visitVarInsn(ILOAD, 1);
		Label l2 = new Label();
		mv.visitJumpInsn(IFEQ, l2);
		
		Label l3 = new Label();
		mv.visitLabel(l3);
		mv.visitVarInsn(ALOAD, 2);
		mv.visitInsn(DUP);
		mv.visitVarInsn(ASTORE, 7);
		mv.visitInsn(ARRAYLENGTH);
		mv.visitVarInsn(ISTORE, 6);
		mv.visitInsn(ICONST_0);
		mv.visitVarInsn(ISTORE, 5);
		
		Label l4 = new Label();
		mv.visitJumpInsn(GOTO, l4);
		
		Label l5 = new Label();
		mv.visitLabel(l5);
		mv.visitFrame(Opcodes.F_FULL, 8, new Object[]{internalName, Opcodes.INTEGER, "[Ljava/util/Map;", "java/util/List",
		        Opcodes.TOP, Opcodes.INTEGER, Opcodes.INTEGER, "[Ljava/util/Map;"}, 0, new Object[]{});
		mv.visitVarInsn(ALOAD, 7);
		mv.visitVarInsn(ILOAD, 5);
		mv.visitInsn(AALOAD);
		mv.visitVarInsn(ASTORE, 4);
		
		Label l6 = new Label();
		mv.visitLabel(l6);
		mv.visitVarInsn(ALOAD, 3);
		mv.visitVarInsn(ALOAD, 4);
		mv.visitMethodInsn(INVOKEINTERFACE, "java/util/List", "add", "(Ljava/lang/Object;)Z", true);
		mv.visitInsn(POP);
		
		Label l7 = new Label();
		mv.visitLabel(l7);
		mv.visitIincInsn(5, 1);
		
		mv.visitLabel(l4);
		mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
		mv.visitVarInsn(ILOAD, 5);
		mv.visitVarInsn(ILOAD, 6);
		mv.visitJumpInsn(IF_ICMPLT, l5);
		
		mv.visitLabel(l2);
//		mv.visitFrame(F_SAME, 0, null, 0, null);
		mv.visitFrame(Opcodes.F_FULL, 4, new Object[]{internalName, Opcodes.INTEGER, "[Ljava/util/Map;", "java/util/List"},
		        0, new Object[]{});
		mv.visitIntInsn(ILOAD, 1);
		
		Label l8 = new Label();
		mv.visitLabel(l8);
		mv.visitVarInsn(ALOAD, 3);
		mv.visitInsn(RETURN);
		
		Label l9 = new Label();
		mv.visitLabel(l9);
		mv.visitMaxs(4, 8);
		mv.visitEnd();
	
		_while3(cw);
	}
	public void _switch(ClassWriter cw){
		MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "_switch", Type.getDescriptor(Integer.class), null, null);
		mv.visitCode();
		
		Label l0 = new Label();
		Label l1 = new Label();
		Label l2 = new Label();
		Label l3 = new Label();
	}
}
