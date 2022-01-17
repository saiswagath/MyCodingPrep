package com.prac.arraysandstrings;

import java.util.Arrays;
import java.util.Comparator;

public class ReOrderLogFiles {

    public static String[] reorderLogFiles(String[] logs) {
        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] s1 = o1.split(" ",2);
                String[] s2 = o2.split(" ",2);
                boolean isDigit1 = Character.isDigit(s1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(s2[1].charAt(0));
                if(!isDigit1 && !isDigit2){
                    int comp = s1[1].compareTo(s2[1]);
                    if(comp != 0){
                        return comp;
                    }
                    return s1[0].compareTo(s2[0]);
                }
                return isDigit1 ? (isDigit2 ? 0 : 1) : -1   ;
            }
        };
        Arrays.sort(logs,myComp);
        return logs;
    }

    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        System.out.println(Arrays.toString(reorderLogFiles(logs)));
    }

}
