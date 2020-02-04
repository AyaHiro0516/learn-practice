package org.ayahiro.practice.sword_to_offer.树;

import java.util.Stack;

public class 二叉搜索树的第k个结点 {
    public class Solution {
        TreeNode KthNode(TreeNode root, int k) {
            if (root == null || k == 0)
                return null;
            Stack<TreeNode> stack = new Stack<TreeNode>();
            int count = 0;
            TreeNode node = root;
            //注意此处while的第一个条件：是用来判断右子树是否为空的
            //如果左子树和根都访问完以后，此时node等于右子树的根节点，
            //此时node并没有入栈，栈是空的，如果不判断node的话，会丢失右子树，
            //只有右子树（也就是node）和栈同时为空时，循环才结束
            while (node != null || !stack.isEmpty()) {
                if (node != null) {
                    stack.push(node);
                    node = node.left;
                } else {
                    node = stack.pop();
                    count++;
                    if (count == k)
                        return node;
                    node = node.right;
                }
            }
            return null;
        }
    }
}
