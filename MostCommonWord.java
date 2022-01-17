package com.prac.arraysandstrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

    public static String mostCommonWord(String paragraph, String[] banned) {
        //Adding . to paragraph, helps us return the actual string incase banned set is empty
        paragraph += ".";
        String ans = "";
        int ansFreq = 0;
        Set<String> bannedSet = new HashSet<>();
        Map<String,Integer> wordCountMap = new HashMap<>();
        for(String word : banned){
            bannedSet.add(word);
        }
        StringBuilder sb = new StringBuilder();
        for(Character c : paragraph.toCharArray()){
            if(Character.isLetter(c)){
                 sb.append(Character.toLowerCase(c));
            }else if(sb.length() > 0){
                String word = sb.toString();
                if (!bannedSet.contains(word)){
                    wordCountMap.put(word, wordCountMap.getOrDefault(word,0) + 1);
                    if(wordCountMap.get(word) > ansFreq){
                        ansFreq = wordCountMap.get(word);
                        ans = word;
                    }
                }
                sb = new StringBuilder();
            }
        }
        return ans;
    }
    public static void main(String[] args) {

        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(mostCommonWord(paragraph,banned));
    }

}
