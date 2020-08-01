package org.ayahiro.practice.sword_to_offer.知识迁移能力;

import java.util.ArrayList;

public class 和为S的两个数字 {
    public class Solution {
        public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = 0; i < array.length; i++) {
                if (binarySearch(array, sum - array[i]) != -1) {
                    ans.add(array[i]);
                    ans.add(sum - array[i]);
                    break;
                }
            }
            return ans;
        }

        public int binarySearch(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }
}
