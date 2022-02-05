    package javaPratice.polymorphism;

    class Animal {
        static void printValue(Animal a){
            System.out.println("ONE");
        }
    }
    class Dog extends Animal{
        private void printValue(Dog b){
            System.out.println("TWO");
        }
    }
    class Labrador extends Dog{
        private void printValue(Labrador c){
            System.out.println("THREE");
        }
    }
    public class MainClass{

        public static void main(String[] args) {

            Labrador c = new Labrador();
            c.printValue(c);
        }
    }