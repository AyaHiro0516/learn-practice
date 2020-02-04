package org.ayahiro.practice.sword_to_offer.数组;

public class 二维数组中的查找 {
    public class Solution {
        public boolean Find(int target, int[][] array) {
            int rowNum = array.length;
            int colNum = array[0].length;
            for (int i = rowNum - 1, j = 0; i >= 0 && j < colNum; ) {
                if (target == array[i][j])
                    return true;
                else if (target > array[i][j]) {
                    j++;
                } else {
                    i--;
                }
            }
            return false;
        }
    }
}
