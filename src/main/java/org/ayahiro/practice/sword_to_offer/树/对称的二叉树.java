package org.ayahiro.practice.sword_to_offer.树;

/**
 * 经典递归  没什么好说的 注意镜像的条件 left.right, right.left不能漏
 */
public class 对称的二叉树 {
    public class Solution {

        boolean isSymmetrical(TreeNode pRoot) {
            if (pRoot == null) return true;
            return isSymmetrical(pRoot.left, pRoot.right);
        }

        private boolean isSymmetrical(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;
            if (left == null || right == null) return false;
            return left.val == right.val //为镜像的条件：左右节点值相等
                    && isSymmetrical(left.left, right.right) //2.对称的子树也是镜像
                    && isSymmetrical(left.right, right.left);
        }
    }
}
