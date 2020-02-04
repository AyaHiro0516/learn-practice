package org.ayahiro.practice.sword_to_offer.时间效率;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 最小的K个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        int length = input.length;
        if(k > length || k == 0){
            return res;
        }
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int i = 0; i < input.length; ++i) {
            if (maxheap.size() != k) {
                maxheap.offer(input[i]);
            } else if (maxheap.peek() > input[i]) {
                maxheap.poll();
                maxheap.offer(input[i]);
            }
        }
        for (Integer integer : maxheap) {
            res.add(integer);
        }
        return res;
    }
}
