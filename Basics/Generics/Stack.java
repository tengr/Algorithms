package Generics;

public class Stack<T> {
	protected static final int defaultSize = 16;
	protected int size;
	protected T[] arr;
	protected int top;
	
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		System.out.println(stack.size());
		for(int i = 0; i < 100; i++) stack.push(i);
		System.out.println("size = " + stack.size());
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		System.out.println("size = " + stack.size());

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
			return arr[--top];
		else return null;
	}
	
	protected void resize() {
		System.out.println("resize");
		Object[] temp = new Object[size * 2];
		for(int i = 0; i < top; i++) {
			temp[i] = arr[i];
		}
		size *= 2;
		arr = (T[]) temp;
		
	}
	
	public void push(T t) {
		System.out.println("top = " + top);
		if (top == size) resize();
		arr[top++] = t;
	}
	
	public int size() {
		return this.top;
	}
	
	public boolean isEmpty() {
		return top == 0;
	}
	
}
