package org.ayahiro.practice.sword_to_offer.查找和排序;

/**
 * 二分查找的变种问题
 */
public class 旋转数组的最小数字 {
    public class Solution {
        public int minNumberInRotateArray(int[] array) {
            int low = 0;
            int high = array.length - 1;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (array[mid] > array[high]) {
                    low = mid + 1;
                } else if (array[mid] == array[high]) {
                    high = high - 1;
                } else {
                    high = mid;
                }
            }
            return array[low];
        }
    }
}
