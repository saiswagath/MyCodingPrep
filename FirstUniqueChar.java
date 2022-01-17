package com.prac.arraysandstrings;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueChar {
    public static int firstUniqChar(String s) {
        int min = Integer.MAX_VALUE;
        Map<Character,Integer> countMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(!countMap.containsKey(s.charAt(i))){
                countMap.put(s.charAt(i),i);
            }else{
                countMap.put(s.charAt(i), -1);
            }
        }

        for(char k : countMap.keySet()){
            if(countMap.get(k) > -1 && countMap.get(k) < min){
                min = countMap.get(k);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }
}
