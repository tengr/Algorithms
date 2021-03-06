package LeetCodeJava;
import java.util.*;
public class PermutationsWithDuplicates {
	public static void main(String[] args){
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		PermutationsWithDuplicates ins = new PermutationsWithDuplicates();
		
		ArrayList<ArrayList<Integer>> res = ins.permute(a);
		for(ArrayList l : res) {
			//System.out.println(l);
		}
	}
	
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    if (a == null || a.size() == 0) return res;
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for(Integer num : a) {
	        if(!map.containsKey(num)) map.put(num, 1);
	        else map.put(num, map.get(num) + 1);
	    }
	    System.out.println(map);

	    //System.out.println(map);
        dfs(res, map, new ArrayList<Integer>(), a.size());
        return res;
	}
	
	public void dfs(ArrayList<ArrayList<Integer>> res, Map<Integer, Integer> map, ArrayList<Integer> currList, int targetSize) {
	    if (currList.size() == targetSize) {
	    	System.out.println(map);
	    	System.out.println(currList);
	        res.add(new ArrayList(currList));
	        return;
	    }
	    for(Integer num : map.keySet()){
	        int count = map.get(num);
	        if(count > 0) {
	            currList.add(num);
	            map.put(num, count - 1);
	            //System.out.println(map);
	            dfs(res, map, currList,targetSize);
	            //System.out.println(map);
	            currList.remove(currList.size() - 1);
	            map.put(num, count);
	        }
	    }
	}
}
