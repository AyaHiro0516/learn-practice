package org.ayahiro.practice.sword_to_offer.动态规划;

import java.util.HashMap;

public class 无重复字符的最长子串 {
    //滑动窗口版
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            int i = 0, j = 0, len = 0;
            while (i < s.length() && j < s.length()) {
                if (map.containsKey(s.charAt(j))) {
                    i = Math.max(i, map.get(s.charAt(j)) + 1);
                }
                map.put(s.charAt(j), j);
                j++;
                len = Math.max(len, j - i);
            }
            return len;
        }

        public int lengthOfLongestSubstringDP(String s) {
            if (s.length() == 0)
                return 0;
            int[] dp = new int[s.length()];
            dp[0] = 1;
            int res = 1;
            for (int i = 1; i < dp.length; i++) {
                char x = s.charAt(i);
                if (s.contains(x + "")) {
                    int index = s.lastIndexOf(x, i - 1);
                    int d = i - index;
                    if (d > dp[i - 1])
                        dp[i] = dp[i - 1] + 1;
                    else
                        dp[i] = d;
                } else
                    dp[i] = dp[i - 1] + 1;

                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }
}
