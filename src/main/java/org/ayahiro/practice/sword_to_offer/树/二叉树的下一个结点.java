package org.ayahiro.practice.sword_to_offer.树;

/**
 * 总结归纳法  归纳中序遍历下一个节点有哪些情况
 */
public class 二叉树的下一个结点 {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    public class Solution {
        TreeLinkNode GetNext(TreeLinkNode node) {
            if (node == null) return null;
            if (node.right != null) {    //如果有右子树，则找右子树的最左节点
                node = node.right;
                while (node.left != null) node = node.left;
                return node;
            }
            while (node.next != null) { //没右子树，则找第一个当前节点是父节点左孩子的节点
                if (node.next.left == node) return node.next;
                node = node.next;
            }
            return null;   //退到了根节点仍没找到，则返回null
        }
    }
}
