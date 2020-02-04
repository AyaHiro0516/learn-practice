package org.ayahiro.practice.sword_to_offer.代码的鲁棒性;

public class 链表中倒数第k个结点 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        public ListNode FindKthToTail(ListNode head, int k) {
            if (k == 0) {
                return null;
            }
            ListNode nex = head;
            ListNode pre = head;
            int a = k;
            int count = 0;
            while (pre != null) {
                pre = pre.next;
                k -= 1;
                count++;
                if (k < 0) {
                    nex = nex.next;
                }
            }
            if (count < a) return null;
            return nex;
        }
    }
}
