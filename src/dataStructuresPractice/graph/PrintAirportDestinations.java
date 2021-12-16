package dataStructuresPractice.graph;

import java.util.*;

public class PrintAirportDestinations {
    public static void main(String[] args) {
        Map<String, String> airports = new HashMap<>();
        airports.put("CCU", "DEL");
        airports.put("BLR", "BOM");
        airports.put("BOM", "MAA");
        airports.put("DEL", "BLR");
        airports.put("COK", "AMD");
        airports.put("AMD", "HYD");

        printDestinations(airports);
    }

    private static void printDestinations(Map<String, String> input) {


        Map<String, Integer> airport = new HashMap<>();

        for(Map.Entry entry : input.entrySet()) {
            String source = (String) entry.getKey();
            String destination = (String) entry.getValue();
            airport.put(source, 0);
            //calculate indegree
            airport.put(destination, airport.getOrDefault(destination, 0) + 1);
        }

        List<String> startPositions = new ArrayList<>();

        for(Map.Entry entry : airport.entrySet()){
            if ((int)entry.getValue() == 0){
                startPositions.add((String)entry.getKey());
            }
        }

        Set<String> isVisited = new HashSet<>();

        for(String vertex : startPositions){
            if(!isVisited.contains(vertex)){
                dfs(vertex, isVisited, input);
                System.out.println();
            }
        }
    }

    private static void dfs(String vertex, Set<String> isVisited, Map<String, String> input) {

        isVisited.add(vertex);
        System.out.print(vertex + " -> ");

        String adjVertex = input.get(vertex);

        if(Objects.nonNull(adjVertex) && !isVisited.contains(adjVertex)){
            dfs(adjVertex, isVisited, input);
        }

    }
}
