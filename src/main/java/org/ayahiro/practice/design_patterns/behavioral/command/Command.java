package org.ayahiro.practice.design_patterns.behavioral.command;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author ayahiro
 * @Description: 将一个请求封装为一个对象，从而使你可用不同的请求对客户进行参数化；对请求排队或记录请求日志，以及支持可取消的操作。
 * @Create: 2019/7/24
 */
public class Command {
    public static void main(String[] args) {
        Barbecuer barbecuer=new Barbecuer();
        Order order1=new BakeChickenWingOrder(barbecuer);
        Order order2=new BakeMuttonOrder(barbecuer);
        Order order3=new BakeMuttonOrder(barbecuer);

        Waiter waiter=new Waiter();
        waiter.setOrder(order1);
        waiter.setOrder(order2);
        waiter.setOrder(order3);
        waiter.notifyOrders();
    }
}

//Receiver
class Barbecuer {
    public void bakeMutton() {
        System.out.println("烤羊肉串");
    }

    public void bakeChickenWing() {
        System.out.println("烤鸡翅");
    }
}

//Command
abstract class Order {
    protected Barbecuer barbecuer;

    public Order(Barbecuer barbecuer) {
        this.barbecuer = barbecuer;
    }

    abstract public void excuteOrder();
}

//ConcreteCommand
class BakeMuttonOrder extends Order {
    public BakeMuttonOrder(Barbecuer barbecuer) {
        super(barbecuer);
    }

    @Override
    public void excuteOrder() {
        barbecuer.bakeMutton();
    }
}

class BakeChickenWingOrder extends Order {
    public BakeChickenWingOrder(Barbecuer barbecuer) {
        super(barbecuer);
    }

    @Override
    public void excuteOrder() {
        barbecuer.bakeChickenWing();
    }
}

//Invoker
class Waiter {
    private List<Order> orders = new ArrayList<>();

    public void setOrder(Order order) {
        if (order instanceof BakeChickenWingOrder) {
            System.out.println("服务员：鸡翅没有了！");
        } else {
            orders.add(order);
            System.out.println("增加订单：" + order.getClass().getSimpleName() + "，时间：" + new Date().toString());
        }
    }

    public void cancelOrder(Order order) {
        orders.remove(order);
        System.out.println("取消订单：" + order.getClass().getSimpleName() + "，时间：" + new Date().toString());
    }

    public void notifyOrders() {
        for (Order order : orders) {
            order.excuteOrder();
        }
    }
}
