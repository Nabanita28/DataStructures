package dataStructuresPractice.strings;

import dataStructuresPractice.trie.Trie;

public class CheckWhetherRowsMatchWithColumns {
    public static void main(String[] args) {
        char[][] matrix = {{'M', 'C', 'P', 'M', 'C'},
                            {'X', 'S', 'O', 'C', 'C'},
                            {'V', 'O', 'V', 'P', 'I'},
                            {'M', 'X', 'I', 'M', 'Q'},
                            {'Q', 'A', 'T', 'C', 'T'}};

        System.out.println(checkWhetherRowsMatchWithColumns(matrix));
    }
    private static boolean checkWhetherRowsMatchWithColumns(char[][] matrix) {
        Trie trie = new Trie();
        trie.root = new Trie.TrieNode();
        String[] rowKeys = new String[matrix.length];
        String[] colKeys = new String[matrix.length];

        for(int i=0; i<matrix.length; i++){
            StringBuilder key = new StringBuilder();
            for(int j=0; j<matrix[0].length; j++){

                key.append(matrix[i][j]);
            }
            rowKeys[i] = key.toString();
        }

        for(int i=0; i<matrix.length; i++){
            StringBuilder key = new StringBuilder();
            for(int j=0; j<matrix[0].length; j++){

                key.append(matrix[j][i]);
            }
            colKeys[i] = key.toString();
        }

        for(int i=0; i<rowKeys.length; i++){
            trie.root.insert(rowKeys[i]);
        }

        for(int i=0; i<colKeys.length; i++){
            boolean result = trie.root.search(colKeys[i]);
            if (result){
                System.out.println("key : " + colKeys[i] + "Found at col - " + i);
                return true;
            }
        }
        return false;
    }

}
