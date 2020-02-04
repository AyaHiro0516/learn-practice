package org.ayahiro.practice.sword_to_offer.时间空间效率的平衡;

import java.util.HashSet;

public class 两个链表的第一个公共结点 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public class Solution {
        public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            ListNode current1 = pHead1;
            ListNode current2 = pHead2;
            HashSet<ListNode> set = new HashSet<ListNode>();
            while (current1 != null) {
                set.add(current1);
                current1 = current1.next;
            }
            while (current2 != null) {
                if (set.contains(current2))
                    return current2;
                current2 = current2.next;
            }
            return null;
        }
    }
}
