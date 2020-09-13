package graph;

import java.util.*;

public class ShortestPathToReachOnePrimeToAnother {
    public static void main(String[] args) {
        System.out.print("Shortest Path To Reach One Prime To Another : " + findShortestPathBetweenOnePrimeToAnother(1033, 8179));
    }
    static List<Integer> primeNumbers = findPrime(9999);
    private static int findShortestPathBetweenOnePrimeToAnother(int n1, int n2) {

        Graph g = new Graph(primeNumbers.size());

        for(int i=0; i<primeNumbers.size()-1; i++){
            for (int j=i+1; j<primeNumbers.size() ; j++){
                if(compare(primeNumbers.get(i), primeNumbers.get(j))){
                    g.addEdge(i, j);
                    g.addEdge(j, i);
                }

            }
        }

        return bfs(g, primeNumbers.indexOf(n1), primeNumbers.indexOf(n2));

    }

    private static boolean compare(int i, int j) {

        char[] s = String.valueOf(i).toCharArray();
        char[] s1 = String.valueOf(j).toCharArray();
        int count = 0;

        if(s[0] != s1[0])
            count++;
        if(s[1] != s1[1])
            count++;
        if(s[2] != s1[2])
            count++;
        if(s[3] != s1[3])
            count++;

        if(count == 1)
            return true;
        else
            return false;
    }

    private static List<Integer> findPrime(int n) {

        Map<Integer, String> map = new HashMap();
        for (int i = 0; i < n; i++) {
            map.put(i, "UNMARKED");
        }

        //for every number starting from p=2
        for (int p = 2; p * p <= n; p++) {
            if ("UNMARKED".equalsIgnoreCase(map.get(p))) {
                //for every multiple of p; if p=2, start from 2*2=4, mark multiples of p
                for (int i = p * p; i <= n; i = i + p) {
                    map.put(i, "MARKED");
                }
            }
        }
        List<Integer> primeNumbers = new ArrayList<>();

            for (Map.Entry entry : map.entrySet()) {
                if ("UNMARKED".equalsIgnoreCase(entry.getValue().toString())){
                    int number = Integer.parseInt(entry.getKey().toString());
                   if(number >= 1000 && number <= 9999){
                       primeNumbers.add(number);
                   }
            }
        }
        return primeNumbers;
    }


    private static int bfs(Graph g, int start, int destination) {

        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> visited = new HashMap<>();

        queue.add(start);
        visited.put(start, new ArrayList<>(Arrays.asList(0, null)));

        while(!queue.isEmpty()){

            int current = queue.remove();

            if(current == destination){
                //Print path
                System.out.println();
                ArrayList<Integer> path = new ArrayList<>();
                ArrayList<Integer> tracer = visited.get(current);

                while (tracer.get(1) != null){
                    path.add(tracer.get(1));
                    tracer = visited.get(tracer.get(1));
                }

                for(int i= path.size()-1; i>= 0; i--){
                    System.out.print(primeNumbers.get(path.get(i))+ "->");
                }
                System.out.print(primeNumbers.get(destination));

                System.out.println();
                //Returning distance
                return visited.get(current).get(0);
            }


            ArrayList<Integer> adjacentVertices = g.adj.get(current);
            for (int i=0; i<adjacentVertices.size(); i++){
                int next = adjacentVertices.get(i);

                if (!visited.containsKey(next)){
                    queue.add(next);
                    int newDistance = visited.get(current).get(0) + 1;
                    visited.put(next, new ArrayList<>(Arrays.asList(newDistance, current)));
                }
            }
        }

        return -1;
    }

}
