import java.lang.Math;
public class Lesson1 {
	public static void main(String[] args){
//		System.out.println("Hello World");
//		double a = 1, b = 3.14, c = 22.68;
//		System.out.println(calc(a,b,c));
//		double d = 1.56757;
//		System.out.println(calc(a,b,d));
		
		Person me = new Person("Ruichen", 1.72, 68.0);
		Person you = new Person("Teng Feng", 1.7, 60.0);
//		me.messureHeight();
//		you.messureHeight();
//		me.walk();
//		you.walk();
//		
		Person[] people = new Person[10];
		for(int i = 0; i < 10; i++) {
			people[i] = new Person("number " + i, i * 1.0, i * 20.0);
		}
		
		for(int i = 0; i < 10; i++) {
			people[i].messureHeight();
		}
	}
	
	public static double calc(double a, double b, double c) {
		if (a > 0)
		return Math.pow(Math.pow(a, b) / Math.pow(c, b), 2);
		else return 1 / Math.pow(Math.pow(a, b) / Math.pow(c, b), 2);
	}
	
}
