package dataStructuresPractice.recursion;

public class Recursion {

    static void fun(int x)
    {
        if(x > 0)
        {
            fun(--x);
            System.out.print(x + " ");
            fun(--x);
        }
    }

    public static void main (String[] args)
    {
        int a = 6;
        fun(a);
    }
} 