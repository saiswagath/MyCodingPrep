package com.prac.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] nums, int left, int right) {
        if(left >= right){
            return;
        }
        // In case of bad pivot Left or right O(N^2)
        //move all the elements left of pivot and elements greater than pivot to right
        //avg case choosing midpoint O(NLOGN)
        int pivot = nums[(left + right) / 2];
        int index = partition(nums, left, right,pivot);
        quickSort(nums, left, index - 1);
        quickSort(nums, index, right);
    }

    public static void quickSort(int[] nums){
        quickSort(nums, 0, nums.length - 1);
    }

    private static int partition(int[] nums, int left, int right, int pivot) {
        while (left <= right) {
            while (nums[left] < pivot) {
                left++;
            }
            while (nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 3, 2, 1};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
