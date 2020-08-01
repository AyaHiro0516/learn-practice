package org.ayahiro.practice.sword_to_offer;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] a=new int[n][m];
            for(int i=0; i<n; i++){
                String str=in.next();
                //System.out.println(str.length());
                for(int j=0; j<m; j++){
                    a[i][j]=str.charAt(j)-'0';
                }
            }
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    System.out.print(a[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
}
