package org.ayahiro.practice.sword_to_offer.代码的完整性;

import java.util.ArrayList;

public class 调整数组顺序使奇数位于偶数前面 {
    public class Solution {
        public void reOrderArray(int[] array) {
            ArrayList<Integer> res = new ArrayList<>();
            for (int i = 0; i < array.length; i++) {
                if (array[i] % 2 == 1)
                    res.add(array[i]);
            }
            for (int i = 0; i < array.length; i++) {
                if (array[i] % 2 == 0)
                    res.add(array[i]);
            }
            int pos = 0;
            for (int x : res) {
                array[pos++] = x;
            }
        }
    }
}
