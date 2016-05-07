package WordSearchTural;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    	public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> result = new HashSet<String>();
        List<String> resultList = new ArrayList<String>();
        if(board==null || board.length==0 || words == null || words.length==0)
            return resultList;
        
        //creating a trie
        Trie root = new Trie();
        for (String word: words)
            insertWord(root,word);
            
        for(int i=0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
            	char temp = board[i][j];
                board[i][j] = (char)-1;
                dfs(board,root,new Location(i,j),result,new StringBuilder(String.valueOf(temp)));
                board[i][j] = temp;
            }
        }
        
        resultList.addAll(result);
        return resultList;
        
        
    }
    
    void dfs(char[][] board, Trie root, Location start, HashSet<String> words, StringBuilder current){
        
        int result = containsPrefix(root,current.toString());
        if(result==2) 
            words.add(current.toString());
        else if(result == 0){
//        	current = new StringBuilder(current.substring(0,current.length()-1));
        	return;
        }
        for(Location adj : getAdj(board,start)){
        	char temp = board[adj.row][adj.col];
            current.append(temp);
            board[adj.row][adj.col] = (char)-1;
            dfs(board,root,adj,words,current);
            current.setLength(current.length() - 1);
            board[adj.row][adj.col] = temp;
        }
    }
    
    private ArrayList<Location> getAdj(char[][] board, Location loc){
        ArrayList<Location> adjs = new ArrayList<Location>();
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                if(loc.row+i<board.length && loc.row+i>=0 &&
                    loc.col+j<board[0].length && loc.col+j>=0 && Math.abs(i+j)==1 &&
                    board[loc.row+i][loc.col+j] != (char)-1)
                        adjs.add(new Location(loc.row+i,loc.col+j));
            }
        }
        return adjs;
    }
    
    /**
    0 if there is no prefix
    1 if there is prefix
    2 if prefix is actual word
    **/
    private int containsPrefix(Trie root, String word){
        for(int i=0;i<word.length();i++){
            if(root.children[word.charAt(i)-'a']==null) return 0;
            root = root.children[word.charAt(i)-'a'];
        }
        if(root.isWord) return 2;
        for(Trie t : root.children)
            if(t != null) return 1;
        return 0;
    }
    
    
    
    
    private void insertWord(Trie root, String word){
        for(int i=0;i<word.length();i++){
            if(root.children[word.charAt(i)-'a']==null) 
                root.children[word.charAt(i)-'a'] = new Trie();
            root = root.children[word.charAt(i)-'a'];
        }
        root.isWord = true;
    }
    
}



class Trie{
    boolean isWord;
    Trie [] children;
    public Trie(){
        this.children = new Trie[26];
    }
}


class Location{
    int row, col;
    public Location(int row, int column){
        this.row = row;
        this.col = column;
    }
}