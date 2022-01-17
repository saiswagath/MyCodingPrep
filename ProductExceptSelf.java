package com.prac.arraysandstrings;

import java.util.Arrays;

public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];
        L[0] = 1;
        for(int i = 1; i < L.length; i++){
            L[i] = nums[i - 1] * L[i - 1];
        }
        R[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >=0; i--){
            R[i] = nums[i + 1] * R[i + 1];
        }

        for (int i = 0; i < nums.length; i++){
            nums[i] = L[i] * R[i];
        }

        return nums;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
    }
}
