package org.ayahiro.practice.sword_to_offer.数组;

public class 数组中重复的数字 {
    public class Solution {
        // Parameters:
        //    numbers:     an array of integers
        //    length:      the length of array numbers
        //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
        //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
        //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
        // Return value:       true if the input is valid, and there are some duplications in the array number
        //                     otherwise false
        public boolean duplicate(int numbers[], int length, int[] duplication) {
            boolean[] k = new boolean[length];
            for (int i = 0; i < k.length; i++) {
                if (k[numbers[i]] == true) {
                    duplication[0] = numbers[i];
                    return true;
                }
                k[numbers[i]] = true;
            }
            return false;
        }

        //空间复杂度为O(1)的方案
        public boolean duplicate2(int numbers[], int length, int[] duplication) {
            int i = 0;
            while (i < length) {
                while (numbers[i] >= 0) {
                    int index = numbers[i];
                    if (numbers[index] >= 0) {
                        numbers[i] = numbers[index];
                        numbers[index] = -1;
                    } else {
                        duplication[0] = numbers[i];
                        return true;
                    }
                }
                i++;
            }
            return false;
        }
    }
}
