package lesson3.maps;

import java.util.*;

public class main {
    public static void main(String[] args) {

        ArrayList<String> al = new ArrayList<>();
        al.add("Яблоко"); al.add("Банан"); al.add("Апельсин");  al.add("Мандарин");  al.add("Яблоко");  al.add("Груша");  al.add("Ананас");  al.add("Банан");  al.add("Киви");  al.add("Абрикос");
        System.out.println(al);
        System.out.println("Всего = " + al.size());

        Set unic = new HashSet(al);
        System.out.println(unic);
        System.out.println("Всего = "+ unic.size());

        HashMap<String, Integer> wordToCount = new HashMap<>();
        for (String word : al)
        {
            if (!wordToCount.containsKey(word))
            {
                wordToCount.put(word, 0);
            }
            wordToCount.put(word, wordToCount.get(word) + 1);
        }
        for (String word : wordToCount.keySet())
        {
            System.out.println(word + " " + wordToCount.get(word));
        }

    }
}
