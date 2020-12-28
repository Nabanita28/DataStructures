package dataStructuresPractice.graph.mock;

import dataStructuresPractice.graph.Graph;

import java.util.ArrayList;
import java.util.Stack;

public class AlienLanguage {
    public static void main(String[] args) {
        String[] arr = new String[]{"baa", "abcd", "abca", "cab", "cad"};
        //String[] words = new String[]{"caa", "aaa", "aab"};
        findSortingOrder(arr);
    }


    private static void findSortingOrder(String[] arr) {
        Graph graph = new Graph(4);

        // Take the current two words and find the first mismatching character
        for (int i = 0; i < arr.length - 1; i++) {
            String word1 = arr[i];
            String word2 = arr[i + 1];

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                // If we find a mismatching character, then add an edge
                // from character of word1 to that of word2
                if (word1.charAt(j) != word2.charAt(j)) {
                    graph.addEdge(word1.charAt(j) - 'a', word2.charAt(j) - 'a');
                    break;
                }
            }
        }

        topologicalSort(graph);
    }

    private static void topologicalSort(Graph graph) {
        boolean[] visited = new boolean[graph.v];
        Stack<Integer> stack = new Stack<>();

        for (int k = 0; k < graph.v; k++) {
            if (!visited[k]) {
                topologicalSortUtil(k, visited, stack, graph);
            }
        }

        while (!stack.isEmpty())
            System.out.print((char) ('a' + stack.pop()) + " ");
    }

    private static void topologicalSortUtil(int k, boolean[] visited, Stack<Integer> stack, Graph graph) {

        visited[k] = true;

        ArrayList<Integer> adjacentVertices = graph.adj.get(k);
        for (int a = 0; a < adjacentVertices.size(); a++) {
            int nextVertex = adjacentVertices.get(a);

            if (!visited[nextVertex]) {
                topologicalSortUtil(nextVertex, visited, stack, graph);
            }
        }
        stack.push(k);
    }
}
