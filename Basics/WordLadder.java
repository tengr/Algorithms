import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public static void main(String[] args){
		WordLadder ins = new WordLadder();
		Set<String> wordList = new HashSet<String>();
		wordList.add("hit");
		wordList.add("hot");
		wordList.add("lot");
		wordList.add("dog");
		wordList.add("dot");
		wordList.add("log");
//		wordList.add("a");
//		wordList.add("b");
//		wordList.add("c");
//		System.out.println(ins.ladderLength("a", "c", wordList));
		System.out.println(ins.ladderLength("hit", "cog", wordList));
	}
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (wordList == null || beginWord == null || endWord == null) return 0;
        HashMap<String, Integer> visited = new HashMap<String, Integer>();
        Queue<String> q = new LinkedList<String>();
        q.add(beginWord);
        int level = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int index = 0; index < size; index++) {
	            String word = q.remove();
	            for(int i = 0; i < word.length(); i++){
	                for(char c = 'a'; c <= 'z'; c++) {
	                    if (word.charAt(i) == c) continue;
	                    StringBuilder sb = new StringBuilder(word);
	                    sb.setCharAt(i, c);
	                    String newWord = sb.toString();
	                    if(newWord.equals(endWord)) return level + 1;
	                    if(wordList.contains(newWord) && !visited.containsKey(newWord)){
	                        q.add(newWord);
	                        //System.out.println(newWord + " " + newDist);
	                        visited.put(newWord, level);
	                    }
	                }
	            }
            }
            level++;
        }
        return 0;
    }
}