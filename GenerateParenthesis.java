package com.prac.backtracking;

import java.util.*;

public class GenerateParenthesis {

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        genParanthesis(res,"",0,0,n);
        return res;
    }

    public static void genParanthesis(List<String> res, String curr, int open, int close, int max){
        if(curr.length() == max*2){
            res.add(curr);
            return;
        }

        if(open<max){
            genParanthesis(res,curr + "(",open+1,close,max);
        }
        if(close<open){
            genParanthesis(res,curr + ")",open,close+1,max);
        }

    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
