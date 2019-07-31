package org.ayahiro.practice.collection;

import java.util.*;

/**
 * @Author ayahiro
 * @Description:
 * @Create: 2019/7/29
 */
public class Test {
    public static void main(String[] args) {
        //ArrayList的add(index, element)过程
        Object[] array = {1, 2, 3, 4, 5, 6};
        int size = array.length;
        //扩容为原来的1.5倍
        array = Arrays.copyOf(array, array.length + 1);
        int index = 3;
        System.arraycopy(array, index, array, index + 1, (size++) - index);
        System.out.println(Arrays.toString(array));
        System.out.println(size);
    }
}
