package dataStructuresPractice.graph.usingStrings;

import java.lang.reflect.Array;
import java.util.*;

public class Graph {

    Map<String, ArrayList<Edge>> adjacents;

    public Graph(){
        adjacents = new HashMap<>();
    }

    public static class Edge{
        String source;
        String destination;
        int distance;

        public Edge(String source, String destination, int distance){
            this.source = source;
            this.destination = destination;
            this.distance = distance;
        }
    }

    public Edge addEdge(String source, String destination, int distance){
       Edge edge = new Edge(source, destination, distance);
       if(adjacents.containsKey(source)){
           adjacents.get(source).add(edge);
       } else{
           ArrayList<Edge> value = new ArrayList<>();
           value.add(edge);
           adjacents.put(source, value);
       }
       return edge;
    }

    public String printGraph(){
        StringBuilder output = new StringBuilder();
        for(String city : adjacents.keySet()){
            output.append(city + ": ");
            for(Edge edge : adjacents.get(city)){
                output.append(edge.destination + " ");
            }
            output.append("\n");
        }
        return output.toString();
    }
}
