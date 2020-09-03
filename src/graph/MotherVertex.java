package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MotherVertex {
    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(4, 1);
        g.addEdge(6, 4);
        g.addEdge(5, 6);
        g.addEdge(5, 2);
        g.addEdge(6, 0);

        System.out.println("Mother vertex : " +  getMotherVertex(g));
    }

    private static int getMotherVertex(Graph graph){
        int lastVisitedVertex = -1;
        Set<Integer> set = new HashSet<>();


        for(int v=0; v<graph.v; v++){
            if(!set.contains(v)){

                //Will do DFS with start vertex as v
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
                //-----DFS ENDS HERE------

                lastVisitedVertex = v;
            }
        }

        //Clearing set
        set.clear();

        // WE will do another DFS with the lastVisitedVertex as START Vertex,
        // IF it reaches all other vertices, then it is the mother vertex otherwise not
        Stack<Integer> stack = new Stack<>();
        stack.push(lastVisitedVertex);
        set.add(lastVisitedVertex);

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

        for(int v=0; v<graph.v; v++) {
            if (!set.contains(v)) {
                return -1;
            }
        }

        return lastVisitedVertex;
    }

}
