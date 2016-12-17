
public class Person {
	String name;
	double height;
	double weight;
	
	public Person(String name, double height, double weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	
	public void walk() {
		System.out.println(name + " is walking");
	}
	
	public void messureHeight(){
		System.out.println("height of" + name + "is " + height);
	}
}
