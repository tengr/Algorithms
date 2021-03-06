package Trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    // Initialize your data structure here.
	char c;
    Map<Character, TrieNode> children;
    public TrieNode() {
    	this(' ');
    }
    public TrieNode(char c){
        this.children = new HashMap<Character, TrieNode>();
        this.c = c;
    }
    public void insert(String word) {
        if(word == null || word.length() == 0) {
        	this.children.put('\0', new TrieNode('\0'));
        	return;
        }
        //when there is char left in the word
        char first = word.charAt(0);
        if(!this.children.containsKey(first)) this.children.put(first, new TrieNode(first));
        this.children.get(first).insert(word.substring(1));
    } 
    public boolean search(String word) {
    	if (word == null || word.length() == 0) return false;
    	if (word.charAt(word.length() - 1) != '\0') word += '\0';
    	return startsWith(word);
    }
    
    public boolean startsWith(String word) {
    	if (word == null || word.length() == 0) return true;
        //root
        if(this.c == ' ') {
            if(this.children.containsKey(word.charAt(0))) 
            	return this.children.get(word.charAt(0)).startsWith(word);
            else return false;
        }
        
        if(word.length() == 1) {
        	return this.c == word.charAt(0);
        }
        
        if (word.charAt(0) == this.c) {
            if(this.children.containsKey(word.charAt(1))) 
            	return this.children.get(word.charAt(1)).startsWith(word.substring(1));
            else return false;
        }
        else return false;
    }
}