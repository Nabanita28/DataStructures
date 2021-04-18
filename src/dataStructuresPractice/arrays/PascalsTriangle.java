package dataStructuresPractice.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = printPascalsTriangle(5);
        triangle.stream().forEach(triangles -> triangle.stream().forEach(s-> System.out.print(s + " ")));
    }

    private static List<List<Integer>>  printPascalsTriangle(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if(numRows == 0)
            return triangle;

        //Base case
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        //Rest of the rows

        for(int line=1; line < numRows; line++){
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(line-1);
            //starting of a row is always 1
            row.add(1);

            for(int i=1; i<line; i++){
                row.add(prevRow.get(i-1) + prevRow.get(i));
            }

            row.add(1);
            triangle.add(row);

        }
        return triangle;

    }
}
