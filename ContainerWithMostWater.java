package com.prac.arraysandstrings;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
       int max = Integer.MIN_VALUE;
       int i = 0;
       int j = height.length - 1;
       while (i <= j){
           int res =  Math.min(height[i],height[j]) * (j - i);
           max = Math.max(max, res);
           if(height[i] < height[j]){
               i++;
           }else{
               j--;
           }
       }
     return max;
    }

    public static void main(String[] args) {
        //int[] res = {1,8,6,2,5,4,8,3,7};
        int[] res = {1,2,1};
        System.out.println(maxArea(res));
    }
}
