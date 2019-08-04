package org.ayahiro.practice.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author ayahiro
 * @Description: Map的多种遍历方式
 * @Create: 2019/7/31
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("a", 1);
        map.put("c", 3);
        map.put("b", 2);

        //Map.keySet遍历
        for (String key : map.keySet()) {
            System.out.println("key= " + key + " and value= " + map.get(key));
        }

        //Map.entrySet使用迭代器遍历
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        //Map.entrySet遍历
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        //只想获取value，使用Map.values()遍历
        for (Object v : map.values()) {
            System.out.println("value= " + v);
        }

        //lambda表达式遍历
        map.forEach((k, v) -> System.out.println(k + " = " + v));
    }
}
