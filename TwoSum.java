package com.prac.arraysandstrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
         int[] res = new int[2];
        Map<Integer,Integer> indexMap = new HashMap<>();
        for(int i = 0; i < numbers.length; i++){
            if(indexMap.containsKey(target - numbers[i])){
                res[1] = i;
                res[0] = indexMap.get(target - numbers[i]);
                return res;
            }
            indexMap.put(numbers[i],i);
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] numbers = {2,7,11,15};
//        System.out.println(Arrays.toString(twoSum(numbers,9)));

        int[] numbers = {3,2,4};
        System.out.println(Arrays.toString(twoSum(numbers,6)));
    }
}
