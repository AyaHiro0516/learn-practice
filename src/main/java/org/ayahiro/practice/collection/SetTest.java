package org.ayahiro.practice.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author ayahiro
 * @Description: Set的遍历方式
 * @Create: 2019/7/31
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");

        for (String s : set) {
            System.out.println(s);
        }

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.println(s);
        }
    }
}
