package org.ayahiro.practice.sword_to_offer.树;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 二叉树的层序遍历
 */
public class 把二叉树打印成多行 {
    public class Solution {
        ArrayList<ArrayList<Integer>> Print(TreeNode root) {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            if (root == null)
                return ans;
            LinkedList<TreeNode> queue = new LinkedList<>();
            ArrayList<Integer> tmp = new ArrayList<>();
            int cur = 0, width = 1;
            queue.addLast(root);
            while (queue.size() != 0) {
                TreeNode node = queue.removeFirst();
                cur++;
                tmp.add(node.val);
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
                if (cur == width) {
                    for (Integer val : tmp) {
                        System.out.print(val + " ");
                    }
                    System.out.println();
                    cur = 0;
                    width = queue.size();
                    ans.add(new ArrayList<Integer>(tmp));
                    tmp.clear();
                }
            }
            return ans;
        }
    }
}

//public class Solution { 递归版  树的层序遍历
//    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
//        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//        depth(pRoot, 1, list);
//        return list;
//    }
//
//    private void depth(TreeNode root, int depth, ArrayList<ArrayList<Integer>> list) {
//        if(root == null) return;
//        if(depth > list.size())
//            list.add(new ArrayList<Integer>());
//        list.get(depth -1).add(root.val);
//
//        depth(root.left, depth + 1, list);
//        depth(root.right, depth + 1, list);
//    }
//}