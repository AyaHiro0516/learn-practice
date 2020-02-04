package org.ayahiro.practice.sword_to_offer.树;

import java.util.ArrayList;

/**
 * 借助队列实现二叉树的层序遍历
 */
public class 从上往下打印二叉树 {
    public class Solution {
        public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
            ArrayList<Integer> list = new ArrayList<>();
            ArrayList<TreeNode> queue = new ArrayList<>();
            if (root == null)
                return list;
            queue.add(root);
            while (queue.size() != 0) {
                TreeNode tmp = queue.remove(0);
                if (tmp.left != null)
                    queue.add(tmp.left);
                if (tmp.right != null)
                    queue.add(tmp.right);
                list.add(tmp.val);
            }
            return list;
        }
    }
}
