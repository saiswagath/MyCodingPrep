package com.prac.graphs;

import java.util.*;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start]) {
                continue;
            }
            for (int end = start + 1; end <= s.length(); end++) {
                if (wordDictSet.contains(s.substring(start, end))) {
                    queue.add(end);
                    if (end == s.length()) {
                        return true;
                    }
                }
            }
            visited[start] = true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "catsandog";
        List<String> res = new ArrayList<>();
        res.add("cats");
        res.add("dog");
        res.add("sand");
        res.add("and");
        res.add("cat");
        System.out.println(wordBreak(s,res));
    }
}
