package org.ayahiro.practice.design_patterns.structural.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author ayahiro
 * @Description: 为其他对象提供一个代理以控制对这个对象的访问。
 * @Create: 2019/7/19
 */
public class Proxy {
    public static void main(String[] args) {
        Computer computer = new Computer("IBN-5100");
        computer.connection();

        //静态代理
        Networking computerVPN = new ComputerVPNProxy(computer);
        computerVPN.connection();

        //JDK动态代理
        Networking smartPhoneVPN = (Networking) java.lang.reflect.Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Networking.class}, new DynamicVPNProxy(new SmartPhone("IPhoneX")));
        smartPhoneVPN.connection();

        //Cglib动态代理
        Networking smartPhoneVPN1 = (Networking) new CglibVPNProxy(new SmartPhone("MI6")).getVPNInstance();
        smartPhoneVPN1.connection();
    }
}

//Subject
interface Networking {
    void connection();
}

//RealSubject
class Computer implements Networking {
    private String name;

    public Computer() {
    }

    public Computer(String name) {
        this.name = name;
    }

    @Override
    public void connection() {
        System.out.println(name + " 已联网，但访问网站受限。");
    }
}

class SmartPhone implements Networking {
    private String name;

    public SmartPhone() {
    }

    public SmartPhone(String name) {
        this.name = name;
    }

    @Override
    public void connection() {
        System.out.println(name + " 已联网，但访问网站受限。");
    }
}

//Proxy
class ComputerVPNProxy implements Networking {
    Computer computer;

    public ComputerVPNProxy(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void connection() {
        computer.connection();
        System.out.println("已翻墙，开始网上冲浪吧！");
    }
}

//JDK动态代理
class DynamicVPNProxy implements InvocationHandler {
    private Networking networking;

    public DynamicVPNProxy(Networking networking) {
        this.networking = networking;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        if ("connection".equals(method.getName())) {
            result = method.invoke(networking, args);
        }
        System.out.println("已翻墙，开始网上冲浪吧！");
        return result;
    }
}


//cglib代理
class CglibVPNProxy implements MethodInterceptor {
    private Object target;//注意 target最好写一个无参构造方法

    public CglibVPNProxy(Object target) {
        this.target = target;
    }

    public Object getVPNInstance() {
        //1工具类
        Enhancer en = new Enhancer();
        //2设置父类
        en.setSuperclass(target.getClass());
        //3设置回调函数
        en.setCallback(this);
        //4创建子类(代理对象)
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result = null;
        if ("connection".equals(method.getName())) {
            result = method.invoke(target, objects);
        }
        System.out.println("已翻墙，开始网上冲浪吧！");
        return result;
    }
}