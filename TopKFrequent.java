package com.prac.priorityqueue;

import java.util.*;

public class TopKFrequent {

    public static int[] topKFrequent(int[] nums, int k) {
        // O(1) time
        if (k == nums.length) {
            return nums;
        }

        Map<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(
                (n1, n2) -> count.get(n1) - count.get(n2));

        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;

    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int[] res = topKFrequent(nums,2);
        for(int k : res){
            System.out.println(k);
        }
    }
}
