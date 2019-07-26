package org.ayahiro.practice.design_patterns.behavioral.template_method;

/**
 * @Author ayahiro
 * @Description: 模板方法模式准备一个抽象类，将部分逻辑以具体方法及具体构造子类的形式实现，然后声明一些抽象方法来迫使子类实现剩余的逻辑。
 * 不同的子类可以以不同的方式实现这些抽象方法，从而对剩余的逻辑有不同的实现。先构建一个顶级逻辑框架，而将逻辑的细节留给具体的子类去实现。
 * @Create: 2019/7/26
 */
public class TemplateMethod {
    public static void main(String[] args) {
        System.out.println("-----开始制作珍珠奶茶-----");
        MilkTea pearl = new PearlMilkTea();
        pearl.makeMilkTea();

        System.out.println("-----开始制作红豆奶茶加冰-----");
        MilkTea redBean = new RedBeanMilkTeaWithIce();
        redBean.makeMilkTea();
    }
}

//AbstractClass
abstract class MilkTea {
    protected final void makeMilkTea() {
        addMilk();
        addTea();
        if (needIce()) {
            addIce();
        }
        addStuff();
        packUp();
    }

    final void addMilk() {
        System.out.println("添加牛奶");
    }

    final void addTea() {
        System.out.println("添加茶汁");
    }

    final void addIce() {
        System.out.println("添加冰块");
    }

    final void packUp() {
        System.out.println("塑封，完成！");
    }

    protected boolean needIce() {
        return false;
    }

    abstract void addStuff();
}

//ConcreteClass
class PearlMilkTea extends MilkTea {
    @Override
    void addStuff() {
        System.out.println("加珍珠");
    }
}

class RedBeanMilkTeaWithIce extends MilkTea {
    @Override
    protected boolean needIce() {
        return true;
    }

    @Override
    void addStuff() {
        System.out.println("加红豆");
    }
}