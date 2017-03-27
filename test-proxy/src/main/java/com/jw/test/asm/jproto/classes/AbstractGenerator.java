package com.jw.test.asm.jproto.classes;

import java.util.HashMap;
import java.util.Map;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import com.jw.test.asm.jproto.NameHelper;
import com.jw.test.asm.jproto.fieldTypes.impl.MTVoidImpl;

public class AbstractGenerator implements Opcodes{

	public static String typeDescriptor_void = "V";
	public static String typeDescriptor_byte = "B";
	public static String typeDescriptor_char = "C";
	public static String typeDescriptor_double = "D";
	public static String typeDescriptor_float = "F";
	public static String typeDescriptor_int = "I";
	public static String typeDescriptor_long = "J";
	public static String typeDescriptor_short = "S";
	public static String typeDescriptor_boolean = "Z";

	public static Map<String, String> types = new HashMap<String, String>();
	static{
		types.put(byte.class.getName(), typeDescriptor_byte);
		types.put(char.class.getName(), typeDescriptor_char);
		types.put(double.class.getName(), typeDescriptor_double);
		types.put(float.class.getName(), typeDescriptor_float);
		types.put(int.class.getName(), typeDescriptor_int);
		types.put(long.class.getName(), typeDescriptor_long);
		types.put(short.class.getName(), typeDescriptor_short);
		types.put(boolean.class.getName(), typeDescriptor_boolean);
		types.put(MTVoidImpl.class.getName(), typeDescriptor_void);

	}

	protected static String getObjectInternal(){
		return Type.getInternalName(Object.class);
	}

	protected static String getDescriptor(Class<?> type){
		if(types.containsKey(type.getName())) return types.get(type.getName());
		return Type.getDescriptor(type);
	}

	protected static String getDescriptor(String type){
		switch(type){
			case "String":
				return Type.getDescriptor(String.class);
			case "void":
				return typeDescriptor_void;
			case "byte":
				return typeDescriptor_byte;
			case "char":
				return typeDescriptor_char;
			case "double":
				return typeDescriptor_double;
			case "float":
				return typeDescriptor_float;
			case "int":
				return typeDescriptor_int;
			case "long":
				return typeDescriptor_long;
			case "short":
				return typeDescriptor_short;
			case "boolean":
				return typeDescriptor_boolean;
			case "V":
				return type;
			case "B":
				return type;
			case "C":
				return type;
			case "D":
				return type;
			case "F":
				return type;
			case "I":
				return type;
			case "J":
				return type;
			case "S":
				return type;
			case "Z":
				return type;
			default:{
				if(type.startsWith("L") && type.endsWith(";")) return type;
				return "L" + type + ";";
			}
		}
	}

	protected String getInternalName_pre(String pkg){
		if(pkg.indexOf("$") == -1){
			if(pkg.endsWith("/")) return pkg.replaceAll("\\.", "/");
			else return pkg.replaceAll("\\.", "/").concat("/");
		}else if(pkg.endsWith("$")) return pkg.replaceAll("\\.", "/");
		else return pkg.replaceAll("\\.", "/").concat("$");
	}

	protected String getInternalName_outer(String pkg){
		if(pkg.endsWith("/")) return pkg.replaceAll("\\.", "/").substring(0, pkg.length() - 1);
		else if(pkg.endsWith("$")) return pkg.replaceAll("\\.", "/").substring(0, pkg.length() - 1);
		else return pkg.replaceAll("\\.", "/");
	}
	
	protected String getInternalName_beanIntf(String pkg, String beanName){
		String beanName_internal = NameHelper.getBuilderIntf(beanName);
		return getInternalName_pre(pkg) + beanName_internal;
	}

	protected void buildInner(ClassWriter outer, ClassWriter inner, String pkg, String beanName_internal){
		String internalName_bean = getInternalName_pre(pkg) + beanName_internal;
		String internalName_outer = getInternalName_outer(pkg);
		inner.visitOuterClass(internalName_outer, null, null);
		outer.visitInnerClass(internalName_bean, internalName_outer, beanName_internal, ACC_PUBLIC + ACC_STATIC);
	}

	/*protected String getOuterInternalName(String pkg){
		if(pkg.indexOf("$") != -1){
			return pkg.substring(0, pkg.lastIndexOf("$"));
		}else{
			if(pkg.endsWith("/")) pkg = pkg.substring(0, pkg.length() - 1);
			return pkg.substring(0, pkg.lastIndexOf("/"));
		}
	}*/

	public static void main(String[] args){
		AbstractGenerator a = new AbstractGenerator();
		String s = "com.test.T1/";
		System.out.println(a.getInternalName_outer(s));
	}
}
