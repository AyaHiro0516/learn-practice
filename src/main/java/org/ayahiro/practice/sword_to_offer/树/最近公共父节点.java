package org.ayahiro.practice.sword_to_offer.树;

public class 最近公共父节点 {
    //二叉树的最近公共父节点 递归版
    class Solution1 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null && right != null) {
                return root;
            } else if (left == null) {
                return right;
            } else {
                return left;
            }
        }
    }

    //二叉树的最近公共父节点 非递归版
    class Solution11 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            return null;
        }
    }

    //平衡二叉树的最近公共父节点
    class Solution2 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (p.val == root.val) {
                return p;
            }
            if (q.val == root.val) {
                return q;
            }
            if (p.val > root.val && q.val > root.val) {
                return lowestCommonAncestor(root.right, p, q);
            } else if (p.val < root.val && q.val < root.val) {
                return lowestCommonAncestor(root.left, p, q);
            } else {
                return root;
            }
        }
    }
}
