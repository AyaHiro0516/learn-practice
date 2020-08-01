package org.ayahiro.practice.sword_to_offer.分解让复杂问题简单;

import com.sun.javaws.IconUtil;
import sun.java2d.pipe.AAShapePipe;

import java.util.ArrayList;
import java.util.Collections;

public class 字符串的全排列 {
    public class Solution {
        public ArrayList<String> Permutation(String str) {
            ArrayList<String> res = new ArrayList<>();
            if (str != null && str.length() > 0) {
                PermutationHelper(str.toCharArray(), 0, res);
                Collections.sort(res);
            }
            return res;
        }

        public void PermutationHelper(char[] cs, int i, ArrayList<String> list) {
            if (i == cs.length - 1) {
                String val = String.valueOf(cs);
                if (!list.contains(val))
                    list.add(val);
            } else {
                for (int j = i; j < cs.length; j++) {
                    swap(cs, i, j);
                    PermutationHelper(cs, i + 1, list);
                    swap(cs, i, j);
                }
            }
        }

        public void swap(char[] cs, int i, int j) {
            char temp = cs[i];
            cs[i] = cs[j];
            cs[j] = temp;
        }
    }

    //DFS版
    public static class Solution2 {
        public static StringBuffer temp = new StringBuffer();
        public static ArrayList<String> res = new ArrayList<>();

        public static ArrayList<String> Permutation(String str) {
            if (str != null && str.length() > 0) {
                PermutationHelper(str.toCharArray());
                Collections.sort(res);
            }
            return res;
        }

        public static void PermutationHelper(char[] cs) {
            if (temp.length() == cs.length) {
                System.out.println(temp.toString());
                res.add(temp.toString());
                return;
            }
            for (int i = 0; i < cs.length; ++i) {
                char c = cs[i];
                if (c != '*') {
                    cs[i] = '*';
                    temp.append(c);
                    PermutationHelper(cs);
                    temp.deleteCharAt(temp.length() - 1);
                    cs[i] = c;
                }
            }
        }
    }

    public static void main(String[] args) {
        String s="aaa";
        Solution2.Permutation(s);
    }
}
