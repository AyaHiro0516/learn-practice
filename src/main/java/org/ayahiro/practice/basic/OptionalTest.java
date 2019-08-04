package org.ayahiro.practice.basic;


import java.util.Optional;

/**
 * @Author ayahiro
 * @Description: Optional的各种操作
 * @Create: 2019/8/4
 */
public class OptionalTest {
    public static void main(String[] args) {
        User user = new User();
        User nullUser = null;
        user.setName("ayahiro");
        //test1();
        //test2();
        //test3(user);
        //test4(null);
        //test5(user);
        //test6(user);
        System.out.println(test7(nullUser));
    }

    public static void test1() {
        User user = new User();
        User user1 = null;

        // 传递进去的对象不可以为null，如果为null则抛出异常
        Optional<User> op1 = Optional.of(user);

        // 传递进去的对象可以为null，如果为null则返回一个没有装载对象的Optional容器
        Optional<User> op2 = Optional.ofNullable(user1);
        System.out.println(op2.isPresent());
    }

    public static void test2() {
        User user = new User();
        User user1 = null;

        Optional<User> op1 = Optional.ofNullable(user);
        System.out.println(op1.isPresent());
        System.out.println(op1.get());
        System.out.println(op1.orElse(user1));
    }

    public static void test3(User user) {
        Optional<User> optional = Optional.ofNullable(user);

        // 如果存在user，则直接返回，否则创建出一个新的User对象
        User user1 = optional.orElseGet(() -> new User());

        // 旧写法
        if (user != null) {
            user = new User();
        }
    }

    public static void test4(User user) {
        Optional<User> optional = Optional.ofNullable(user);

        // 如果存在user，则打印user的name
        optional.ifPresent((value) -> System.out.println(value.getName()));

        // 旧写法
        if (user != null) {
            System.out.println(user.getName());
        }
    }

    public static void test5(User user) {
        Optional<User> optional = Optional.ofNullable(user);

        // 如果容器中的对象存在，并且符合过滤条件，返回装载对象的Optional容器，否则返回一个空的Optional容器
        Optional<User> testFilter = optional.filter((value) -> "ayahiro".equals(value.getName()));
        System.out.println(testFilter.isPresent());
    }

    public static void test6(User user) {
        Optional<User> optional = Optional.ofNullable(user);

        // 如果容器的对象存在，则对其执行调用mapping函数得到返回值。然后创建包含mapping返回值的Optional，否则返回空Optional
        Optional<String> testMap = optional.map(user1 -> user1.getName());
        System.out.println(testMap.get());
    }

    public static String test7(User user) {
        return Optional.ofNullable(user)
                .map(u -> u.getName())
                .map(name -> name.toUpperCase()).orElse("Unknown");
    }
}

class User {
    private Integer id;
    private String name;
    private Short age;

    public User() {
    }

    public User(Integer id, String name, Short age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}