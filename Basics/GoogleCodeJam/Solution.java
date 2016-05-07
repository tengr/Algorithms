package GoogleCodeJam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
public class Solution {
	static HashMap<String, Integer> s2i;
	static HashMap<Integer, String> i2s;
	Trie trie = new Trie();
	static{
		s2i = new HashMap<>();
		i2s = new HashMap<>();
		s2i.put("ZERO", 0);
    	s2i.put("ONE", 1);
    	s2i.put("TWO", 2);
    	s2i.put("THREE", 3);
    	s2i.put("FOUR", 4);
    	s2i.put("FIVE", 5);
    	s2i.put("SIX", 6);
    	s2i.put("SEVEN", 7);
    	s2i.put("EIGHT", 8);
    	s2i.put("NINE", 9); 
    	for(String k : s2i.keySet()) i2s.put(s2i.get(k), k);
	}
	
    class TrieNode{
        TrieNode[] children;
        boolean isWord;
        public TrieNode() {
            children = new TrieNode[27];
            isWord = false;
        }
        public void insert(String s) {
            if (s.length() == 0) {isWord = true; return;}
            char first = s.charAt(0);
            if (children[first-'A'] == null) children[first-'A'] = new TrieNode();
            children[first-'A'].insert(s.substring(1));
        }
        
        public boolean[] search(String s) {
            boolean[] ret  = new boolean[2];
            if(s.length() == 0) {
                ret[0] = true;
                ret[1] = isWord;
                return ret;
            }
            char first = s.charAt(0);
            if(children[first-'A'] != null) return children[first-'A'].search(s.substring(1));
            else return ret;
        }
        
    }
    class Trie{
        TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
        public void insert(String s) {
            root.insert(s);
        }
        public boolean[] search(String s){
            return root.search(s);
        }
    }
 
    
    public static void main(String[] args) {
    	Solution ins = new Solution();
    	Scanner sc = new Scanner(System.in);
    	for(String s : s2i.keySet()) ins.trie.insert(s);
    	int testCase = sc.nextInt();
    	for(int i = 1; i <= testCase; i++) System.out.println("Case #" + i + ": " + ins.find(ins.trie, sc.next()));
    	sc.close();
    	
    	//String input = sc.nextLine();
//    	String input = "OZONETOWER";
//    	ins.find(ins.trie, input);

    	//System.out.println("\nfinished");
    }
    
    public String find(Trie trie, String input) {
    	ArrayList<Integer>nums = new ArrayList<Integer>();
    	ArrayList<Integer>res = new ArrayList<Integer>();
    	dfs(trie, "", 0, nums, res, input.toCharArray());
    	//System.out.println(res.toString());
    	StringBuilder sb = new StringBuilder();
    	for(Integer num : res) sb.append(num);
    	return sb.toString();
    	
    }
    
    public void dfs(Trie trie, String prefix, int totalLength, ArrayList<Integer> nums, ArrayList<Integer>res, char[] message){
		//System.out.println("length = " + totalLength);
    	if(totalLength == message.length) {
    		res.addAll(nums);
    		return;
    	}
    	if(!res.isEmpty()) return;
    	for(int i = 0; i < message.length; i++) {
    		char tempChar = message[i];
    		if(tempChar == (char)'Z' + 1) continue;
    		String temp = prefix + tempChar;
    		//System.out.println(" temp = " + temp);
    		boolean[] searchRes = trie.search(temp);
    		if(!searchRes[0]) continue; //no further trie nodes
    		else if(searchRes[1]) { //a number word found
    			//System.out.print(temp);
    			if(nums.isEmpty() || s2i.get(temp) >= nums.get(nums.size() - 1)){
    				nums.add(s2i.get(temp));
    		    	//for(Integer num : nums) System.out.print(num + " ");
    				message[i] = (char)'Z' + 1;
    				dfs(trie, "", totalLength + temp.length(), nums, res, message);
    				nums.remove(nums.size() - 1);
    				message[i] = tempChar;
    			}
    		}
    		else {
				message[i] = (char)'Z' + 1;
				dfs(trie, temp, totalLength, nums, res, message);
				message[i] = tempChar;
    		}

    	}

		//System.out.println();
    }
    
    
}