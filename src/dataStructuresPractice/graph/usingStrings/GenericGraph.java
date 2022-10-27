package dataStructuresPractice.graph.usingStrings;

import java.util.*;

public class GenericGraph {

    Map<String, ArrayList<Vertex>> adjacencyList;

    public GenericGraph(){
        adjacencyList = new HashMap<>();
    }

    public static class Vertex{
        String city;
        int distance;

        public Vertex(String city, int distance){
            this.city = city;
            this.distance = distance;
        }
    }

    public Vertex addEdge(String source, String destination, int distance){
        Vertex edge = new Vertex(destination, distance);
       if(adjacencyList.containsKey(source)){
           adjacencyList.get(source).add(edge);
       } else{
           ArrayList<Vertex> value = new ArrayList<>();
           value.add(edge);
           adjacencyList.put(source, value);
       }
       return edge;
    }

    public String printGraph(){
        StringBuilder output = new StringBuilder();
        for(String city : adjacencyList.keySet()){
            output.append(city + ": ");
            for(Vertex currentVertex : adjacencyList.get(city)){
                output.append(currentVertex.city + " ");
            }
            output.append("\n");
        }
        return output.toString();
    }
}
