package crazygen;

import java.util.ArrayList;
import java.util.List;

public class CrazyGen {
	public static void main(String [] args) {
		int[] testArray = new int[] {1,2,3,4};
		List<List<Integer>> resultList = new ArrayList<>();
		dfs(testArray, new ArrayList<>(), resultList);
		for(List<Integer> list : resultList) {
			System.out.println(list);
		}
	}
	
	private static void dfs(int[] arr, List<Integer> tempResult, List<List<Integer>> resultList) {
		if(tempResult.size() == arr.length) {
			resultList.add(new ArrayList<Integer>(tempResult));	
		}
		else {
			for(int i = 0; i < arr.length; i++) {
				if(!tempResult.contains(arr[i])){
					tempResult.add(arr[i]);				
					dfs(arr, tempResult, resultList);
					tempResult.remove(tempResult.size() - 1);
				}
			}
		}
	}

}
