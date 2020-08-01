package org.ayahiro.practice.sword_to_offer.知识迁移能力;

public class 翻转单词顺序列 {
    public class Solution {
        public String ReverseSentence(String str) {
            if (str == null || str.trim().equals("")) return str;
            String[] strings = str.split("\\s");
            StringBuffer ans = new StringBuffer();
            for (int i = strings.length - 1; i >= 0; --i) {
                ans.append(strings[i] + " ");
            }
            return new String(ans).trim();
        }
    }
}
