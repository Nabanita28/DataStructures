package javaPratice;


import java.util.*;
import java.util.stream.Collectors;

class Base {
    public void Print()
    {
        System.out.println("Base");
    }
    public void m1(){
        System.out.println("Hello from m1");
    }
}

class Derived extends Base {
    public void Print()
    {
        System.out.println("Derived");
    }
    public void m2(){
        System.out.println("Hello from m2");
    }
}

class Main {
    public static void DoPrint(Base o)
    {
        o.Print();
    }
    public static void concat1(String s1)
    {
        s1 = s1 + " Ranjan";
        System.out.println("s1 from method concat1 = " + s1);

    }
    public static void main(String[] args)
    {
        Base x = new Base();
        Base y = new Derived();
        Derived z = new Derived();
        DoPrint(x);
        DoPrint(y);
        DoPrint(z);
        String s1 = "Rajeev";
        concat1(s1);
        System.out.println("s1 = " + s1);

        ((Derived)y).m2();
        z.m2();

        System.out.println(Double.MIN_VALUE);

        char[] chars = new char[] {'\u0097'}; String str = new String(chars); byte[] bytes = str.getBytes(); System.out.println(Arrays.toString(bytes));

        System.out.println("Stream with terminal operation");
        System.out.println(
        Arrays.stream(new int[] { 1, 2, 3 }).map(i -> {
            System.out.println("doubling " + i);
            return i * 2;
        }).sum());
        Map<String, List<String>> people = new HashMap<>();
        people.put("John", Arrays.asList("555-1123", "555-3389"));
        people.put("Mary", Arrays.asList("555-2243", "555-5264"));
        people.put("Steve", Arrays.asList("555-6654", "555-3242"));

        List<String> phones = people.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(phones);
    }
}