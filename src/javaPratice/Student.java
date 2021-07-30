package javaPratice;

import java.util.ArrayList;
import java.util.List;

public class Student {
    public static void main(String[] args) {
        Address address1 = new Address("Pune", "MH");
        Address address2 = new Address("Hyderabad", "TN");
        List<Address> addresses = new ArrayList<>();
        addresses.add(address1);
        addresses.add(address2);
        ImmutableStudent student = new ImmutableStudent("Rajeev", "1", addresses);

        System.out.print(student.getName() + " ");
        System.out.println(student.getRollno());
        student.getAddresses().stream().forEach(address -> System.out.print(address.getCity() + " "));
        student.getAddresses().stream().forEach(address -> System.out.print(address.getState() + " "));

        Address address3 = new Address("Agartala", "Tripura");
        addresses.add(address3);
        System.out.println();


        System.out.println("After adding second address");

        student.getAddresses().stream().forEach(address -> System.out.println(address.getCity() + " "));
        student.getAddresses().stream().forEach(address -> System.out.println(address.getState() + " "));
        Class c = student.getClass();
        System.out.println("class name : " + c.getName());
        System.out.print(student.toString());


    }
}
