package com.prac.backtracking;

public class HelloWorld{

    public static void main(String []args){
        int[] nums = {1,2,3,4,5,6,7,8};
        System.out.println(binarySearch(nums, 0 , nums.length - 1, 2));
    }

    public static int binarySearch(int[] nums, int lo, int high, int target){

        while(lo <= high){
            int mid = lo + (high - lo) / 2;

            if(target == nums[mid]){
                return mid;
            }else if(target < nums[mid]){
                high = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return -1;

    }
}