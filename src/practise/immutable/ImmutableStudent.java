package practise.immutable;

public final class ImmutableStudent {

    final int id;
    final String name;
    final Age age;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Age getAge() {
        Age cloneAge = new Age();
        cloneAge.setYear(age.getYear());
        cloneAge.setMonth(age.getMonth());
        cloneAge.setDay(age.getDay());
        return cloneAge;
    }

    public ImmutableStudent(int id, String name, Age age){
        this.id = id;
        this.name = name;
        Age cloneAge = new Age();
        cloneAge.setYear(age.getYear());
        cloneAge.setMonth(age.getMonth());
        cloneAge.setDay(age.getDay());
        this.age = cloneAge;
    }


    public static void main(String[] args) {
        Age age = new Age();
        age.setDay(1);
        age.setMonth(1);
        age.setYear(1991);
        ImmutableStudent immutableStudent = new ImmutableStudent(1, "Lieh", age);

        System.out.println(immutableStudent.getAge().getYear());


        immutableStudent.getAge().setYear(1992);
        System.out.println(immutableStudent.getAge().getYear());

    }
}
