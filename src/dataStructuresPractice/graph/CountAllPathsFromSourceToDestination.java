package dataStructuresPractice.graph;

import java.util.ArrayList;
import java.util.List;

public class CountAllPathsFromSourceToDestination {
    public static void main(String[] args) {
        int graph[][] = new int[][] { {1,2},{3},{3},{} };

        List<List<Integer>> result;
        result = allPathsSourceTarget(graph);
        result.stream().forEach(paths -> paths.stream().forEach(System.out::print));
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);
        dfsSearch(graph, 0, res, path);

        return res;
    }

    private static void dfsSearch(int[][] graph, int node, List<List<Integer>> res, List<Integer> path) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for (int nextNode : graph[node]) {
            path.add(nextNode);
                dfsSearch(graph, nextNode, res, path);
            path.remove(path.size() - 1);
        }
    }
}
