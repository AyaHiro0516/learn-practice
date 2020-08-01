package org.ayahiro.practice.sword_to_offer.查找和排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 相交区间合并 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length < 2) return intervals;
            List<int[]> list = new ArrayList<>();
            Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
            int[] lastInterval = null;
            for (int[] interval : intervals) {
                if (lastInterval == null || lastInterval[1] < interval[0]) {
                    lastInterval=interval;
                    list.add(interval);
                } else if (lastInterval[1] < interval[1]){
                    lastInterval[1]=interval[1];
                }
            }
            return list.toArray(new int[0][]);
        }
    }
}
