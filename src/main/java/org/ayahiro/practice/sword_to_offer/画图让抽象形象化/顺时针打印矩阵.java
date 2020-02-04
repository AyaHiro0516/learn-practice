package org.ayahiro.practice.sword_to_offer.画图让抽象形象化;

import java.util.ArrayList;

public class 顺时针打印矩阵 {

    final static int max = Integer.MAX_VALUE;

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        int height = matrix.length, width = matrix[0].length;
        int up = 0, down = height - 1, left = 0, right = width - 1;
        while (up <= down && left <= right) {
            //从左往右
            for (int i = 0; i < width; i++) {
                if (matrix[up][i] != max) {
                    System.out.print(matrix[up][i] + " ");
                    matrix[up][i] = max;
                }
            }
            up++;

            //从上往下
            for (int i = 0; i < height; i++) {
                if (matrix[i][right] != max) {
                    System.out.print(matrix[i][right] + " ");
                    matrix[i][right] = max;
                }
            }
            right--;

            //从右往左
            for (int i = width - 1; i >= 0; i--) {
                if (matrix[down][i] != max) {
                    System.out.print(matrix[down][i] + " ");
                    matrix[down][i] = max;
                }
            }
            down--;

            //从下往上
            for (int i = height - 1; i >= 0; i--) {
                if (matrix[i][left] != max) {
                    System.out.print(matrix[i][left] + " ");
                    matrix[i][left] = max;
                }
            }
            left++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        printMatrix(array);
    }
}
