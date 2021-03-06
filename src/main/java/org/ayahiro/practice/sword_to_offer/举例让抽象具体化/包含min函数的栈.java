package org.ayahiro.practice.sword_to_offer.举例让抽象具体化;

import java.util.Stack;

public class 包含min函数的栈 {
    public class Solution {

        Stack<Integer> s = new Stack<>();
        Stack<Integer> sMin = new Stack<>(); //使用辅助栈存储小的元素

        public void push(int node) {
            s.push(node);
            if (sMin.empty() || sMin.peek() > node) {
                sMin.push(node);
            }
        }

        public void pop() {
            int node = s.pop();
            if (node == sMin.peek()) {
                sMin.pop();
            }
        }

        public int top() {
            return s.peek();
        }

        public int min() {
            return sMin.peek();
        }
    }
}
