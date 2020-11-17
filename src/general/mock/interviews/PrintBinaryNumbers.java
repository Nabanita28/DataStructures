package general.mock.interviews;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintBinaryNumbers {

    public static void main(String[] args) {
        ArrayList<String> list = generate(5);
        list.stream().forEach(s -> System.out.print(s + " "));
    }


    static ArrayList<String> generate(long n)
    {

        ArrayList<String> list = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();

        queue.add("1");

        for(long i=1; i<=n; i++){

            String current = queue.poll();
            list.add(current);

            queue.add(current + "0");
            queue.add(current + "1");

        }

        return list;

    }
}