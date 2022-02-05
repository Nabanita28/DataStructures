package javaPratice;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MorganStanleyDemo2 {
    public static void main(String[] args) {

    }

    public static List<Employee> sortListOfEmployees(List<Employee> employees, String property){

        if(property.equals("age")){
            Collections.sort(employees, new CompareAge());

        }
        return employees;
    }

    public static class CompareAge implements Comparator<Employee>{
        @Override
        public int compare(Employee e1, Employee e2){
            return e1.age.compareTo(e2.age);
        }
    }


    public  class Employee{
        String name;
        String age;
        String salary;

        public Employee(String name, String age, String salary){
            this.age = age;
            this.name = name;
            this.salary = salary;
        }
    }
}
