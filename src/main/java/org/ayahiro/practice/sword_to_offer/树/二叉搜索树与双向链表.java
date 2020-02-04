package org.ayahiro.practice.sword_to_offer.树;

import java.util.Stack;

/**
 * 1.核心是中序遍历的非递归算法。
 * 2.修改当前遍历节点与前一遍历节点的指针指向。
 */
public class 二叉搜索树与双向链表 {
    public class Solution {
        public TreeNode Convert(TreeNode root) {
            if (root == null)
                return null;
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode p = root;
            TreeNode pre = null;// 用于保存中序遍历序列的上一节点
            boolean isFirst = true;
            while (p != null || !stack.isEmpty()) {
                while (p != null) {
                    stack.push(p);
                    p = p.left;
                }
                p = stack.pop();
                if (isFirst) {
                    root = p;// 将中序遍历序列中的第一个节点记为root
                    pre = root;
                    isFirst = false;
                } else {
                    pre.right = p;
                    p.left = pre;
                    pre = p;
                }
                p = p.right;
            }
            return root;
        }
    }
}
