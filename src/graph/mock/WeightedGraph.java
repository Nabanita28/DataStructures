package graph.mock;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {
    int vertices;
    List<List<Edge>> adjacencyList;

    public class Edge{
        int source, destination, weight;
        public Edge(int source, int destination, int weight){
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public WeightedGraph(int vertices){
        this.vertices = vertices;
        this.adjacencyList = new ArrayList<>();
        for (int i=0; i<vertices; i++){
            this.adjacencyList.add(new ArrayList<Edge>());
        }
    }

    public void addEdge(int source, int destination, int weight){
        Edge edge = new Edge(source, destination, weight);
        adjacencyList.get(source).add(edge);
    }

    public void printGraph(){
        System.out.println("Number of vertices = " + vertices);
        for (int i=0; i<vertices; i++){
            List<Edge> adjacentVertex = adjacencyList.get(i);
            for (int j=0; j<adjacentVertex.size(); j++){
                Edge edge = adjacentVertex.get(j);
                System.out.println("Source = " + edge.source + " Destination = " + edge.destination + " Weight = " + edge.weight);
            }
        }
    }

}
