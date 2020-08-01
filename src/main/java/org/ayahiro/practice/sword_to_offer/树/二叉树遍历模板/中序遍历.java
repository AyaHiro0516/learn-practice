package org.ayahiro.practice.sword_to_offer.树.二叉树遍历模板;

import org.ayahiro.practice.sword_to_offer.树.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 中序遍历 {
    class Solution {
        public List<Integer> inOrderTraversal(TreeNode head) {
            List<Integer> list = new ArrayList<Integer>();
            Stack<TreeNode> stack = new Stack<TreeNode>();
            if (head != null) {
                while (head != null || !stack.empty()) {
                    if (head != null) {
                        stack.push(head);
                        head = head.left;
                    } else {
                        head = stack.pop();
                        //这里访问到“根” 对根进行操作
                        list.add(head.val);
                        head = head.right;
                    }
                }
            }
            return list;
        }
    }
}
