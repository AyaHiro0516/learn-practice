package org.ayahiro.practice.design_patterns.behavioral.strategy;

/**
 * @Author ayahiro
 * @Description: 定义一个算法的系列，将其各个分装，并且使他们有交互性。策略模式使得算法在用户使用的时候能独立的改变。
 * @Create: 2019/7/26
 */
public class Strategy {
    public static void main(String[] args) {
        TakeawayPlatform takeawayKFC = new TakeawayPlatform(new KFC());
        takeawayKFC.getFood();

        TakeawayPlatform takeawayMCD = new TakeawayPlatform(new McDonalds());
        takeawayMCD.getFood();

        TakeawayFactory takeawayFactory = new TakeawayFactory("KFC");
        takeawayFactory.getFood();
    }
}

//Strategy
abstract class FastFood {
    abstract void getFood();
}

//ConcreteStrategy
class KFC extends FastFood {
    @Override
    void getFood() {
        System.out.println("点开封菜！");
    }
}

class McDonalds extends FastFood {
    @Override
    void getFood() {
        System.out.println("点金拱门！");
    }
}

//Context
class TakeawayPlatform {
    FastFood fastFood;

    public TakeawayPlatform(FastFood fastFood) {
        this.fastFood = fastFood;
    }

    public void getFood() {
        fastFood.getFood();
    }
}

//策略模式结合简单工厂
class TakeawayFactory {
    FastFood fastFood = null;

    private final String KFC = "KFC";
    private final String McDonalds = "McDonalds";

    public TakeawayFactory(String type) {
        switch (type) {
            case KFC:
                fastFood = new KFC();
                break;
            case McDonalds:
                fastFood = new McDonalds();
                break;
        }
    }

    public void getFood() {
        fastFood.getFood();
    }
}