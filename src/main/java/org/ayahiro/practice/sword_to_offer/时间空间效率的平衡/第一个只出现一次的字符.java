package org.ayahiro.practice.sword_to_offer.时间空间效率的平衡;

public class 第一个只出现一次的字符 {

    public static int FirstNotRepeatingChar(String str) {
        int pos = 0;
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            int first = str.indexOf(str.charAt(i));
            int last = str.lastIndexOf(str.charAt(i));
            if (first == last) {
                pos = i;
                flag = true;
                break;
            }
        }
        return flag ? pos : -1;
    }
}
