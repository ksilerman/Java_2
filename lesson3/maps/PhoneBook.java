package lesson3.maps;

import java.util.*;

public class PhoneBook {
    private Map<String, String> pb;

    public PhoneBook() {
        pb = new TreeMap<>();
    }

    public void add(String name, String phone) {
        pb.put(name, phone);
    }

    List<String> get(String name) {
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, String> entry : pb.entrySet())
            if (name.equals(entry.getKey()))
                list.add(entry.getKey()+ " " + entry.getValue());

        return list;
    }

    @Override
    public String toString() {
        return pb.toString();
    }


}