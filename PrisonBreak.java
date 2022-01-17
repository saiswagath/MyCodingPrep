package com.prac.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PrisonBreak {

    public static long prison(int n, int m, List<Integer> h, List<Integer> v) {
        boolean[] hc = new boolean[n+1];
        boolean[] vc = new boolean[m+1];

        for (Integer ih : h) {
            hc[ih] = true;
        }

        for (Integer ih : v) {
            vc[ih] = true;
        }
        int minValue = Integer.MIN_VALUE;
        int countY = Integer.MIN_VALUE;
        for (int i = 1, j = 0; i <= n; i++) {
            if (!hc[i]) j = 0;
            else minValue = Math.max(minValue, ++j);
        }

        for (int i = 1, j = 0; i <= m; i++) {
            if (!vc[i]) j = 0;
            else countY = Math.max(countY, ++j);
        }
        return (long)(countY+1) * (minValue+1);
    }

    public static void main(String[] args) {
        List<Integer> h = new ArrayList<>();
        h.add(4);
        List<Integer> v = new ArrayList<>();
        v.add(2);
        System.out.println(prison(6,6,h,v));

    }
}
