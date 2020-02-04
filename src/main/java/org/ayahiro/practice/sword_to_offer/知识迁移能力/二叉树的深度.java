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

        public int TreeDepthWithQueue(TreeNode root) {
            if (root == null) return 0;
            TreeNode current;  //记录当前节点
            Queue<TreeNode> queue = new LinkedList<>();  //构造辅助队列
            int cur, width;           //cur记录访问到当前层的第几个,width为当前层的宽度
            int deep = 0;            //初始深度为0；
            queue.offer(root);          //头结点入队列
            while (!queue.isEmpty()) {        //队列不空 循环记录深度
                cur = 0;                                //新的一层cur赋为0
                width = queue.size();           //当前队列里的节点即为该层的所有节点
                while (cur < width) {               //循环访问该层的所有节点
                    current = queue.poll();    //访问队列的头
                    if (current.left != null)       //左节点不空，左节点入队列
                        queue.offer(current.left);
                    if (current.right != null)     //右节点不空，右节点入队列
                        queue.offer(current.right);
                    cur++;           //访问完当前节点后cur++
                }
                deep++;            //访问完一层，层数++;
            }
            return deep;
        }
    }
}
