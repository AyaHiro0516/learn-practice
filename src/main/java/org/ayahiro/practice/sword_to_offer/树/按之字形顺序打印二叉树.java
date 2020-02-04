package org.ayahiro.practice.sword_to_offer.树;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 设置两个栈，一个存奇数层，一个存偶数层 对于不同层，添加节点左右儿子的顺序不同
 */
public class 按之字形顺序打印二叉树 {

    public class Solution {
        public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
            int layer = 1;
            //s1存奇数层节点
            Stack<TreeNode> s1 = new Stack<TreeNode>();
            s1.push(pRoot);
            //s2存偶数层节点
            Stack<TreeNode> s2 = new Stack<TreeNode>();

            ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

            while (!s1.empty() || !s2.empty()) {
                if (layer % 2 != 0) {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    while (!s1.empty()) {
                        TreeNode node = s1.pop();
                        if (node != null) {
                            temp.add(node.val);
                            System.out.print(node.val + " ");
                            s2.push(node.left);
                            s2.push(node.right);
                        }
                    }
                    if (!temp.isEmpty()) {
                        list.add(temp);
                        layer++;
                        System.out.println();
                    }
                } else {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    while (!s2.empty()) {
                        TreeNode node = s2.pop();
                        if (node != null) {
                            temp.add(node.val);
                            System.out.print(node.val + " ");
                            s1.push(node.right);
                            s1.push(node.left);
                        }
                    }
                    if (!temp.isEmpty()) {
                        list.add(temp);
                        layer++;
                        System.out.println();
                    }
                }
            }
            return list;
        }
    }
}
