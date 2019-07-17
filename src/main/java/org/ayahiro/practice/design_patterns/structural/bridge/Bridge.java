package org.ayahiro.practice.design_patterns.structural.bridge;

/**
 * @Author ayahiro
 * @Description: 将一个抽象与实现解耦，以便两者可以独立的变化。
 * @Create: 2019/7/17
 */
public class Bridge {
    public static void main(String[] args) {
        Slayer bladeMaster = new BladeMaster();
        bladeMaster.setSword(new TooKnife());
        bladeMaster.attack();

        Slayer berserker = new Berserker();
        berserker.setSword(new GreatSword());
        berserker.attack();
    }
}

//Implementor
interface Sword {
    void attack();
}

//ConcreteImplementor
class GreatSword implements Sword {
    @Override
    public void attack() {
        System.out.println("使用巨剑挥砍");
    }
}

class TooKnife implements Sword {
    @Override
    public void attack() {
        System.out.println("使用太刀突刺");
    }
}

//Abstraction
abstract class Slayer {
    protected Sword sword;

    void setSword(Sword sword) {
        this.sword = sword;
    }

    abstract void attack();
}

//RefinedAbstraction
class BladeMaster extends Slayer {
    @Override
    void attack() {
        System.out.print("剑魂");
        sword.attack();
    }
}

class Berserker extends Slayer {
    @Override
    void attack() {
        System.out.print("狂战士");
        sword.attack();
    }
}