package javaPratice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return 13;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static void main(String[] args) {
        Person p1 = new Person("firstName1", "secondName1");
        Person p2 = new Person("firstName2", "secondName2");
        Map<Person, String> map = new HashMap<>();
        map.put(p1, "This is first person object");
        map.put(p2, "This is second person object");
        map.put(new Person("firstName1", "secondName1"), "Overriding first person");

        System.out.println(map.size());
        System.out.println(map.get(new Person("firstName1", "secondName1")));
    }
}
