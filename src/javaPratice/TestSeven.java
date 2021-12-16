package javaPratice;

public class TestSeven extends Thread{
    private static int x = 1;

    public static void doThings(){
        int curr = x;
        curr++;
        x = curr;
        System.out.println(x);
    }

    public void run(){
        doThings();
    }

    public static void main(String[] args) {
        Thread t = new Thread(new TestSeven());
        t.start();
    }
}
