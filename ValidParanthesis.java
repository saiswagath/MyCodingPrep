package com.prac.arraysandstrings;

import java.util.Stack;

public class ValidParanthesis {

    public static boolean isValid(String s) {
        Stack<Character> bracStack = new Stack<Character>();
        for (char c : s.toCharArray()){
            if(c == '('){
                bracStack.push(')');
            }else if(c == '['){
                bracStack.push(']');
            }else if(c == '{'){
                bracStack.push('}');
            }else if(bracStack.isEmpty() || bracStack.pop() != c){
                return false;
            }
        }
        return bracStack.isEmpty();

    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }
}
