package practise;

import java.util.Date;

public class Person {

    int id;
    String name;
    Date date;

    public Person(int id, String name, Date date){
        this.id = id;
        this.name = name;
        this.date = date;
    }

    @Override
   public boolean equals(Object other){

        if (this == other)
            return true;

        if(other == null || this.getClass() != other.getClass())
            return false;

        Person guest = (Person)other;

       return (this.id == guest.id
                && this.name != null && this.name.equals(guest.name)
                && this.date != null  && this.date.equals(guest.date));

   }

   @Override
   public int hashCode(){
        int result = 0;

        result = 73*result + id;
        result = 73*result + (this.name != null ? this.name.hashCode() : 0);
        result = 73*result + (this.date != null ? this.date.hashCode() : 0);

        return result;
   }

   public int compareTo(Person other){
        return this.id - other.id;
   }
}
