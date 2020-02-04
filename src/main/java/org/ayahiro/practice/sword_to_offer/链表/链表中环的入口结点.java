package org.ayahiro.practice.sword_to_offer.链表;

import java.util.Stack;

public class 链表中环的入口结点 {

    public class Solution {

        public ListNode EntryNodeOfLoop(ListNode pHead) {
            ListNode entry = null;
            Stack<ListNode> st=new Stack<>();
            while(pHead!=null){
                if (st.contains(pHead)){
                    entry=pHead;
                    break;
                }
                st.push(pHead);
                pHead=pHead.next;
            }
            return entry;
        }
    }

}
