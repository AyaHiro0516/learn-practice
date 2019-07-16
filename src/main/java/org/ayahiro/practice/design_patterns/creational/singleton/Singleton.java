package org.ayahiro.practice.design_patterns.creational.singleton;

/**
 * @Author ayahiro
 * @Description: 确保一个类只有一个实例，并提供对该实例的全局访问。
 * @Create: 2019/7/16
 */
public class Singleton {
    public static void main(String[] args) {
        SingletonHungry singletonHungry = SingletonHungry.getInstance();
        SingletonLazy singletonLazy = SingletonLazy.getInstance();
        SingletonDoubleCheck singletonDoubleCheck = SingletonDoubleCheck.getInstance();
        SingletonInner singletonInner = SingletonInner.getInstance();
        SingletonEnum singletonEnum = SingletonEnum.INSTANCE;
    }
}

//饿汉式
class SingletonHungry {
    private static final SingletonHungry instance = new SingletonHungry();

    private SingletonHungry() {
    }

    public static SingletonHungry getInstance() {
        return instance;
    }
}

//懒汉式
class SingletonLazy {
    private static volatile SingletonLazy instance;

    private SingletonLazy() {
    }

    public static synchronized SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}

//双重检查锁
class SingletonDoubleCheck {
    private static volatile SingletonDoubleCheck instance = null;

    private SingletonDoubleCheck() {
    }

    public static SingletonDoubleCheck getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new SingletonDoubleCheck();
                }
            }
        }
        return instance;
    }
}

//静态内部类
class SingletonInner {
    private static class Holder {
        private static SingletonInner instance = new SingletonInner();
    }

    private SingletonInner() {
    }

    public static SingletonInner getInstance() {
        return Holder.instance;
    }
}

//枚举单例
enum SingletonEnum {
    INSTANCE;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}