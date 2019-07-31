package org.ayahiro.practice.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author ayahiro
 * @Description: 不要在 foreach 循环里进行元素的 remove / add 操作。
 * remove 元素请使用Iterator方式，如果并发操作，需要对 Iterator 对象加锁。
 * @Create: 2019/7/31
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        for (String s : arrayList) {
            if ("b".equals(s)) {
                arrayList.remove(s);
                //此处如果不break，会报错
                break;
            }
        }

        System.out.println(arrayList);

        List<String> arrayList1 = new ArrayList<>();
        arrayList1.add("a");
        arrayList1.add("b");
        Iterator<String> iterator = arrayList1.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if ("b".equals(s)) {
                iterator.remove();
            }
        }

        System.out.println(arrayList1);
    }
}
