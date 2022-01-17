package com.prac.sorting;

public class MergeSort {
    private static void mergeArray(Comparable[] left, Comparable[] right, Comparable[] arr) {
        int l1 = left.length;
        int r1 = right.length;
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < l1 && j < r1) {
            if (left[i].compareTo(right[j]) <= 0){
                arr[k++] = left[i++];
            }
            else {
                arr[k++] = right[j++];
            }
        }
        while (i < l1) {
            arr[k++] = left[i++];
        }
        while (j < r1){
            arr[k++] = right[j++];
        }
    }

    private static void sortArray(Comparable[] arr, int lo, int high) {
        int n = arr.length;
        if (n < 2){
            return;
        }
        int mid = lo + (high - lo) / 2;
        Comparable[] left = new Comparable[mid];
        Comparable[] right = new Comparable[n - mid];
        for (int i = 0; i < mid; i++){
            left[i] = arr[i];
        }
        for (int j = mid; j < n; j++){
            right[j - mid] = arr[j];
        }
        sortArray(left, 0, left.length);
        sortArray(right, 0, right.length);
        mergeArray(left, right, arr);

    }

    private static void showArray(Comparable[] arr) {
        for (Comparable merge : arr) System.out.println(merge);
    }

    public static void main(String args[]) {
        Comparable[] arr = {7, 10, 5, 3, 8, 4, 2, 9, 6};
        sortArray(arr, 0, arr.length);
        showArray(arr);
    }
}
