package org.ayahiro.practice.sword_to_offer.知识迁移能力;

import java.util.ArrayList;
import java.util.HashMap;

public class 数组中只出现一次的数字 {
    public class Solution {
        public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
            HashMap<Integer, Integer> map = new HashMap();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < array.length; i++) {
                if (map.containsKey(array[i])) {
                    map.put(array[i], 2);
                } else {
                    map.put(array[i], 1);
                }
            }
            for (Integer key : map.keySet()) {
                if (map.get(key) == 1) {
                    list.add(key);
                }
            }
            num1[0] = list.get(0);
            num2[0] = list.get(1);
        }
    }
}
