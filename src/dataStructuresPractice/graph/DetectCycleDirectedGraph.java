package dataStructuresPractice.graph;

import java.util.List;

public class DetectCycleDirectedGraph {
    static Graph graph = new Graph(4);
    public static void main(String[] args) {

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println(isCyclic(graph));
    }

    private static boolean isCyclic(Graph graph) {

        boolean[] visited = new boolean[graph.v];
        boolean[] recStack = new boolean[graph.v];
        boolean isCyclic = false;
        for (int i=0; i<graph.v; i++){
            if(!visited[i]){
                isCyclic = isCyclicUtil(i, visited, recStack);
                if(isCyclic){ // we already found a cycle with i vertex
                    return true;
                }
            }
        }
        return isCyclic;
    }

    private static boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {
// If a vertex is reached that is already in the recursion stack, then there is a cycle in the tree. 
        if (recStack[i])
            return true;

        visited[i] = true;
        recStack[i] = true;

        List<Integer> adjacentVertices = graph.adj.get(i);

        for (Integer vertex : adjacentVertices){
                if (isCyclicUtil(vertex, visited, recStack)){
                    return true;
                
            }
        }

        recStack[i] = false;
        return false;
    }
}
