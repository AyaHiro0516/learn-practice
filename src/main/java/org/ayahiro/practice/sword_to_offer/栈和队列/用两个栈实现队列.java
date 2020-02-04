package org.ayahiro.practice.sword_to_offer.栈和队列;

import java.util.Stack;

public class 用两个栈实现队列 {
    public class Solution {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            stack1.add(node);
        }

        public int pop() {
            int node;
            if (stack2.empty()) {
                while (!stack1.empty()) {
                    node = stack1.pop();
                    stack2.add(node);
                }
            }
            return stack2.pop();
        }
    }
}
