package arrays.mustDo;

import java.util.ArrayList;
import java.util.List;

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

            while((i < n-1) && price[i+1] <= price[i])
                i++;

            if (i == n-1) break;

            Stock stock = new Stock();
            stock.buy = i++;

            while((i<n) && price[i] >= price[i-1])
                i++;

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
