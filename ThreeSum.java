package com.prac.arraysandstrings;

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return new ArrayList<>();
        }
       List<List<Integer>> res = new ArrayList<>();
       Set<String> uniqueTripSet = new HashSet<>();
       Arrays.sort(nums);
       for (int i = 0; i < nums.length - 2; i++){
            String curr = "";
            int j = i + 1;
           int k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    curr = nums[i] + "_" + nums[j] + "_" + nums[k];
                    if (!uniqueTripSet.contains(curr)){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        res.add(temp);
                        uniqueTripSet.add(curr);
                    }
                    j++;
                    k--;
                }else if(sum<0){
                    j++;
                }else if(sum > 0){
                    k--;
                }
            }
       }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
