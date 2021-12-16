package dataStructuresPractice.graph;

public class FindCenterOfStarGraph {
    public static void main(String[] args) {
        int[][] edges = {{1,2},{5,1},{1,3},{1,4}};
        System.out.println(findCenter(edges));
    }

    static public int findCenter(int[][] edges) {

        int length = edges.length;
        int[] countEdges = new int[length+2];

        for(int i=0; i<length; i++){
            countEdges[edges[i][0]]++;
            countEdges[edges[i][1]]++;
        }

        for(int i=0; i<countEdges.length; i++){
            if(countEdges[i] == length){
                return countEdges[i] ;
            }
        }
        return -1;
    }
}
