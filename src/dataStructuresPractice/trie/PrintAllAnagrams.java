package dataStructuresPractice.trie;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PrintAllAnagrams {
    public static void main(String[] args) {
        String[] wordsArr = new String[]{"cat", "dog", "tac", "god", "act", "gdo"};

        printAnagrams(wordsArr);
    }

    private static final int ALPHABET_SIZE = 26;

    //Trie Structure
    static class TrieNode{
        boolean isEndOfWord;
        List<Integer> head;
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        public TrieNode(){
            isEndOfWord = false;
            head = new LinkedList<>();
            for(int i=0; i<ALPHABET_SIZE; i++){
                children[i] = null;
            }
        }
    }

    // insert key into Trie data structure
    static TrieNode insert(TrieNode root, String key, int originalIndex){
        TrieNode node = root;
        for(int i=0; i<key.length(); i++){

            int index = key.charAt(i) - 'a';
            if(node.children[index] == null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }

        node.isEndOfWord = true;
        node.head.add(originalIndex);
        return root;
    }

    //in this method, we insert the keys into Trie and print them all the anagrams together
    static TrieNode printAnagrams(String[] wordsArr){
        int len = wordsArr.length;

        TrieNode root = new TrieNode();

        for (int i=0; i<len; i++){
            char[] charArr = wordsArr[i].toCharArray();
            Arrays.sort(charArr);
            root = insert(root, new String(charArr), i);
        }

        printAnagramsUtil(root, wordsArr);
        return root;
    }

    private static void printAnagramsUtil(TrieNode root, String[] wordsArr) {

        if (root == null){
            return ;
        }

        if (root.isEndOfWord){
            for (int k : root.head){
                System.out.println(wordsArr[k]);
            }
        }

        for(int i=0; i<ALPHABET_SIZE; i++){
            printAnagramsUtil(root.children[i], wordsArr);
        }
    }


}
