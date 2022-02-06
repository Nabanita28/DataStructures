package dataStructuresPractice.graph.mustDo;

import dataStructuresPractice.graph.Graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSorting {
    static Graph graph = new Graph(3);
    public static void main(String[] args) {
        /*graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 2);*/
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        topologicalSort();
    }

    private static void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[graph.v];

          for (int i = 0; i< graph.v; i++){
            if (!visited[i])
            topologicalSortUtil(i, visited, stack);
        }
        System.out.println("Topological Sorting of the given dataStructuresPractice.graph : ");
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }

    }

    private static void topologicalSortUtil(int currentVertex, boolean[] visited, Stack<Integer> stack) {

        visited[currentVertex] = true;

        ArrayList<Integer> adjacentVertices = graph.adj.get(currentVertex);

        for (int j = 0; j<adjacentVertices.size(); j++){
           int nextVertex = adjacentVertices.get(j);
            if (!visited[nextVertex])
            topologicalSortUtil(nextVertex, visited, stack);
        }
        //push the current vertex to dataStructuresPractice.stack
        stack.push(currentVertex);

    }
}
