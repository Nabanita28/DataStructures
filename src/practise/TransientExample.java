package practise;

import java.io.*;

public class TransientExample implements Serializable{
    public static void main(String[] args) {

        Book harryPotter = new Book("Harry Potter", "JK Rowling", 2 );

        try {
            FileOutputStream fos = new FileOutputStream("harryPotter.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(harryPotter);

            System.out.println("Book is successfully Serialized");

            FileInputStream fis = new FileInputStream("harryPotter.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Book oldHarryPotter = (Book) ois.readObject();

            System.out.println("Book is successfully created from Serialized data");

            System.out.println(oldHarryPotter);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Book{
        String name;
        String author;
        transient int edition;

        public Book(String name, String author, int edition){
            this.name = name;
            this.author = author;
            this.edition = edition;
        }

        @Override
        public String toString() {
            return "Book{" + ", title=" + name + ", author=" + author + ", edition=" + edition + '}';
        }

    }
}
