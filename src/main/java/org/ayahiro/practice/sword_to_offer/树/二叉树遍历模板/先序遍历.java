package org.ayahiro.practice.sword_to_offer.树.二叉树遍历模板;

import org.ayahiro.practice.sword_to_offer.树.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 先序遍历 {
    class Solution {
        public List<Integer> preOrderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<Integer>();
            Stack<TreeNode> stack = new Stack<TreeNode>();
            if (root != null) {
                stack.push(root);
                while (!stack.empty()) {
                    TreeNode tr = stack.pop();
                    list.add(tr.val);
                    if (tr.right != null) {
                        stack.push(tr.right);
                    }
                    if (tr.left != null) {
                        stack.push(tr.left);
                    }
                }
            }
            return list;
        }
    }
}
