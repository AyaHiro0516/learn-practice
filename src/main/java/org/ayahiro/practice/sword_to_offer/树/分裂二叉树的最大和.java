package org.ayahiro.practice.sword_to_offer.树;

public class 分裂二叉树的最大和 {
    class Solution {
        double ans = Double.MIN_VALUE;
        double allSum, nodeSum;
        double[] dp = new double[50000 + 5];
        int index = 0;

        public int maxProduct(TreeNode root) {
            allSum = dfs(root);
            //dfs(root);
            for (int i = 0; i < index; i++) {
                ans = Math.max(ans, (allSum - dp[i]) * dp[i]);
            }
            return (int) (ans % (int) (1e9 + 7));
        }

        public double dfs(TreeNode node) {
            if (node == null) return 0;
            return dp[index++] = node.val + dfs(node.left) + dfs(node.right);
            //ans = Math.max(ans, (allSum - nodeSum) * nodeSum);
            //return nodeSum;
        }
    }
}
