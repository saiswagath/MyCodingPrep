package com.prac.priorityqueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    public static int[] merge(int[][]lists){
        if(lists.length == 0){
            return null;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2) -> Integer.compare(i1[0], i2[0]));
        int count = 0;
        for(int[] arr : lists){
            pq.add(arr);
            count += arr.length;
        }
        int[] res = new int[count];
        count = 0;
        while (!pq.isEmpty()){
            int[] temp = pq.poll();
            res[count++] = temp[0];
            if(temp.length>1){
                pq.add(Arrays.copyOfRange(temp,1,temp.length));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3, 5, 7 },
                       {2, 4, 6, 8 },
                       {0, 9, 10, 11}};
        int[] res =  merge(arr);
        for(int r : res){
            System.out.println(r);
        }

    }

}
