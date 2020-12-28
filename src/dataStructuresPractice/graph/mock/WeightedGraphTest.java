package dataStructuresPractice.graph.mock;

public class WeightedGraphTest {
    public static void main(String[] args){
        WeightedGraph graph = new WeightedGraph(4);
        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 10);
        graph.addEdge(3, 4, 15);
        graph.printGraph();
    }
}
