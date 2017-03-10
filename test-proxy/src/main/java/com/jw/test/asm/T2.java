package com.jw.test.asm;

import java.io.IOException;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

public class T2 implements Opcodes{
	private String pkg = "com/jw/test/asm/n/TT2";
	public byte[] create(){
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
		cw.visit(V1_7, ACC_PUBLIC, pkg, null, "java/lang/Object", null);
		AsmUtil.defaultConstruct(cw);
		
		String param2 = Type.getDescriptor(com.google.protobuf.ExtensionRegistry.class);
		
//		createClassVar(cw, param2);

		String param1 = Type.getDescriptor(com.google.protobuf.ExtensionRegistryLite.class);
		String des1 =  "(" + param1 + ")V";
		MethodVisitor rae = cw.visitMethod(ACC_PUBLIC , "registerAllExtensions", des1, null, null);
		rae.visitCode();
		rae.visitInsn(RETURN);
		rae.visitEnd();

		MethodVisitor rae2 = cw.visitMethod(ACC_PUBLIC, "registerAllExtensions", "(" + param2 + param2 + "Ljava/lang/String;)V", null, null);
		rae2.visitCode();
		
//		visitClassVar(param2, rae2);
//		
//		visitInstanceMethod(des1, rae2);
		
//		createLocalList(rae2);
		
		createArray(rae2);
		
		ifMethod(rae2);
		
		rae2.visitInsn(RETURN);
		rae2.visitMaxs(2, 2);
		rae2.visitEnd();
		
		/*MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "testMethod", "(" + param2 + ")V", null, null);
		
		mv.visitCode();
//		mv.visitVarInsn(ILOAD, 1);
//		Label label = new Label();
//		mv.visitJumpInsn(IFLT, label);
		mv.visitVarInsn(ALOAD, 0);
		mv.visitVarInsn(ALOAD, 1);
		mv.visitFieldInsn(PUTFIELD, pkg, "f", param2);
//		Label end = new Label();
//		mv.visitJumpInsn(GOTO, end);
//		mv.visitLabel(label);
//		mv.visitFrame(F_SAME, 0, null, 0, null);
//		mv.visitTypeInsn(NEW, "java/lang/IllegalArgumentException");
//		mv.visitInsn(DUP);
//		mv.visitMethodInsn(INVOKESPECIAL,
//		"java/lang/IllegalArgumentException", "<init>", "()V");
//		mv.visitInsn(ATHROW);
//		mv.visitLabel(end);
//		mv.visitFrame(F_SAME, 0, null, 0, null);
		mv.visitInsn(RETURN);
		mv.visitMaxs(2, 2);
		mv.visitEnd();*/

		cw.visitEnd();

		return cw.toByteArray();
	}

	private void ifMethod(MethodVisitor mv){
//		rae2.visitInsn(ICONST_2);
//		rae2.visitInsn(ICONST_3);
//		Label check_ = new Label();
////		rae2.visitVarInsn(ISTORE, 7);
////		rae2.visitLdcInsn(50);
////		rae2.visitVarInsn(ISTORE, 8);
////		rae2.visitIntInsn(ILOAD, 7);
////		rae2.visitIntInsn(ILOAD, 8);
//		rae2.visitJumpInsn(IF_ICMPGE, check_);
//		Label checkEnd_ = new Label();
//		rae2.visitJumpInsn(GOTO, checkEnd_);
//		rae2.visitLabel(check_);
//		rae2.visitLabel(checkEnd_);
		
		
        Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitInsn(ICONST_0);
        mv.visitVarInsn(ISTORE, 10);
        Label l1 = new Label();
        mv.visitLabel(l1);
        Label l2 = new Label();
        mv.visitJumpInsn(GOTO, l2);
        Label l3 = new Label();
        mv.visitLabel(l3);
        mv.visitFrame(Opcodes.F_APPEND, 1, new Object[] { Opcodes.INTEGER }, 0, null);
//        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
//        mv.visitLdcInsn(">>>>>>>>>>\u6211\u662f\u5e38\u91cf");
//        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        Label l4 = new Label();
        mv.visitLabel(l4);
//        mv.visitIincInsn(1, 1);
        mv.visitLabel(l2);
        mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
//        mv.visitIntInsn(BIPUSH, 8);
        mv.visitLdcInsn(2);
//        mv.visitIntInsn(BIPUSH, 9);
        mv.visitJumpInsn(IFNE, l3);
        Label l5 = new Label();
        mv.visitLabel(l5);
        mv.visitInsn(RETURN);
        Label l6 = new Label();
        mv.visitLabel(l6);
		
		
		/*Label label = new Label();
		rae2.visitInsn(ICONST_2);
		rae2.visitJumpInsn(IFLT, label);
		
		rae2.visitVarInsn(ALOAD, 0);
		rae2.visitInsn(ICONST_2);
		rae2.visitFieldInsn(PUTFIELD, pkg, "f", "I");
		
		Label l2 = new Label();
//		rae2.visitJumpInsn(GOTO, l2);
		
		rae2.visitInsn(ICONST_4);
		rae2.visitInsn(ICONST_M1);
		rae2.visitJumpInsn(IF_ICMPGT, l2);
		
		Label end = new Label();
		rae2.visitJumpInsn(GOTO, end);
		
		
		rae2.visitLabel(label);
		rae2.visitFrame(F_SAME, 0, null, 0, null);
		
		rae2.visitLabel(l2);
		rae2.visitFrame(F_SAME, 0, null, 0, null);
		
//		rae2.visitTypeInsn(NEW, "java/lang/IllegalArgumentException");
//		rae2.visitInsn(DUP);
//		rae2.visitMethodInsn(INVOKESPECIAL,	"java/lang/IllegalArgumentException", "<init>", "()V");
//		rae2.visitInsn(ATHROW);
		
		rae2.visitLabel(end);
		rae2.visitFrame(F_SAME, 0, null, 0, null);*/
	}

	private void createArray(MethodVisitor rae2){
		//定义数组
		rae2.visitLdcInsn(20);
		rae2.visitIntInsn(NEWARRAY, T_INT);
		rae2.visitVarInsn(ASTORE, 5);//赋值给变量
//		rae2.visitFieldInsn(Opcodes.PUTSTATIC, "my/Foo", "_my_instances", "Ljava/util/List;");
		rae2.visitLdcInsn(30);
		rae2.visitTypeInsn(ANEWARRAY, "package1/class1");
		rae2.visitVarInsn(ASTORE, 6);
		
		rae2.visitVarInsn(ALOAD, 5);
		rae2.visitInsn(ICONST_2);
		rae2.visitInsn(ICONST_5);
		rae2.visitInsn(IASTORE);
	}

	private void createLocalList(MethodVisitor rae2){
		rae2.visitTypeInsn(NEW, "java/util/ArrayList");  
		rae2.visitInsn(Opcodes.DUP);
		rae2.visitLdcInsn(2);
		rae2.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/util/ArrayList", "<init>", "(I)V");
		rae2.visitVarInsn(ASTORE, 4);
	}

	private void createClassVar(ClassWriter cw, String param2){
		FieldVisitor fv = cw.visitField(ACC_PRIVATE, "asdf", param2, null, null);
		fv.visitEnd();
		FieldVisitor fv1 = cw.visitField(ACC_PRIVATE, "asdf1", param2, null, null);
		fv1.visitEnd();
	}

	private void visitClassVar(String param2, MethodVisitor rae2){
		rae2.visitVarInsn(ALOAD, 0);
		rae2.visitVarInsn(ALOAD, 2);
		rae2.visitFieldInsn(PUTFIELD, pkg, "asdf1", param2);//赋值类变量
		rae2.visitVarInsn(ALOAD, 3);
		rae2.visitFieldInsn(PUTSTATIC, pkg, "a", "Ljava/lang/String;");//static
	}

	private void visitInstanceMethod(String des1, MethodVisitor rae2){
		rae2.visitVarInsn(ALOAD, 0);//this
		rae2.visitVarInsn(ALOAD, 1);//param1
		rae2.visitMethodInsn(INVOKEVIRTUAL, pkg, "registerAllExtensions", des1);
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
