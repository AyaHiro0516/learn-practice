package org.ayahiro.practice.sword_to_offer.知识迁移能力;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 三十六进制整数加法 {
    static Character[] nums = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    static List<Character> list = Arrays.asList(nums);

    static String add36(String s1, String s2) {
        char[] num1 = s1.toCharArray();
        char[] num2 = s2.toCharArray();
        int i = num1.length - 1, j = num2.length - 1;
        int temp = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int sum = list.indexOf(num1[i]) + list.indexOf(num2[j]) + temp;
            if (sum >= 36) {
                temp = 1;
                ans.append(list.get(sum % 36));
            } else {
                temp = 0;
                ans.append(list.get(sum));
            }
            i--;
            j--;
        }
        while (i >= 0) {
            int sum = list.indexOf(num1[i]) + temp;
            if (sum >= 36) {
                temp = 1;
                ans.append(list.get(sum % 36));
            } else {
                temp = 0;
                ans.append(list.get(sum));
            }
            i--;
        }
        while (j >= 0) {
            int sum = list.indexOf(num2[j]) + temp;
            if (sum >= 36) {
                temp = 1;
                ans.append(list.get(sum % 36));
            } else {
                temp = 0;
                ans.append(list.get(sum));
            }
            j--;
        }
        if (temp != 0) ans.append("1");
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.next();
        String str2 = scan.next();
        String r = add36(str1.toUpperCase(), str2.toUpperCase());
        System.out.println(r);

    }
}
