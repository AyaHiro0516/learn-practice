package org.ayahiro.practice.sword_to_offer.树;

import java.util.Arrays;

/**
 * 重点理解根据前序遍历 中序遍历重建二叉树
 */
public class 重建二叉树 {
    public class Solution {
        public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
            TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
            return root;
        }

        //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
        private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
            if (startPre > endPre || startIn > endIn)
                return null;
            TreeNode root = new TreeNode(pre[startPre]);
            for (int i = startIn; i <= endIn; i++)
                if (in[i] == pre[startPre]) {
                    root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                    root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
                    break;
                }
            return root;
        }
    }
}
