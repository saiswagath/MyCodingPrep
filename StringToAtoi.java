package com.prac.arraysandstrings;

public class StringToAtoi {
    public static int convertAtoi(String str){
        if(str.isEmpty()){
            return 0;
        }
        double result = 0, pop = 0;
        int length = str.length(), index = 0;
        boolean sign = false;
        for(; index < length && str.charAt(index) == ' '; ++index);

        if(index == length || (str.charAt(index) != '-' && str.charAt(index) != '+' && !Character.isDigit(str.charAt(index)))){
            return 0;
        }

        if(str.charAt(index) == '-'){
            sign = true;
            ++index;
        }
        else if(str.charAt(index) == '+')
            ++index;

        for( ; index < length && Character.isDigit(str.charAt(index)) ; ++index)
        {
            pop = str.charAt(index) - '0';
            result = result * 10 + pop;
        }

        if(sign){
            result = -result;
        }

        if(result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        if(result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        return (int)result;
    }

    public static void main(String[] args) {
        System.out.println(convertAtoi("42"));
        System.out.println(convertAtoi("   -42"));
        System.out.println(convertAtoi("4193 with words"));
        System.out.println(convertAtoi("words and 987"));
        System.out.println(convertAtoi("-91283472332"));
    }
}
