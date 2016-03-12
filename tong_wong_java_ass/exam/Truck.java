
public class Truck extends Vehicle {

	public double loadCapacity;
	public int towingCapacity;
	
	public Truck(String manufacturerName, int engineNum, Person owner, double loadCapacity, int towingCapacity){
		super(manufacturerName, engineNum, owner);
		if ((loadCapacity < 0) || (towingCapacity <0)){
			System.out.println("Error: load/towing capacity cannot be negative!");
			System.exit(0);
		}
		this.loadCapacity = loadCapacity;
		this.towingCapacity = towingCapacity;
	}	
	
	public double getLoadCapacity(){
		return loadCapacity;
	}
	
	public int getTowingCapacity(){
		return towingCapacity;
	}
	
	public String toString(){
		return super.toString() + " load Capacity: " + loadCapacity + "; towing capacity: " + towingCapacity + ".";
	}

	
}
