package javaPratice.multithreading;

public class TestAddition {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThread());
        Thread thread2 = new Thread(new Test());
        thread1.start();
        thread2.start();

        System.out.println("DRM - ");
    }

    public static class MyThread implements Runnable{
        public void run(){
            obj.notify();
        }
    }
    public static Test obj =  new Test();
    public static class Test implements Runnable{

        private int data;
        public Test(){
            data = 10;
        }

        public void run(){

         synchronized (obj){
             try {
                 obj.wait();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
            obj.data += 20;
            System.out.println(obj.data);
        }
    }
}

