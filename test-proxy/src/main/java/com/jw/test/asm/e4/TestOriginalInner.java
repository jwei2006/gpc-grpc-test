package com.jw.test.asm.e4;

import com.jw.test.asm.e4.OriginalInnerClass.Inn;

public class TestOriginalInner{
	public static void main(String[] args){
		OriginalInnerClass outer = new OriginalInnerClass();
		Inn inn = outer.new Inn("asd");
		inn.print();
		com.jw.test.asm.e4.OriginalInnerClass.SInn sInn = new com.jw.test.asm.e4.OriginalInnerClass.SInn();
		sInn.print();
	}
}
