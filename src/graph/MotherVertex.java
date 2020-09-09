package graph;

import java.util.HashSet;
import java.util.Set;

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
                graph.DFS(graph, set, v);
                //-----DFS ENDS HERE------

                lastVisitedVertex = v;
            }
        }

        //Clearing set
        set.clear();

        // WE will do another DFS with the lastVisitedVertex as START Vertex,
        // IF it reaches all other vertices, then it is the mother vertex otherwise not
        graph.DFS(graph, set, lastVisitedVertex);


        for(int v=0; v<graph.v; v++) {
            if (!set.contains(v)) {
                return -1;
            }
        }

        return lastVisitedVertex;
    }

}
