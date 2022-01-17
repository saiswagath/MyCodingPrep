package com.prac.graphs;

import java.util.*;

public class PacificAtlanticWater {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        //https://www.youtube.com/watch?v=krL3r7MY7Dc&ab_channel=AlgorithmsMadeEasy
        List<List<Integer>> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return res;

        int row = matrix.length, col = matrix[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        //DFS 00 01.. 40 41
        for(int i = 0; i < col; i++){
            dfs(matrix, 0, i, Integer.MIN_VALUE, pacific);
            dfs(matrix, row-1, i, Integer.MIN_VALUE, atlantic);
        }

        //DFS 00 10 20... 04 14 24..
        for(int i = 0; i < row; i++){
            dfs(matrix, i, 0, Integer.MIN_VALUE, pacific);
            dfs(matrix, i, col-1, Integer.MIN_VALUE, atlantic);
        }

        //preparing the result
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i,j));
                }
            }
        }

        return res;
    }

    public void dfs(int[][] matrix, int i, int j, int prev, boolean[][] ocean){
        if(i < 0 || i >= ocean.length || j < 0 || j >= ocean[0].length){
            return;
        }
        // From Inwards to outwards -> matrix[i][j] value should be higher than the
        // value nearest to the ocean..
        if(matrix[i][j] < prev || ocean[i][j]){
            return;
        }
        ocean[i][j] = true;
        dfs(matrix, i, j + 1, matrix[i][j], ocean);
        dfs(matrix, i + 1, j, matrix[i][j], ocean);
        dfs(matrix, i, j - 1, matrix[i][j], ocean);
        dfs(matrix, i - 1, j, matrix[i][j], ocean);
    }

    public static void main(String[] args) {
        PacificAtlanticWater pacificAtlanticWater = new PacificAtlanticWater();
        int[][] matrix = {{1,2,2,3,5},
                          {3,2,3,4,4},
                          {2,4,5,3,1},
                          {6,7,1,4,5},
                          {5,1,1,2,4}};
        List<List<Integer>> resp = pacificAtlanticWater.pacificAtlantic(matrix);
        for (List<Integer> r : resp){
            System.out.println(r);
        }
    }
}
