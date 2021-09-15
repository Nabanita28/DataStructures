package dataStructuresPractice.graph;

import java.util.ArrayList;
import java.util.Stack;

public class LongestPathInDirectedAcyclicGraph {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 5, 1);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);

        int source = 2;
        g.findLongestPath(source);

    }

    static class AdjacentNode{
        int vertex;
        int weight;
        public AdjacentNode(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
        public int getVertex(){
            return this.vertex;
        }
        public int getWeight(){
            return this.weight;
        }
    }
    static class Graph{

       static int numberOfVertices;
       static ArrayList<ArrayList<AdjacentNode>> adjacencyList;

        public Graph(int numberOfVertices){
            this.numberOfVertices = numberOfVertices;
            this.adjacencyList = new ArrayList<>();
            for(int i=0; i<numberOfVertices; i++){
                adjacencyList.add(new ArrayList<>());
            }
        }

        public void addEdge(int source, int destination, int weight){
            AdjacentNode node = new AdjacentNode(destination, weight);
            adjacencyList.get(source).add(node);
        }

        private static void findLongestPath(int source) {
            boolean[] visited = new boolean[numberOfVertices];
            int[] dist = new int[numberOfVertices];
            Stack<Integer> stack = new Stack<>();

            for(int i=0; i<numberOfVertices; i++){
                if(!visited[i])
                    topologicalSort(i, stack, visited);
            }

            for(int i=0; i<numberOfVertices; i++){
                dist[i] = Integer.MIN_VALUE;
            }
            dist[source] = 0;

            while(!stack.isEmpty()){
                int current = stack.pop();

                for(AdjacentNode node : adjacencyList.get(current)){
                    if(dist[node.getVertex()] < dist[current] + node.getWeight()){
                        dist[node.getVertex()] = dist[current] + node.getWeight();
                    }
                }
            }

            for(int i : dist){
                System.out.print(i + " ");
            }

        }

        static void topologicalSort(int vertex, Stack<Integer> stack, boolean[] visited){

            visited[vertex] = true;

            for(AdjacentNode currentNode : adjacencyList.get(vertex)){
                if(!visited[currentNode.getVertex()]){
                    topologicalSort(currentNode.getVertex(), stack, visited);
                }
                stack.push(currentNode.getVertex());
            }

        }
    }
}
