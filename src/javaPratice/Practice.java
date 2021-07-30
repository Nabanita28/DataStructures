package javaPratice;

public class Practice {

    Practice() { System.out.println("B-Constructor Called"); }

        {
            System.out.println("B-IIB block");
        }
    }

    // Child class
    class A extends Practice {
        A()
        {
            super();
            System.out.println("A-Constructor Called");
        }
        {
            System.out.println("A-IIB block");
        }

        // main function
        public static void main(String[] args)
        {
            A a = new A();

            final StringBuilder sb = new StringBuilder("Geeks");

            System.out.println(sb);

            // changing internal state of object
            // reference by final reference variable sb
            sb.append("ForGeeks");

            System.out.println(sb);
        }

}
