package dataStructuresPractice.trie;

public class Trie {
//the memory requirements of Trie is O(ALPHABET_SIZE * key_length * N) where N is number of keys in Trie
    static  TrieNode root;

   static   class TrieNode{
        boolean isEndOfLine;
        TrieNode[] children;
       static private final int ALPHABET_SIZE = 26;

        public TrieNode(){
            isEndOfLine = false;
            children = new TrieNode[ALPHABET_SIZE];
            for(int i=0; i<ALPHABET_SIZE; i++){
                children[i] = null;
            }
        }


    public void insert(String key){
        int length = key.length();
        TrieNode current = root;

        for(int i = 0; i<length; i++){
            int index = key.charAt(i) - 'a';
            if(current.children[index] == null){
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }

        current.isEndOfLine = true;
    }

    public boolean search(String key){

        int length = key.length();
        TrieNode current = root;

        for(int level = 0; level<length; level++){
            int index = key.charAt(level) - 'a';
            if(current.children[index] == null){
                return false;
            }
            current = current.children[index];
        }
        return current.isEndOfLine;
    }
    }

    public static void main(String[] args) {
        root = new TrieNode();
        root.insert("nabanita");
        root.insert("rajeev");
        System.out.println(root.search("rajeev"));
    }

}
