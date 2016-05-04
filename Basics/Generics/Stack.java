package Generics;

public class Stack<T> {
	protected static final int defaultSize = 16;
	protected int size;
	protected T[] arr;
	protected int top;
	
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack(20);
		System.out.println(stack.size());
	}
	
	
	public Stack() {
		this(defaultSize);
	}
	
	public Stack(int size) {
		this.size = size;
		arr = (T[]) new Object[size];
		top = 0;
	}
	
	public T pop() {
		if(!isEmpty()) 
			return arr[top--];
		else 
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return top == 0;
	}
	
}
