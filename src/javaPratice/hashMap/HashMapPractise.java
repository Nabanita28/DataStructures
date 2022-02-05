package javaPratice.hashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapPractise {
    public static void main(String[] args) {
        Map<Color, String> map = new HashMap();
        map.put(new Color("Red"), "Red");
        map.put(new Color("Blue"), "Blue");
        map.put(new Color("Green"), "Green");
        System.out.println("Size is " + map.size());
        System.out.println(map.get(new Color("Blue")));

    }

    static class Color{
        String name;

        Color(String name){
            this.name = name;
        }
        /*@Override
        public boolean equals(Object obj){
            return true;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }*/
    }
}
