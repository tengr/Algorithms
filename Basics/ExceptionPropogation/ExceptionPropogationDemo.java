package ExceptionPropogation;

public class ExceptionPropogationDemo {
	public static void main(String[] args) {
		ExceptionPropogationDemo ins = new ExceptionPropogationDemo();
		ins.method1();
	}
	public void method1() {
		method2();
		System.out.println("Method 1 finish.");
	}
	public void method2() {
		method3();
		System.out.println("Method 2 finish.");
	}	public void method3() {
		method4();
		System.out.println("Method 3 finish.");
	}	public void method4() {
		method5();
		System.out.println("Method 4 finish.");
	}	public void method5() {
		method6();
		System.out.println("Method 5 finish.");
	}
	public void method6() {
		int a = 3 / 0;
		System.out.println("Method 6 finish.");
	}
}
