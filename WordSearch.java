package com.prac.backtracking;

public class WordSearch {
    public static boolean exist(char[][] board, String word) {

        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                if(board[i][j] == word.charAt(0) && foundWord(board,word,i,j,0)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean foundWord(char[][] board,String word,int i,int j,int index){

        if(index == word.length()){
            return true;
        }

        if(i<0 || j<0 || i>= board.length || j>= board[i].length || board[i][j] != word.charAt(index) || board[i][j] == '$'){
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '$';

        if(foundWord(board,word,i+1,j,index + 1) || foundWord(board,word,i,j + 1,index + 1) || foundWord(board,word,i-1,j,index + 1) || foundWord(board,word,i,j - 1,index + 1)){
            return true;
        }

        board[i][j] = temp;

        return false;
    }
}
