package javaPratice;

public class SystemGCTest {
    static SystemGCTest t;
    static int count = 0;

    public static void main(String[] args) throws InterruptedException{
        SystemGCTest t1 = new SystemGCTest();
        t1 = null;
        System.gc();
        Thread.sleep(1000);
        t = null;
        System.gc();
        Thread.sleep(1000);
        SystemGCTest t2 = new SystemGCTest();
        t2 = null;
        System.gc();
        Thread.sleep(1000);

        SystemGCTest t4 = new SystemGCTest();
        t4 = null;
        System.gc();
        Thread.sleep(1000);

        t = null;
        System.gc();
        Thread.sleep(1000);
        System.out.println("finalize method called "+ count +" times");
    }

    @Override
    protected void finalize(){
        count++;
        t = this;
    }
}
