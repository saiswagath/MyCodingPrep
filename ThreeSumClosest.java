package com.prac.arraysandstrings;

import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] num, int target) {
       int result = num[0] + num[1] + num[num.length - 1];
        Arrays.sort(num);
       for (int i = 0 ; i < num.length - 2; i++){
           int j = i +1, k = num.length - 1;
           while (j < k){
               int sum = num[i] + num[j] + num[k];
               if(sum < target){
                   j++;
               }else {
                   k--;
               }
               if(Math.abs(sum - target) < Math.abs(result - target)){
                   result = sum;
               }
           }
       }
       return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4},1));
    }
}
