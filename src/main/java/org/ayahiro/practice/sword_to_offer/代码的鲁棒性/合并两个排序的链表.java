package org.ayahiro.practice.sword_to_offer.代码的鲁棒性;

public class 合并两个排序的链表 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        public ListNode Merge(ListNode list1, ListNode list2) {
            ListNode head = new ListNode(-1);
            head.next = null;
            ListNode ans = head;
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    head.next = list1;
                    head = head.next;
                    list1 = list1.next;
                } else {
                    head.next = list2;
                    head = head.next;
                    list2 = list2.next;
                }
            }
            if (list1 != null) {
                head.next = list1;
            }
            if (list2 != null) {
                head.next = list2;
            }
            return ans;
        }
    }
}
