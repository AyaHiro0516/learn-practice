package org.ayahiro.practice.juc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 根据给出数据，找出同时满足以下条件的数据
 * 1 偶数ID 且 年龄大于24 且 用户名转为大写 且 用户名字倒排序
 * 2 只输出一个用户名字
 */
public class StreamDemo {
    public static void main(String[] args) {
        User u1 = new User(11, "a", 23);
        User u2 = new User(12, "b", 24);
        User u3 = new User(13, "c", 22);
        User u4 = new User(14, "d", 28);
        User u5 = new User(16, "e", 26);

        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);

        list.stream().
                filter(u -> u.id % 2 == 0).
                filter(u -> u.age > 24).
                map(u -> u.userName.toUpperCase()).
                sorted(Comparator.reverseOrder()).
                limit(1).
                forEach(System.out::println);
    }
}

class User {
    protected int id;
    protected String userName;
    protected int age;

    public User(int id, String userName, int age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }
}
