package org.ayahiro.practice.sword_to_offer.知识迁移能力;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的深度 {
    public class Solution {
        public class TreeNode {
            int val = 0;
            TreeNode left = null;
            TreeNode right = null;

            public TreeNode(int val) {
                this.val = val;
            }
        }

        public int TreeDepth(TreeNode pRoot) {
            if (pRoot == null) {
                return 0;
            }
            int left = TreeDepth(pRoot.left);
            int right = TreeDepth(pRoot.right);
            return Math.max(left, right) + 1;
        }

        //二叉树的层序遍历
        public int TreeDepthWithQueue(TreeNode root) {
            if (root == null)
                return 0;
            LinkedList<TreeNode> queue = new LinkedList<>();
            int cur = 0, width = 1, deep = 0;
            queue.add(root);
            while (queue.size() != 0) {
                TreeNode tmp = queue.poll();
                cur++;
                if (tmp.left != null) queue.add(tmp.left);
                if (tmp.right != null) queue.add(tmp.right);
                if (cur == width) {
                    cur = 0;
                    width = queue.size();
                    deep++;
                }
            }
            return deep;
        }
    }
}
