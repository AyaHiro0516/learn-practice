package org.ayahiro.practice.sword_to_offer.栈和队列;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 滑动窗口的最大值 {
    public class Solution {
        public ArrayList<Integer> maxInWindows(int[] num, int size) {
            ArrayList<Integer> res = new ArrayList<>();
            if (num == null || size <= 0 || num.length < size)
                return res;
            //创建优先级队列，是队头存放队列中的最大值，方便记录
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>(size, (o1, o2) -> o2 - o1);
            int count = 0;            //入队列计数变量
            for (int i = 0; i < num.length - size + 1; i++) {
                while (count < size) {
                    queue.add(num[i + count]);
                    count++;
                }
                int maxNum = queue.peek();
                res.add(maxNum);
                //重置count和优先级队列
                count = 0;
                queue.clear();
            }
            return res;
        }
    }
}
