package graph.mock;

import graph.Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WaterSupplyProblem {
    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);

        int[] blocked = new int[]{0,1,1,0,0,0,0};
        System.out.println("Maximum cities water can be supplied are : " + findMaxCitiesWaterCanBeSupplied(graph, blocked));
    }

    private static int findMaxCitiesWaterCanBeSupplied(Graph graph, int[] blocked) {
        boolean[] visited = new boolean[graph.v];
        int count = 0;

        for (int i = 0 ; i< graph.v; i++){
            if (!visited[i] && blocked[i] == 0){
                bfs(1, visited, graph);
                count++;
            }
        }
        return count;
    }

    private static void bfs(int i, boolean[] visited, Graph graph) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;
        while(!queue.isEmpty()){
            int current = queue.remove();
            List<Integer> adjacentVertices = graph.adj.get(current);

            for(int j=0; j<adjacentVertices.size(); j++){
                int nextVertex = adjacentVertices.get(j);

                if (!visited[nextVertex]){
                    queue.add(nextVertex);
                }
            }
        }

    }


}
