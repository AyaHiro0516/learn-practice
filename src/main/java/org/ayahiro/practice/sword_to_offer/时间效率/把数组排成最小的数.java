package org.ayahiro.practice.sword_to_offer.时间效率;

import java.util.ArrayList;
import java.util.Collections;

public class 把数组排成最小的数 {
    public class Solution {
        public String PrintMinNumber(int[] numbers) {
            int n;
            String s = "";
            ArrayList<Integer> list = new ArrayList<Integer>();
            n = numbers.length;
            for (int i = 0; i < n; i++) {
                list.add(numbers[i]);

            }
            Collections.sort(list, (str1, str2) -> {
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;
                return s1.compareTo(s2);
            });
            for (int j : list) {
                s += j;
            }
            return s;
        }
    }
}
