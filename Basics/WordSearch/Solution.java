package WordSearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
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
            if (children[first-'a'] == null) children[first-'a'] = new TrieNode();
            children[first-'a'].insert(s.substring(1));
        }
        
        public boolean[] search(String s) {
            boolean[] ret  = new boolean[2];
            if(s.length() == 0) {
                ret[0] = true;
                ret[1] = isWord;
                return ret;
            }
            char first = s.charAt(0);
            if(children[first-'a'] != null) return children[first-'a'].search(s.substring(1));
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
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<String>();
        if(board.length == 0 || board[0].length == 0 || words.length == 0) return new ArrayList<String>(res);
        Trie trie = new Trie();
        for(String word : words) trie.insert(word);
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++)
                findAt(res, new StringBuilder(), board, trie, i, j);
        return new ArrayList<String>(res);
    }
    
    public void findAt(Set<String> res, StringBuilder prefix, char[][] board, Trie trie, int row, int col) {
        boolean[] searchRes = trie.search(prefix.toString());
        if(!searchRes[0]) return;
        if(searchRes[1]) res.add(prefix.toString()); //ret[1] = isWord;
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;
        char temp = board[row][col];
        prefix.append(temp);
        board[row][col] = (char) 'z' + 1;
        findAt(res, prefix, board, trie, row + 1, col);
        findAt(res, prefix, board, trie, row - 1, col);
        findAt(res, prefix, board, trie, row, col + 1);
        findAt(res, prefix, board, trie, row, col - 1);
        board[row][col] = temp;
        prefix.deleteCharAt(prefix.length() - 1);
    }
}