
public class Vehicle {

	public String manufacturerName;
	public int engineNum;
	public Person owner;
	
	//constructor
	public Vehicle (String manufacturerName, int engineNum, Person owner){
		this.manufacturerName = manufacturerName;
		this.engineNum = engineNum;
		this.owner = owner;
		
		if (engineNum < 0)
			System.out.println("Error: the engine number cannot be negative.");
		System.exit(0);
	}
		
	public String getManufacturerName(){
		return manufacturerName;
	}
	
	public int getEngineNum(){
		return engineNum;
	}
	
	public Person owner(){
		return owner;
	}
	
	public static void main (String[] args){
		Vehicle a = new Truck("Toyato",6,null, 5.8,9);
		System.out.println();
	}
		
}
