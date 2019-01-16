/**
 * Java. level 2. Lesson 3. Example of homework
 * autor Rudenko Alexander
 * version date 07/01/2019
 *
 */
package lesson3.maps;

import java.util.*;

public class main {
    public static void main(String[] args) {
// 1 Часть задания ----------------------------------
        ArrayList<String> al = new ArrayList<>();
        al.add("Яблоко"); al.add("Банан"); al.add("Апельсин");  al.add("Мандарин");  al.add("Яблоко");  al.add("Груша");  al.add("Ананас");  al.add("Банан");  al.add("Киви");  al.add("Абрикос");
        System.out.println(al);
        System.out.println("Всего элементов = " + al.size());

        Set unic = new HashSet(al);
        System.out.println(unic);
        System.out.println("Всего уникальных элементов = "+ unic.size());

        System.out.println("Подсчет уникальных элементов:");
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
//------------------------------------------------------

        // 2 Часть задания ----------
        System.out.println("\n" + "Записная книга:");

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Саня", "863 233 3301");
        phoneBook.add("Вова", "863 212 1102");
        phoneBook.add("Леха", "863 243 1111");
        phoneBook.add("Жека", "863 240 2704");
        phoneBook.add("Витя", "863 248 2222");

        System.out.println(phoneBook);
        System.out.println(phoneBook.get("Вова"));

        // --------------------------
    }
}
