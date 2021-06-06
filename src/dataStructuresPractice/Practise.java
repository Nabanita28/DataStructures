package dataStructuresPractice;

import java.util.*;

public class Practise {
    public static void main(String[] args) {
        String s = "cat";

        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        System.out.println(new String(charArray));

        Student student1 = new Student(20, "John");
        Student student2 = new Student(22, "Ariel");
        Student student3 = new Student(24, "Conway");
        Student student4 = new Student(28, "Zebra");

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);



        Collections.sort(studentList, Student.ageComparator);
        System.out.println("Sorted by Age ");
        System.out.println(studentList);

        System.out.println("Sorted by name ");
        Collections.sort(studentList, Student.nameComparator);
        System.out.println(studentList);


    }

    static class Student{
        int age;
        String name;

        Student(int age, String name){
            this.age = age;
            this.name = name;
        }

        public int getAge(){
            return this.age;
        }

        public String getName(){
            return  this.name;
        }

        public static Comparator<Student> ageComparator = (s1, s2) -> {
            if (s1.getAge() > s2.getAge()){
                return 1;
            } else if(s2.getAge() > s1.getAge()){
                return -1;
            } else{
                return 0;
            }
        };

        /*public static Comparator<Student> nameComparator = new Comparator<Student>() {

            @Override
            public int compare(Student s1, Student s2){
                return s1.getName().compareTo(s2.getName());
            }
        };*/

        public static Comparator<Student> nameComparator = Comparator.comparing(Student::getName);

        @Override
        public String toString(){
            return "age = " + this.getAge() + " & name = " + this.getName();
        }

    }


}
