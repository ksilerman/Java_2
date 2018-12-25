package lesson2.arrayExceprion;

import java.lang.reflect.Array;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {

        String[] weekDays = {"1", "2", "3" , "4"};
        Arr(weekDays);
    }
    //int i=Integer.parseInt(s);
    public static void Arr(String[] a){
        int[] pars = new int[a.length];
        int sum;
        for (int i = 0; i < a.length; i++) {
            pars[i] = Integer.parseInt(a[i]);
                System.out.println(pars[i]);
        }
        sum = pars[0]+pars[1]+pars[2]+pars[3];
        System.out.println(sum);
    }


}


