package com.jw.test.asm.jproto;

public class NameHelper{
	private String packageName;// 包名称
	private String packageInternalName;// 包的内部名称
	private String internalName;// 外层类的全类名
	private String fullName;// 外层类的全名
	private String beanName;// bean的名字

	private static String builderIntf = "%sOrBuilder";

	public static String getBuilderIntf(String beanName){
		return String.format(builderIntf, beanName);
	}
	
}
