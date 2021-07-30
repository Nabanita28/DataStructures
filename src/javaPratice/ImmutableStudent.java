package javaPratice;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableStudent {

    private final String rollno;
    private final String name;
    private final List<Address> addresses;

    public ImmutableStudent(String name, String rollno, List<Address> addresses){
        this.name = name;
        this.rollno = rollno;
        List<Address> tempAddress = new ArrayList<>();
        for(Address address : addresses){
            tempAddress.add(address);
        }
        this.addresses = tempAddress;
    }

    public String getName(){
        return this.name;
    }
    public String getRollno(){
        return this.rollno;
    }

    public List<Address> getAddresses(){
        List<Address> tempAddress = new ArrayList<>();
        for(Address address : addresses){
            tempAddress.add(address);
        }
        return tempAddress;
    }
}
