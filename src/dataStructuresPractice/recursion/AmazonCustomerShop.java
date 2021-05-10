package dataStructuresPractice.recursion;

import java.util.ArrayList;
import java.util.List;

public class AmazonCustomerShop {
    static class Answer{
        int count = 0;
    }

    public static void main(String[] args) {
        int[][] prices = {
                {2, 3},
                {4},
                {2, 3},
                {1, 2}
        };
        System.out.println(getNumberOfOptions(prices, 10));
    }

    static int getNumberOfOptions(int[][] prices, int budget) {
        int count = 0;
        Answer answer = new Answer();
        recur(prices, 0, budget, answer);
        return answer.count;
    }


    private static void recur(int[][] prices, int index, int budget, Answer answer) {
        if (prices.length == 0 || index >= prices.length || budget <= 0) {
            return;
        }
            for (int price : prices[index]) {
                if (price <= budget) {
                    if (index == prices.length - 1 && price <= budget) {
                        answer.count = answer.count + 1;
                    } else {
                        recur(prices, index + 1, budget - price, answer);
                    }
                }
            }

    }
}
