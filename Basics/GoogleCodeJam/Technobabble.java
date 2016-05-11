package GoogleCodeJam;

import java.util.HashMap;
import java.util.Scanner;

public class Technobabble {
	int maxLen = 16;
	String[] first = new String[maxLen];
	String[] second = new String[maxLen];

	Technobabble ins = new Technobabble();
	
}

public int solve(Scanner sc, int N){
	HashMap<String, Integer> firstMap = new HashMap<>();
	HashMap<String, Integer> secondMap = new HashMap<>();
	for(int i = 0; i < N; i++) {
		first[i] = sc.next();
		if(!firstMap.containsKey(first[i])) firstMap.put(first[i], 0);
		firstMap.put(first[i], firstMap.get(first[i]) + 1);
		second[i] = sc.next();
		if(!secondMap.containsKey(second[i])) secondMap.put(second[i], 0);
		secondMap.put(second[i], secondMap.get(second[i]) + 1);
	}
	
	
	
}
	
