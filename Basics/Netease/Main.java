package Netease;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	public static void main(String[] args){
		Comparator<String> c1 = new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}			
		};
		ArrayList<String> list = new ArrayList<>();
		Collections.sort(list,(String s1, String s2) -> s1.length() - s2.length());
		Collections.sort(list, (s1, s2) -> (s1.length() - s2.length()));
		Collections.sort(list);
	}
	
}
