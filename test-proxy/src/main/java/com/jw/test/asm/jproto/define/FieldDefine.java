package com.jw.test.asm.jproto.define;

public class FieldDefine{
	private String name = null;
	private Class<?> type = null;
	private int order;
	/**
	 * 该子段是否是proto类型的
	 */
	private boolean isProto = false;
	private Object value = null;

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public Class<?> getType(){
		return type;
	}

	public void setType(Class<?> type){
		this.type = type;
	}

	public int getOrder(){
		return order;
	}

	public void setOrder(int order){
		this.order = order;
	}

	public boolean isProto(){
		return isProto;
	}

	public void setProto(boolean isProto){
		this.isProto = isProto;
	}

	public Object getValue(){
		return value;
	}

	public void setValue(Object value){
		this.value = value;
	}
}
