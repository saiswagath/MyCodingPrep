package com.prac.arraysandstrings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingChars {

    public static int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                // as sliding window we move forward
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
