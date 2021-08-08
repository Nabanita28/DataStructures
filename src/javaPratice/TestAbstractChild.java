package javaPratice;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestAbstractChild extends TestAbstract{
    public void m3(){
        System.out.println("Hello from m1");
    }

    public void m2() {
        try{
            System.out.println("Hello from m2");
            throw new RuntimeException();
        } catch(Exception e){
            Logger.getLogger("TestAbstractChild.class").log(Level.INFO, "exception");
          //  throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        TestAbstractChild child = new TestAbstractChild();
        TestAbstract parent = child;
        TestAbstract classA = new TestAbstract();

        if(parent instanceof TestAbstractChild){
            ((TestAbstractChild)parent).m2();
        }



        }

}
