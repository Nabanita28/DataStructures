package dataStructuresPractice.graph.usingStrings;

import java.util.*;

public class ShortestPathBetween2Cities {
    public static void main(String[] args) {
        Graph googleMap = new Graph();

        googleMap.addEdge("Delhi", "Bombay", 10);
        googleMap.addEdge("Delhi", "Agartala", 10);
        googleMap.addEdge("Bombay", "Hyderabad", 10);
        googleMap.addEdge("Hyderabad", "Bangalore", 10);
        googleMap.addEdge("Bangalore", "Cochin", 10);
        googleMap.addEdge("Agartala", "Cochin", 10);
        googleMap.addEdge("Agartala", "Delhi", 10);
        googleMap.addEdge("Agartala", "Hyderabad", 10);
        googleMap.addEdge("Hyderabad", "Agartala", 10);
        googleMap.addEdge("Delhi", "Chandigarh", 10);
        googleMap.addEdge("Chandigarh", "Cochin", 10);
        googleMap.addEdge("Cochin", "Bangalore", 10);
        googleMap.addEdge("Bangalore", "Hyderabad", 10);

        System.out.println(googleMap.printGraph());
        System.out.println("BFS : ");
        bfs(googleMap, "Delhi");
        System.out.println();
        System.out.println("DFS : ");
        dfs(googleMap, "Delhi");
        System.out.println();
        System.out.println("ShortestDistance between Delhi & Hyderabad = " + findShortestDistanceBetweenTwoCities(googleMap, "Delhi", "Bangalore"));
    }

    static class Pair{
       String city;
       int distanceFromSource;

        public Pair(String city, int distanceFromSource){
            this.city = city;
            this.distanceFromSource = distanceFromSource;
        }
    }

    private static int findShortestDistanceBetweenTwoCities(Graph googleMap, String startCity, String endCity) {

        Queue<Pair> queue = new LinkedList<>();
        Set<String> isVisited = new HashSet<>();
        queue.add(new Pair(startCity, 0));
        isVisited.add(startCity);

        while(!queue.isEmpty()){
            Pair currentPair = queue.remove();
            if(currentPair.city.equals(endCity)){
                return currentPair.distanceFromSource;
            }
            List<Graph.Vertex> neighbours = googleMap.adjacencyList.get(currentPair.city);

            if(neighbours != null){
                for(Graph.Vertex nextVertex : neighbours){
                    if(!isVisited.contains(nextVertex.city)){
                        queue.add(new Pair(nextVertex.city, currentPair.distanceFromSource + 10));
                        isVisited.add(nextVertex.city);
                    }
                }
            }
        }
        return -1;
    }

    public static void bfs(Graph googleMap, String start){
        Queue<String> queue = new LinkedList<>();
        Set<String> isVisited = new HashSet<>();

        queue.add(start);
        isVisited.add(start);

        while(!queue.isEmpty()){
            String currentCity = queue.remove();

            System.out.print(currentCity + " ");
            List<Graph.Vertex> neighbours = googleMap.adjacencyList.get(currentCity);
            if(neighbours != null){
                for(Graph.Vertex curVertex : googleMap.adjacencyList.get(currentCity)){
                    if(!isVisited.contains(curVertex.city)){
                        queue.add(curVertex.city);
                        isVisited.add((curVertex.city));
                    }
                }
            }
        }
    }

    public static void dfs(Graph googleMap, String start){
        Stack<String> stack = new Stack<>();
        Set<String> isVisited = new HashSet<>();
        stack.push(start);
        isVisited.add(start);

        while(!stack.isEmpty()){
            String currentCity = stack.pop();

            System.out.print(currentCity + " ");

            List<Graph.Vertex> neighbours = googleMap.adjacencyList.get(currentCity);

            if(neighbours != null){
                for(Graph.Vertex curVertex : neighbours){
                    if(!isVisited.contains(curVertex.city)){
                        stack.push(curVertex.city);
                        isVisited.add(curVertex.city);
                    }
                }
            }
        }
    }
}
