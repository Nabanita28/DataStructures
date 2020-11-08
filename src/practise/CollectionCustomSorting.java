package practise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionCustomSorting {
    public static void main(String[] args) {

        Orders order1 = new Orders(1, "John", 1000);
        Orders order2 = new Orders(9, "Lieh", 5000);
        Orders order3 = new Orders(5, "Angela", 3000);

        List<Orders> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);

        System.out.println("Before sorting - " + orders);
        Collections.sort(orders);
        System.out.println("After natural sorting - " + orders);

        Collections.sort(orders, Collections.reverseOrder());
        System.out.println("Reverse sorting - " + orders);

        Collections.sort(orders, new Orders.OrderByAmount());
        System.out.println("Sort by Amount - " + orders);

        Collections.sort(orders, new Orders.OrderByCustomer());
        System.out.println("Sort by Customer name - " + orders);


    }


    static class Orders implements Comparable<Orders> {

        public int orderId;
        public String customer;
        public int amount;

        public Orders(int orderId, String customer, int amount) {
            this.orderId = orderId;
            this.customer = customer;
            this.amount = amount;
        }

        //Sorting on orderId is natural sorting for Order.
        @Override
        public int compareTo(Orders order) {
            if (this.orderId > order.orderId) {
                return 1;
            }
            if (this.orderId < order.orderId) {
                return -1;
            }
            return 0;
        }

        //Comparator implementation to Sort Order object based on Amount
        public static class OrderByAmount implements Comparator<Orders> {
            @Override
            public int compare(Orders o1, Orders o2) {
                if (o1.amount > o2.amount) {
                    return 1;
                }
                if (o1.amount < o2.amount) {
                    return -1;
                }
                return 0;

            }
        }


        public static class OrderByCustomer implements Comparator<Orders> {
            @Override
            public int compare(Orders o1, Orders o2) {
                return o1.customer.compareTo(o2.customer);
            }
        }

        @Override
        public String toString(){
            return String.valueOf("{" + orderId + " " + customer + " " + amount + "}");
        }
    }
}
