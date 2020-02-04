package org.ayahiro.practice.sword_to_offer.树;

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
}
