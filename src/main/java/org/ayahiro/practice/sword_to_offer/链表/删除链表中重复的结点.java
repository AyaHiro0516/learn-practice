package org.ayahiro.practice.sword_to_offer.链表;

import java.util.ArrayList;
import java.util.Stack;

public class 删除链表中重复的结点 {

    public class Solution {
        public ListNode deleteDuplication(ListNode pHead) {
            if (pHead == null)
                return null;
            Stack<ListNode> st = new Stack<>();
            boolean flag = true, isCheck = false;
            int lastVal = pHead.val;
            while (pHead != null) {
                if (!st.empty() && st.peek().val == pHead.val) {
                    lastVal = st.peek().val;
                    st.pop();
                    flag = false;
                    isCheck = true;
                }
                if (flag) st.push(pHead);
                flag = true;
                pHead = pHead.next;
            }
            //特判 {1->1->2},{1->1->1}                        特判 {1->1->2->2}
            if (isCheck && st.size() == 1 && lastVal == st.peek().val || st.empty())
                return null;

            ArrayList<ListNode> list = new ArrayList<>(st);
            ListNode head = list.get(0), ans = head;
            for (int i = 1; i < list.size(); ++i) {
                head.next = list.get(i);
                head = head.next;
            }
            head.next = null;

            return ans;
        }
    }
}
