package org.ayahiro.practice.sword_to_offer.树;

import java.util.ArrayList;
import java.util.Collections;

public class 二叉树中和为某一值的路径 {
    public class Solution {
        public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            ArrayList<Integer> cur = new ArrayList<>();

            dfs(root, target, cur, res);
            Collections.sort(res, (o1, o2) -> o2.size() - o1.size());
            return res;
        }

        public void dfs(TreeNode root, int target, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> res) {
            if (root == null) return;
            int value = root.val;
            cur.add(value);
            if (target == value && root.left == null && root.right == null) {
                res.add(new ArrayList<>(cur));
            } else {
                dfs(root.left, target - value, cur, res);
                dfs(root.right, target - value, cur, res);
            }
            //这里是回溯的标志
            cur.remove(cur.size() - 1);
        }
    }
}
