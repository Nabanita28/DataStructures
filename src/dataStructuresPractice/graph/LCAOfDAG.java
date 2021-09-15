package dataStructuresPractice.graph;

import dataStructuresPractice.tree.LCA;

import java.util.ArrayList;

public class LCAOfDAG {
    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 4);
        graph.addEdge(1, 6);
        graph.addEdge(2, 4);
        graph.addEdge(2, 6);
        graph.addEdge(2, 3);
        graph.addEdge(6, 5);
        graph.addEdge(3, 6);
        graph.addEdge(6, 7);
        System.out.println("LCA of vertex 5 and 7 is " + graph.LCA(6, 7));
    }
    /*
    The time complexity of such an algorithm is O(V + E), where V is the number of vertices and E is the number of edges in DAG G.
    However, E = O(V^2) in DAG. During the algorithm, we sequentially do the DFS twice. After that, we built a subgraph, induced by the black nodes.
    Their amount might be at most V - 2, which is O(V). The number of edges in a new subgraph might also be a O(E).
    So, building an induced subgraph also takes O(V + E). Finding the nodes with zero out-degree will take  O(V) time.
    So, the total time complexity of our algorithm is O(V + E) + O(V + E) + O(V + E) + O(V) = O(V + E)
     */

    static int max = 10001;
    static int[][] path = new int[3][max];
    static boolean isNodeFound ;

    static public class Graph {
        static int vertices;
        static ArrayList<ArrayList<Integer>> adjacencyList;

        public Graph(int vertices) {
            this.vertices = vertices;
            this.adjacencyList = new ArrayList<>();
            for (int i = 0; i < vertices; i++) {
                this.adjacencyList.add(new ArrayList<>());
            }
        }

        public void addEdge(int source, int destination) {
            adjacencyList.get(source).add(destination);
        }

        static int LCA(int nodeA, int nodeB){
            if(nodeA == nodeB){
                return nodeA;
            }

            //set source
            path[1][0] = path[2][0] = 1;

            isNodeFound = false;
            dfs(1, 0, 1, 1, nodeA);

            isNodeFound = false;
            dfs(2, 0, 2, 1, nodeB);

            int i=0;
            while(i < max && path[1][i] == path[2][i]){
                i++;
            }

            return path[1][i-1];
        }

        static void dfs(int current, int prev, int pathNumber, int index, int node){

            for(int i=0; i<adjacencyList.get(current).size(); i++){
                int currentNode = adjacencyList.get(current).get(i);
                if(currentNode != prev && !isNodeFound){
                    path[pathNumber][index] = currentNode;
                    if(currentNode == node){
                        isNodeFound = true;
                        path[pathNumber][index+1] = -1;
                        return;
                    }
                }
                dfs(currentNode, current, pathNumber, index+1, node);
            }
        }
    }
}
