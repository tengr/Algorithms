package GarbageCollector;

public class GarbageCollectorDemo {
	class Dog {
		String name;
		public Dog(String name) {
			this.name = name;
		}
		public void setName(String name){
			this.name = name;
		}
		public String getName(){
			return this.name;
		}
	}
	public static void main(String[] args) {
		GarbageCollectorDemo ins = new GarbageCollectorDemo();
		ins.doSomething();
	}
	
	public void doSomething() {
		Dog aDog = new Dog("Max");
		Dog bDog =printDog(aDog);
		if(aDog.getName().equals("Max")) {
			System.out.println("1 = ");
		}
		else if (aDog.getName().equals("Cliff")){
			System.out.println("2 = ");
		}
		System.out.println(bDog.getName());
		
	}
	
	public Dog printDog(Dog aDog) {
		aDog.setName("Cliff");
		aDog = new Dog("asdfa");
		return aDog;
	}
	
	
}
