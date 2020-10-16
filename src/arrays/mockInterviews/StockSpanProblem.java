package arrays.mockInterviews;

import java.util.Arrays;

public class StockSpanProblem {
    public static void main(String[] args) {
        int[] stocks = new int[]{100, 80, 60, 70, 60, 75, 85};
        findStocksSpan(stocks);
    }

    private static void findStocksSpan(int[] stocks) {
        int length = stocks.length;
        int[] span = new int[length];
        span[0] = 1;

        for (int i = 1; i<length; i++){
            int counter = 1;
            while(counter <= i && stocks[i] >= stocks[i-counter]){
                counter = counter + span[i-counter];
            }
            span[i] = counter;
        }
        System.out.print("{ ");
        Arrays.stream(span).forEach(s-> System.out.print(s + " "));
        System.out.print("}");
    }
}
