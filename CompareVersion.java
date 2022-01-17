package com.prac.arraysandstrings;

public class CompareVersion {

    public static int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int maxLen = Math.max(s1.length,s2.length);
        //Integer.parseInt(0.001) -> 1
        for(int i = 0; i < maxLen; i++){
            Integer v1 = i < s1.length ? Integer.parseInt(s1[i]) : 0;
            Integer v2 = i < s2.length ? Integer.parseInt(s2[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0) {
                return compare;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("1.01","1.001"));
    }
}
