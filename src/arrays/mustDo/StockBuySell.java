package arrays.mustDo;

import java.util.ArrayList;
import java.util.List;

/*
The cost of a stock on each day is given in an array, find the max profit that you can make by buying and selling in those days.
For example, if the given array is {100, 180, 260, 310, 40, 535, 695}, the maximum profit can earned by buying on day 0, selling on day 3.
Again buy on day 4 and sell on day 6. If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.
*/

public class StockBuySell {
    public static void main(String[] args) {
        int[] price = new int[]{100, 180, 260, 310, 40, 535, 695};
        stockBuySell(price);
    }

    static class Stock{
        int buy;
        int sell;
    }

    private static void stockBuySell(int[] price) {
        int count = 0;
        int i = 0;
        int n = price.length;
        List<Stock> solution = new ArrayList<>();
        while(i < n-1){

            while((i < n-1) &&  price[i] >= price[i+1]) {
                i++;
            }
            if (i == n-1){
                System.out.println("Not Possible");
                break;
            }

            Stock stock = new Stock();
            stock.buy = i++;

            while((i<n) && price[i] >= price[i-1]) {
                i++;
            }

            stock.sell = i-1;
            solution.add(stock);
            count++;
        }

        for (int j=0; j<count; j++){
            System.out.print("Stock bought at : " + solution.get(j).buy + " and ");
            System.out.println("Stock sold at : " + solution.get(j).sell + " ");
        }
    }
}
