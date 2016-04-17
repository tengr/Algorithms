public class Test{
	public static void main(String[] args) {
		System.out.println("test");
	}
	public class MyClass implements Comparable<MyClass>{
		public int compareTo(MyClass b){
			return -1;
		}
	}
}