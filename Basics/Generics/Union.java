package Generics;

import java.util.HashSet;
import java.util.Set;

public class Union<E>{
	public static void main(String[] args){
		Union<Integer> ins = new Union<Integer>();
		Set<Integer> a = new HashSet<Integer>();
		for(int i = 0; i < 10; i++) a.add(i);
		Set<Integer> b = new HashSet<Integer>();
		for(int i = 0; i < 5; i++) b.add(i);
		
		for(Integer num : ins.intersect(a, b)) System.out.print(num);
		System.out.println("=========");
		for(Integer num : ins.union(a, b)) System.out.print(num);

	}
	
	
	public Set<E> intersect(Set<E> a, Set<E> b) {
		Set<E> res = new HashSet<E>();
		for(E e : a) {
			if(b.contains(e)) res.add(e);
		}
		return res;

	}
	
	public Set<E> union(Set<E> a, Set<E> b) {
		Set<E> res = new HashSet<E>(a);
		for(E e : b) res.add(e);
		return res;
	}
}



