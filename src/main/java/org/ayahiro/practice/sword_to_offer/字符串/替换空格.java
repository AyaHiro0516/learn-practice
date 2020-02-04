package org.ayahiro.practice.sword_to_offer.字符串;

public class 替换空格 {
    public class Solution {
        public String replaceSpace(StringBuffer str) {
            for (int i = 0; i < str.length(); ++i) {
                if (str.charAt(i) == ' ') {
                    str.replace(i, i + 1, "%20");
                }
            }
            return str.toString();
        }
    }
}
