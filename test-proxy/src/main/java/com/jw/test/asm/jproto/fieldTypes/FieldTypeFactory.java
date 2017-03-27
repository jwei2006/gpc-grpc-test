package com.jw.test.asm.jproto.fieldTypes;

import java.util.HashMap;
import java.util.Map;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Type;

import com.jw.test.asm.jproto.exception.ProtoFieldTypeException;
import com.jw.test.asm.jproto.fieldTypes.impl.FTBooleanImpl;
import com.jw.test.asm.jproto.fieldTypes.impl.FTByteImpl;
import com.jw.test.asm.jproto.fieldTypes.impl.FTCharImpl;
import com.jw.test.asm.jproto.fieldTypes.impl.FTDoubleImpl;
import com.jw.test.asm.jproto.fieldTypes.impl.FTFloatImpl;
import com.jw.test.asm.jproto.fieldTypes.impl.FTIntImpl;
import com.jw.test.asm.jproto.fieldTypes.impl.FTListImpl;
import com.jw.test.asm.jproto.fieldTypes.impl.FTLongImpl;
import com.jw.test.asm.jproto.fieldTypes.impl.FTMapImpl;
import com.jw.test.asm.jproto.fieldTypes.impl.FTProtoImpl;
import com.jw.test.asm.jproto.fieldTypes.impl.FTShortImpl;
import com.jw.test.asm.jproto.fieldTypes.impl.FTStringImpl;
import com.jw.test.asm.jproto.fieldTypes.impl.MTVoidImpl;

public class FieldTypeFactory{
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
	
	public static IFieldType getType(Class<?> fieldType, ClassWriter cw, String fieldName, String fullFieldType){
		switch(fieldType.getSimpleName()){
			case "byte" : return FTByteImpl.getInstance(cw, fieldName);
			case "char" : return FTCharImpl.getInstance(cw, fieldName);
			case "double" : return FTDoubleImpl.getInstance(cw, fieldName);
			case "float" : return FTFloatImpl.getInstance(cw, fieldName);
			case "int" : return FTIntImpl.getInstance(cw, fieldName);
			case "long" : return FTLongImpl.getInstance(cw, fieldName);
			case "short" : return FTShortImpl.getInstance(cw, fieldName);
			case "boolean" : return FTBooleanImpl.getInstance(cw, fieldName);
			case "String" : return FTStringImpl.getInstance(cw, fieldName);
			case "Map" : return FTMapImpl.getInstance(cw, fieldName);
			case "List" : return FTListImpl.getInstance(cw, fieldName);
			case "TypeProtoImpl" : return FTProtoImpl.getInstance(cw, fieldName, fullFieldType);
			default : throw new ProtoFieldTypeException(fieldName, fieldType.getName());
		}
	}
	
	protected static String getObjectInternal(){
		return Type.getInternalName(Object.class);
	}
	
	protected static String getDescriptor(Class<?> type){
		if(types.containsKey(type.getName())) return types.get(type.getName());
		return Type.getDescriptor(type);
	}
	
	public static void main(String[] args){
	}
}
