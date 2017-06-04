package com.javarush.task.task39.task3912;

/* 
Максимальная площадь
*/

public class Solution {
    public static void main(String[] args) {

        int[][] matrix = new int[][] {
                {1,1,0,1,1,0,1},
                {1,1,1,1,1,1,0},
                {1,0,1,1,1,0,0},
                {0,0,1,1,1,0,0},
                {1,0,0,0,0,1,0},
                {1,1,0,0,1,1,1},
                {1,0,0,1,1,1,0}

        };

        System.out.println(maxSquare(matrix));

    }

    public static int maxSquare(int[][] matrix) {

        if(matrix == null || matrix.length == 0)
            return 0;

        int max = 0;

        for (int i = matrix.length - 1; i > 0; i--) {
            for (int j = matrix[i].length - 1; j > 0; j--) {
                if (matrix[i][j] != 0) {
                    matrix[i][j] = Math.min(matrix[i][j - 1], Math.min(matrix[i - 1][j], matrix[i - 1][j - 1])) + 1;
                    if (matrix[i][j] > max) {
                        max = matrix[i][j];
                    }
                }
            }
        }

        return max * max;
    }
}
