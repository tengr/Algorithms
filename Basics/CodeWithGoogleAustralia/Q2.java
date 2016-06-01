package CodeWithGoogleAustralia;

import java.util.*;

public class Q2 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for(int i = 0; i < testCase; i++) {
			int N = sc.nextInt();
			int c = sc.nextInt();
			Map<Integer, List<TreeSet<Integer>>> map = new HashMap<>();
			for(int n = 0; n < N-1; n++) {
				addEdge(map, sc.nextInt(), sc.nextInt(), sc.nextInt());
			}
			System.out.println(solve(map));
		}
	}
	
	public static void addEdge(Map<Integer, List<TreeSet<Integer>>> map, int u, int v, int c){
		if(!map.containsKey(c)){
			List<TreeSet<Integer>> list = new ArrayList<>();
			TreeSet<Integer> treeSet = new TreeSet<>();
			treeSet.add(u);
			treeSet.add(v);
			list.add(treeSet);
			map.put(c,list);
		}
		else{
			List<TreeSet<Integer>> list = map.get(c);
			TreeSet<Integer> uSet = null, vSet = null;
			for(TreeSet<Integer> treeSet : list){
				if(treeSet.contains(u)) {
					uSet = treeSet;
				}
				else if(treeSet.contains(v)){
					vSet = treeSet;
				}
			}
			
			if(uSet == null && vSet == null) {
				TreeSet<Integer> treeSet = new TreeSet<>();
				treeSet.add(u);
				treeSet.add(v);
				list.add(treeSet);
			}
			else if (uSet == null) {
				vSet.add(u);
			}
			else if(vSet == null) {
				uSet.add(v);
			}
			else{
				uSet.addAll(vSet);
				list.remove(vSet);
			}
		}
	}
	public static long solve(Map<Integer, List<TreeSet<Integer>>> map){
		long ret = 0;
		for(List<TreeSet<Integer>> list : map.values()){
			for(TreeSet<Integer> treeSet : list) {
				long len = treeSet.size();
				ret += len * (len - 1) / 2;
			}
		}
		return ret;
	}
}
