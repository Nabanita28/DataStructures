package dataStructuresPractice.graph.usingStrings;

import java.util.*;

public class ShortestPathBetween2Cities {
    public static void main(String[] args) {
        Graph googleMap = new Graph();

        Graph.Edge start = googleMap.addEdge("Delhi", "Bombay", 10);
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
        Graph.Edge end = googleMap.addEdge("Bangalore", "Hyderabad", 10);

        System.out.println(googleMap.printGraph());
        System.out.println("BFS : ");
        bfs(googleMap, "Delhi");
        System.out.println();
        System.out.println("DFS : ");
        dfs(googleMap, "Delhi");
        System.out.println();
        System.out.println("ShortestDistance between Delhi & Hyderabad = " + findShortestDistanceBetweenTwoCities(googleMap, "Delhi", "Hyderabad"));
    }

    private static int findShortestDistanceBetweenTwoCities(Graph googleMap, String start, String end) {

        Queue<String> queue = new LinkedList<>();
        Set<String> isVisited = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        map.put(start, 0);
        queue.add(start);
        isVisited.add(start);

        while(!queue.isEmpty()){
            String currentCity = queue.remove();
            if(currentCity.equals(end)){
                return map.get(currentCity);
            }
            List<Graph.Edge> neighbours = googleMap.adjacents.get(currentCity);

            if(neighbours != null){
                for(Graph.Edge edge : neighbours){
                    if(!isVisited.contains(edge.destination)){
                        map.put(edge.destination, map.get(currentCity)+10);
                        queue.add(edge.destination);
                        isVisited.add(edge.destination);
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
            List<Graph.Edge> neighbours = googleMap.adjacents.get(currentCity);
            if(neighbours != null){
                for(Graph.Edge edge : googleMap.adjacents.get(currentCity)){
                    if(!isVisited.contains(edge.destination)){
                        queue.add(edge.destination);
                        isVisited.add((edge.destination));
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

            List<Graph.Edge> neighbours = googleMap.adjacents.get(currentCity);

            if(neighbours != null){
                for(Graph.Edge edge : neighbours){
                    if(!isVisited.contains(edge.destination)){
                        stack.push(edge.destination);
                        isVisited.add(edge.destination);
                    }
                }
            }
        }
    }
}
