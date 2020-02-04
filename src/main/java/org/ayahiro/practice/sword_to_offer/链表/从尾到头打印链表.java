package org.ayahiro.practice.sword_to_offer.链表;

import java.util.ArrayList;
import java.util.Stack;

public class 从尾到头打印链表 {

    public class Solution {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            Stack<Integer> temp = new Stack<>();
            while (listNode != null) {
                temp.push(listNode.val);
                listNode = listNode.next;
            }
            while (!temp.empty()) {
                arrayList.add(temp.pop());
            }
            return arrayList;
        }
    }
}
