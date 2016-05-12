package LeetCodeJava;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveDuplicateLetters {
    public class Solution {
        public String removeDuplicateLetters(String s) {
            Deque<Integer>[] map = new Deque[26];
            int[] freq = new int[26];
            int numChar = 0;
            //initialize data structure
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(freq[c-'a'] == 0) {
                    numChar++;
                    map[c-'a'] = new LinkedList<Integer>();
                }
                freq[c-'a']++;
                map[c-'a'].offer(i); //double queue storing the positions of the char
            }
            
            StringBuilder sb = new StringBuilder();
            int charIdx = 0; //our target char
            int charPos = -1; //the position of the target char in the string
            while(numChar > 0){
                while(freq[charIdx] == 0) charIdx = (charIdx + 1) % 26; //find the smallest alphabetical char as target
                boolean writeChar = true; //can we write the char or not
                int i = (charIdx + 1) % 26; //check from the next char, go wrap around the indexes
                while(i != charIdx) {
                    if(freq[i] == 0 || map[charIdx].peekFirst() < map[i].peekLast()) {
                        i = (i + 1) % 26; 
                        /*the smallest position of our target char is smaller than the last position of the other, 
                        meaning the other char appears after the char we attemp to write*/
                    }
                    else{
                        //there is a char that doesn't appear after me, we can't write the target char 
                        writeChar = false;
                        break;
                    }
                }
                if(writeChar) {
                        sb.append((char) (charIdx + 'a'));
                        charPos = map[charIdx].peekFirst();
                        /*mark the position of the target char, as all the position before is no longer useful*/
                        freq[charIdx] = 0;
                        numChar--;
                        for(int j = 0; j < 26; j++) {
                            if(freq[j] == 0) continue;
                            while(map[j].peekFirst() < charPos) map[j].removeFirst(); //remove all the smaller positions
                        }
                        charIdx = 0; //start from the beginning, search from the smallest alphabetical char as target again
                        
                }
                else {
                    charIdx++; //start from the next char
                }
            }
            return sb.toString();
            
        }
    }
}
