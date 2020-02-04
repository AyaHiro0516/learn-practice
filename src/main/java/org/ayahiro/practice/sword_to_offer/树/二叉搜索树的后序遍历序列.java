package org.ayahiro.practice.sword_to_offer.树;

public class 二叉搜索树的后序遍历序列 {
    public class Solution {
        public boolean VerifySquenceOfBST(int[] sequence) {
            if (sequence.length == 0) return false;
            return judge(sequence, 0, sequence.length - 1);
        }

        boolean judge(int[] a, int l, int r) {
            //l==r 对应叶子节点的情况  l>r 对应右数是空树的情况
            if (l >= r) return true;
            int i = r;
            //查找左右子树的分隔节点  最终i=右子树的第一个节点或根节点
            while (i > l && a[i - 1] > a[r]) --i;
            //查找左子树有没有大于根节点的
            for (int j = i - 1; j >= l; --j) if (a[j] > a[r]) return false;
            //再对左右子树进行判断
            return judge(a, l, i - 1) && (judge(a, i, r - 1));
        }
    }
}
