package Trie;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public static void main(String[] args) {
    	Trie trie = new Trie();
    	 trie.insert("somestring");
    	 System.out.println(trie.search("key"));
    	 System.out.println(trie.search("somestring"));
    	 System.out.println(trie.startsWith("some"));
    	 System.out.println(trie.search("some"));
    	 trie.insert("some");
    	 System.out.println(trie.search("some"));


    }
    
    // Inserts a word into the trie.
    public void insert(String word) {
        root.insert(word);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return root.search(word);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	return root.startsWith(prefix);   
    }
}
