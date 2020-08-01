package org.ayahiro.practice.sword_to_offer.树.二叉树遍历模板;

import org.ayahiro.practice.sword_to_offer.树.TreeNode;

import java.util.ArrayList;

public class 层序遍历 {
    class Solution {
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
