package org.ayahiro.practice.sword_to_offer.时间效率;

public class 数组中出现次数超过一半的数字 {
    public class Solution {
        public int MoreThanHalfNum_Solution(int[] array) {
            int temp = Integer.MAX_VALUE, count = 1;
            for (int i = 0; i < array.length; ++i) {
                if (array[i] != temp) {
                    count--;
                    if (count == 0) {
                        temp = array[i];
                        count = 1;
                    }
                } else if (array[i] == temp) {
                    count++;
                }
            }
            int times = 0;
            for (int i = 0; i < array.length; ++i) {
                if (array[i] == temp) {
                    times++;
                }
            }
            return times > array.length / 2 ? temp : 0;
        }
    }
}
