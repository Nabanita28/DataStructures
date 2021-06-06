package dataStructuresPractice.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Audible {
    public static void main(String[] args) {
        List<String> related = Arrays.asList("1100", "0111", "0011", "0001");
        System.out.println(countGroups(related));
    }

    public static int countGroups(List<String> related) {
        // Write your code here

        boolean[] isVisited = new boolean[related.size()];
        int answer = 0;

        for(int i=0; i<related.size(); i++){
            if(!isVisited[i]){
                bfs(i, isVisited, related);
                answer++;
            }

        }
        return answer;
    }

    static  void bfs(int i, boolean[] isVisited, List<String> related){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        isVisited[i] = true;

        while(!queue.isEmpty()){
            int current = queue.remove();

            String row = related.get(current);
            char[] chars = row.toCharArray();

            for(int k=0; k<chars.length; k++){
                if(chars[k] == '1' && !isVisited[k]){
                    isVisited[k] = true;
                    queue.add(k);
                }
            }

        }

    }

}
