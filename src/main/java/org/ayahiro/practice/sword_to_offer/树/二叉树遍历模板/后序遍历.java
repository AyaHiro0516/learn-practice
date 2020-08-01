package org.ayahiro.practice.sword_to_offer.树.二叉树遍历模板;

import org.ayahiro.practice.sword_to_offer.树.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 后序遍历 {
    class Solution {
        public List<Integer> postOrderTraversal(TreeNode head) {
            if (head == null) {
                return null;
            }
            List<Integer> list = new ArrayList<Integer>();
            Stack<TreeNode> stack1 = new Stack<TreeNode>();
            Stack<TreeNode> stack2 = new Stack<TreeNode>();
            stack1.push(head);
            while (!stack1.empty()) {
                head = stack1.pop();
                stack2.push(head);
                if (head.left != null) {
                    stack1.push(head.left);
                }
                if (head.right != null) {
                    stack1.push(head.right);
                }
            }
            while (!stack2.empty()) {
                list.add(stack2.pop().val);
            }
            return list;
        }
    }
}
