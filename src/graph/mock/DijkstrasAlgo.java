package graph.mock;

import java.util.*;

public class DijkstrasAlgo {
    // TODO - revisit
    public static void main(String[] args) {
        DijkstrasGraph graph = new DijkstrasGraph(5);

        graph.addEdge(0, new VertexNode(1, 9));
        graph.addEdge(0, new VertexNode(2, 6));
        graph.addEdge(0, new VertexNode(3, 5));
        graph.addEdge(0, new VertexNode(4, 3));
        graph.addEdge(2, new VertexNode(1, 2));
        graph.addEdge(2, new VertexNode(3, 4));
        graph.printGraph();
        dijkstrasShortestPath(graph, 0);
    }


    private static void dijkstrasShortestPath(DijkstrasGraph graph, int src) {

        Queue<VertexNode> priorityQueue = new PriorityQueue<>(graph.v, new VertexNode());
        Set<Integer> sptSet = new HashSet<>();
        int[] dist = new int[graph.v];
        for (int i = 0; i < dist.length; i++)
            dist[i] = Integer.MAX_VALUE;

        dist[src] = 0;
        priorityQueue.add(new VertexNode(src, 0));

        while (sptSet.size() != graph.v) {
            VertexNode currentNode = priorityQueue.remove();
            sptSet.add(currentNode.vertex);

            processNeighbours(graph, priorityQueue, sptSet, dist, currentNode);

        }

        System.out.println("The shorted path from node :");
        for (int i = 0; i < dist.length; i++)
            System.out.println(src + " to " + i + " is "
                    + dist[i]);
    }

    private static void processNeighbours(DijkstrasGraph graph, Queue<VertexNode> priorityQueue, Set<Integer> sptSet, int[] dist, VertexNode currentNode) {

        ArrayList<VertexNode> adjacentVertices = graph.adj.get(currentNode.vertex);

        for (int i = 0; i < adjacentVertices.size(); i++) {
            VertexNode nextNode = adjacentVertices.get(i);

            if (!sptSet.contains(nextNode.vertex)) {

                int edgeDistance = nextNode.cost;
                    int newDistance = dist[currentNode.vertex] + edgeDistance;

                if (dist[nextNode.vertex] > newDistance) {
                    dist[nextNode.vertex] = newDistance;

                    priorityQueue.add(new VertexNode(nextNode.vertex, dist[nextNode.vertex]));
                }
            }
        }
    }
}
