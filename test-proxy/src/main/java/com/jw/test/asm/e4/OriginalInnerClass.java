package com.jw.test.asm.e4;

public class OriginalInnerClass{
	private String s = "ad";
	public void t(){
		Inn inn = new Inn("sdaf");
		inn.print();
		SInn sInn = new SInn();
		sInn.print();
	}
	
	public class Inn{
		public Inn(String s){
			this.f = s;
		}
		public void print(){
			System.out.println(f);
		}
		private String f = "23fa";
	}
	
	public static class SInn{
		private String f = "1";
		public SInn(){
		}
		public void print(){
			System.out.println("asdflkjasdlfkasjdfljasdl");
		}
	}
}
