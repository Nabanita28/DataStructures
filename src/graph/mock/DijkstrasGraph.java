package graph.mock;

import java.util.*;

public class DijkstrasGraph {

    public ArrayList<ArrayList<VertexNode>> adj;
    public int v;

    public DijkstrasGraph(int v) {
        this.v = v;
        this.adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, VertexNode v) {
        adj.get(u).add(v);
    }

    public void printGraph() {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("Adjacent at vertex : " + i);
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print("-> " + adj.get(i).get(j).vertex);
            }
            System.out.println();
        }
    }
}