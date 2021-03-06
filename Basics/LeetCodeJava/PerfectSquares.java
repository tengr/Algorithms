package LeetCodeJava;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class PerfectSquares {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.numSquares(20);
	}
	static class Solution {
	    public int numSquares(int n) {
	        int[] table = new int[n+1];
	        Queue<Integer> q = new LinkedList<>();
	        Map<Integer, Integer> parent = new HashMap<>();
	        int dist = 0;
	        q.offer(0);
	        while(!q.isEmpty()){
	            int numNBs = q.size();
	            for(int i = 0; i < numNBs; i++){
	                int node = q.poll();
	                table[node] = dist;
	                if(node == n) {q.clear();break;}
	                for(int num = 1; num * num + node <= n; num++){
	                    int newNode = num * num + node;
	                    if(!parent.containsKey(newNode)) {
	                    	System.out.println("newNode : " + newNode);
	                        parent.put(newNode, node);
	                        q.offer(newNode);
	                    }
	                }
	            }
	            dist++;
	        }
	        for(int node = n; parent.containsKey(node); node  = parent.get(node)){
	            System.out.print(node + " +");
	        }
	        return table[n];
	    }
	}
}
