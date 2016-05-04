package StackOverflowError;

public class Test {
	public static void main(String[] args){
		Test ins = new Test();
		ins.method1();
		System.out.println("finished");
	}
	
	public void method1() {
		method2();
	}
	public void method2() {
		method1();
	}
}
