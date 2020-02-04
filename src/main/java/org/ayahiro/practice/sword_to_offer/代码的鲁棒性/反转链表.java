package org.ayahiro.practice.sword_to_offer.代码的鲁棒性;

public class 反转链表 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        public ListNode ReverseList(ListNode head) {
            ListNode pre = null, next = null;
            while (head != null) {
                //先用next存head的下一个结点，保证单链表不断
                next = head.next;
                //反转
                head.next = pre;
                //移动pre
                pre = head;
                head = next;
            }
            return pre;
        }
    }
}
