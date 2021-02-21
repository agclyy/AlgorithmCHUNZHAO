package com.agclyy.better.algorithm.week04;

public class MaximalSquare {


    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;
        int height = matrix.length;
        int width = matrix[0].length;
        int maxSide = 0;
        int[][] dp = new int[height + 1][width + 1];
        for (int i = 0; i <= height; i++) {
            for (int j = 0; j <= width; j++) {
                if(matrix[i][j] == '1'){
                    dp[i+1][j+1] = Math.min(Math.min(dp[i+1][j],dp[i][j+1]),dp[i][j])+1;
                    maxSide = Math.max(maxSide,dp[i+1][j+1]);
                }
            }
        }
        return maxSide*maxSide;
    }


    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        MaximalSquare maximalSquare = new MaximalSquare();
        maximalSquare.maximalSquare(matrix);
    }

}
