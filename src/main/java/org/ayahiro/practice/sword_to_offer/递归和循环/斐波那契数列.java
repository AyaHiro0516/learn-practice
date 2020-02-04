package org.ayahiro.practice.sword_to_offer.递归和循环;

public class 斐波那契数列 {
    public class Solution {
        public int Fibonacci(int n) {
            int f = 0, g = 1;
            for (int i = 0; i < n; i++) {
                g += f;
                f = g - f;
            }
            return f;
        }
    }
}
