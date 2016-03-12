
public class Person {

	private String name;
	
	public Person(){
		//what should I type here? I should return something here but I don't know what I should return.
	}
	
	public Person(String theName){
		this.name = theName;
	}
	
	public Person (Person theObject){
		this(theObject.name); // why? what does this mean?
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String theName){
		this.name = theName;
	}
	
	public String toString(){
		return name;		
	}
	
	//public boolean equals(Object other){
		// what does this mean in the Person Class?
		// what's the function of this method?
		// To test the methods? or?
	//}
	
}
