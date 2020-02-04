package org.ayahiro.practice.sword_to_offer.代码的完整性;

public class 数值的整数次方 {
    public class Solution {
        public double Power(double base, int exponent) {
            double ans = 1;
            for (int i = 0; i < Math.abs(exponent); ++i) {
                ans *= base;
            }
            if (exponent >= 0)
                return ans;
            else
                return 1 / ans;
        }
    }
}
