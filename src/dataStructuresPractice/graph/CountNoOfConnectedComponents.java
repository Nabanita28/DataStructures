package dataStructuresPractice.graph;

import java.util.ArrayList;

public class CountNoOfConnectedComponents {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(1, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        System.out.println(calculateConnectedComponents(graph));
    }

    private static int calculateConnectedComponents(Graph graph) {
        int connectedComponents = 0;
        boolean[] visited = new boolean[graph.vertices];
        for (int i = 0; i < graph.vertices; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited);
                connectedComponents++;
                System.out.println();
            }
        }
        return connectedComponents;
    }

    static void dfs(int startVertex, Graph graph, boolean[] visited) {

        visited[startVertex] = true;
        System.out.print( startVertex + " ");
        for (int currentVertex : graph.adjacencyList.get(startVertex)) {
            if(!visited[currentVertex])
            dfs(currentVertex, graph, visited);
        }

    }

    static public class Graph {
        int vertices;
        ArrayList<ArrayList<Integer>> adjacencyList;

        public Graph(int vertices) {
            this.vertices = vertices;
            this.adjacencyList = new ArrayList<>();
            for (int i = 0; i < vertices; i++) {
                this.adjacencyList.add(new ArrayList<>());
            }
        }

        public void addEdge(int source, int destination) {
            adjacencyList.get(source).add(destination);
            adjacencyList.get(destination).add(source);
        }
    }
}
