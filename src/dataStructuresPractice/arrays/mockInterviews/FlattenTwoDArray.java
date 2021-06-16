package dataStructuresPractice.arrays.mockInterviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FlattenTwoDArray {
    public static void main(String[] args) {
        List<List<Integer>> vector = new ArrayList<>();

        vector.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        vector.add(new ArrayList<>(Arrays.asList(1, 9)));
        vector.add(new ArrayList<>(Arrays.asList(4, 5, 6, 8)));

        Vector2D i = new Vector2D(vector);
        List<Integer> answer = new ArrayList<>();
        while (i.hasNext()){
            answer.add(i.next());
        }
        System.out.println(answer);
    }

   static class Vector2D implements   Iterator<Integer> {
        List<List<Integer>> vector;
        int x;
        int y;

        Vector2D(List<List<Integer>> vector){
            this.vector = vector;
            this.x = 0;
            this.y = 0;
        }

        @Override
        public boolean hasNext(){
            while(y < vector.size()){
                if(x < vector.get(y).size()){
                    return true;
                }else{
                    y++;
                    x = 0;
                }
            }
            return false;
        }

        @Override
        public Integer next(){
            return vector.get(y).get(x++);
        }

    }
}
