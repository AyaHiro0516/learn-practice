package org.ayahiro.practice.sword_to_offer.树;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 二叉树的层序遍历  思路是为每层添加一个分隔符 遇到分隔符时打印，然后再次添加分隔符
 * 遇到一般节点只压栈
 */
public class 把二叉树打印成多行 {
    public class Solution {
        ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
            ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
            if (pRoot == null) {
                return ret;
            }
            ArrayList<Integer> list = new ArrayList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.addLast(null);//层分隔符
            queue.addLast(pRoot);
            while (queue.size() != 1) {
                TreeNode node = queue.removeFirst();
                if (node == null) {//到达层分隔符
                    Iterator<TreeNode> iter = queue.iterator();
                    while (iter.hasNext()) {
                        TreeNode temp = (TreeNode)iter.next();
                        list.add(temp.val);
                        System.out.print(temp.val + " ");
                    }
                    System.out.println();
                    ret.add(new ArrayList<Integer>(list));
                    list.clear();
                    queue.addLast(null);//添加层分隔符
                    continue;//一定要continue
                }
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            return ret;
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