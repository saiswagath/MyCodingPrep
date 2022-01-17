package com.prac.arraysandstrings;

public class TrappingRainWater {

    public static int trap(int[] height) {
        if(height.length==0)
            return 0;
        int sum = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        for(int i = 1; i < left.length;i++){
            left[i] = Math.max(left[i-1],height[i]);
        }
        right[right.length - 1] = height[height.length - 1];
        for(int i = right.length - 2; i >= 0; i--){
            right[i] = Math.max(right[i+1],height[i]);
        }
        for(int k = 0; k < height.length; k++){
            sum += Math.min(left[k],right[k]) - height[k];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] water = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(water));
    }
}
