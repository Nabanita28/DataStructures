package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PathsBetweenTwoVertices {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        System.out.println("Number of paths between 2 vertices : " + findPathsBetweenTwoVertices(g, 0, 3));
    }

    private static int findPathsBetweenTwoVertices(Graph g, int start, int destination) {
        //apply bfs
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        int count = 0;

        while (!queue.isEmpty()){
            int current = queue.remove();

            if(current == destination){
                count++;
            }
            ArrayList<Integer> adjacentVertices = g.adj.get(current);
            for (int i=0; i<adjacentVertices.size(); i++){
                int next = adjacentVertices.get(i);
                queue.add(next);
            }
        }
        return count;
    }


}
