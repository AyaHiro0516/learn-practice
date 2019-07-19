package org.ayahiro.practice.design_patterns.structural.decorator;


/**
 * @Author ayahiro
 * @Description: 向某个对象动态地添加更多的功能。修饰模式是除类继承外另一种扩展功能的方法。
 * @Create: 2019/7/18
 */
public class Decorator {
    public static void main(String[] args) {
        Tea tea1 = new Pudding(new Pearl(new MilkTea()));
        Tea tea2 = new Pearl(new Pudding(new FruitTea()));
        System.out.println("点了一杯 " + tea1.getType() + "，售价" + tea1.cost() + "元。");
        System.out.println("点了一杯 " + tea2.getType() + "，售价" + tea2.cost() + "元。");
    }

}

//Component
abstract class Tea {
    abstract String getType();

    abstract int cost();
}

//ConcreteComponent
class MilkTea extends Tea {
    @Override
    String getType() {
        return "奶茶";
    }

    @Override
    int cost() {
        return 5;
    }
}

class FruitTea extends Tea {
    @Override
    String getType() {
        return "果茶";
    }

    @Override
    int cost() {
        return 8;
    }
}

//Decorator
abstract class AddStuff extends Tea {
    protected Tea tea;

    public AddStuff(Tea tea) {
        this.tea = tea;
    }

    @Override
    String getType() {
        return tea.getType();
    }

    @Override
    int cost() {
        return tea.cost();
    }
}

//ConcreteDecorator
class Pearl extends AddStuff {
    public Pearl(Tea tea) {
        super(tea);
    }

    @Override
    String getType() {
        return "珍珠" + super.getType();
    }

    @Override
    int cost() {
        return super.cost() + 1;
    }
}

class Pudding extends AddStuff {
    public Pudding(Tea tea) {
        super(tea);
    }

    @Override
    String getType() {
        return "布丁" + super.getType();
    }

    @Override
    int cost() {
        return super.cost() + 2;
    }
}