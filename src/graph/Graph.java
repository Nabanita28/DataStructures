package graph;

import java.util.*;

public class Graph {

    public int v;
    public ArrayList<ArrayList<Integer>> adj;

    public Graph(int v) {
        this.v = v;
        this.adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
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
        System.out.println("BFS : ");
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

    public void DFS(int start) {

        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        System.out.println("DFS : ");
        stack.push(start);
        set.add(start);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            System.out.println(current + " ");

            ArrayList<Integer> adjacentCurrentNodes = adj.get(current);

            for (int i = 0; i < adjacentCurrentNodes.size(); i++) {
                int next = adjacentCurrentNodes.get(i);

                if (!set.contains(next)) {
                    set.add(next);
                    stack.push(next);
                }
            }
        }
    }

    public void DFS(Graph graph, Set<Integer> set, int v) {
        int start = v;
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        set.add(start);

        while (!stack.isEmpty()) {
            int current = stack.pop();

            ArrayList<Integer> adjacentCurrentNodes = graph.adj.get(current);

            for (int i = 0; i < adjacentCurrentNodes.size(); i++) {
                int next = adjacentCurrentNodes.get(i);

                if (!set.contains(next)) {
                    set.add(next);
                    stack.push(next);
                }
            }
        }
    }
}