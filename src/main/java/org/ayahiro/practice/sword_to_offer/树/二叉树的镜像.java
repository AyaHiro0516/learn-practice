package org.ayahiro.practice.sword_to_offer.树;

import java.util.Stack;

public class 二叉树的镜像 {
    public class Solution {
        public void Mirror(TreeNode root) {
            if (root != null) {
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
                Mirror(root.left);
                Mirror(root.right);
            }
        }
    }

    //非递归实现
    public class Solution2 {
        public void Mirror(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            if (root == null) return;
            stack.push(root);
            while (!stack.empty()) {
                TreeNode node = stack.pop();
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                //左右顺序不影响，只是需要遍历树，所以跟遍历顺序无关
                if (node.left != null) stack.push(node.left);
                if (node.right != null) stack.push(node.right);
            }
        }
    }
}
