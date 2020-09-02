package graph;

import java.util.*;

public class Graph {

    private int v;
    private ArrayList<ArrayList<Integer>> adj;

    public Graph(int v) {
        this.v = v;
        this.adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    public void printGraph() {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("Adjacent at vertex : " + i);
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print("-> " + adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    public void bfs(int start) {

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        queue.add(start);
        set.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.println(current + " ");

            //get the connected vertices
            ArrayList<Integer> connectedNodesOfCurrent = adj.get(current);

            for (int i = 0; i < connectedNodesOfCurrent.size(); i++) {
                int next = connectedNodesOfCurrent.get(i);

                if (!set.contains(next)) {
                    queue.add(next);
                    set.add(next);
                }
            }
        }
    }
}