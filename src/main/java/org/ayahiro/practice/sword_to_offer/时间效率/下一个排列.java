package org.ayahiro.practice.sword_to_offer.时间效率;

import java.util.Arrays;

public class 下一个排列 {

        public static void nextPermutation(int[] nums) {
            if (nums.length <= 1) return;
            int length = nums.length;
            int i = length-2, j = length-1, k = length-1;
            //find A[i]<A[j]
            while (i >= 0 && nums[i] >= nums[j]) {
                i--;
                j--;
            }
            if (i >= 0) {
                //find A[i]<A[k]
                while (nums[i] >= nums[k]) {
                    k--;
                }
                //swap A[i] A[k]
                int temp=nums[i];
                nums[i]=nums[k];
                nums[k]=temp;
            }
            // reverse A[j:end]
            Arrays.sort(nums, j, length); //注意Array.sort    用的是[begin,end)
        }


    public static void main(String[] args) {
        int[] array={1,2,5,4,3,2};
        nextPermutation(array);
        System.out.println(Arrays.toString(array));
    }
}
