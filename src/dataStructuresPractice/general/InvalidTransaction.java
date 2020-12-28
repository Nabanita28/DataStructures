package dataStructuresPractice.general;

import java.util.ArrayList;
import java.util.List;

public class InvalidTransaction {
    public static void main(String[] args) {
        String[] transactions = {"alice,20,800,mtv","alice,50,100,beijing"};
        invalidTransactions(transactions);
    }


        public static List<String> invalidTransactions(String[] transactions) {

            List<String> list = new ArrayList<>();

            for(int i=0; i<transactions.length-1; i++){

                String[] first = transactions[i].split(",");

                String[] second = transactions[i+1].split(",");

                if( Integer.parseInt(first[2]) > 1000  || ( (Integer.parseInt(first[1]) + 60) > (Integer.parseInt(second[1])) && first[0].equals(second[0]) && first[3].equals(second[3]))){
                    list.add(transactions[i]);
                } else{
                    list.add(transactions[i+1]);
                }
            }
            System.out.println(list);
            return list;
        }
    }