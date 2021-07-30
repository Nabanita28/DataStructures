package javaPratice;

public class Car extends Vehicle{
    private String carName;

    public Car(String carName){
        this.carName = carName;
    }

    public void displaySpeed(){
        System.out.println("speed = 120");
    }
}