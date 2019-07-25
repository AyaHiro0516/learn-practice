package org.ayahiro.practice.design_patterns.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayahiro
 * @Description: 封装一些施加于某种数据结构元素之上的操作。一旦这些操作需要修改，接受这个操作的数据结构可以保持不变。
 * 访问者模式适用于数据结构相对未定的系统，它把数据结构和作用于结构上的操作之间的耦合解脱开，使得操作集合可以相对自由的演化。
 * @Create: 2019/7/25
 */
public class Visitor {
    public static void main(String[] args) {
        ToiletManager toiletManager = new ToiletManager();
        toiletManager.attach(new ManRoom());
        toiletManager.attach(new WomanRoom());

        Stool stool = new Stool();
        toiletManager.display(stool);

        Pee pee = new Pee();
        toiletManager.display(pee);
    }
}

//Visitor
abstract class Rest {
    public abstract void getManRest(ManRoom manRoom);

    public abstract void getWomanRest(WomanRoom womanRoom);
}

//ConcreteVisitor
class Stool extends Rest {
    @Override
    public void getManRest(ManRoom manRoom) {
        System.out.println(manRoom.getClass().getSimpleName() + "上大便");
    }

    @Override
    public void getWomanRest(WomanRoom womanRoom) {
        System.out.println(womanRoom.getClass().getSimpleName() + "上大便");
    }
}

class Pee extends Rest {
    @Override
    public void getManRest(ManRoom manRoom) {
        System.out.println(manRoom.getClass().getSimpleName() + "上小便");
    }

    @Override
    public void getWomanRest(WomanRoom womanRoom) {
        System.out.println(womanRoom.getClass().getSimpleName() + "上小便");
    }
}

//Element
abstract class Toilet {
    public abstract void accept(Rest rest);
}

//ConcreteElementA
class ManRoom extends Toilet {
    @Override
    public void accept(Rest rest) {
        rest.getManRest(this);
    }
}

//ConcreteElementB
class WomanRoom extends Toilet {
    @Override
    public void accept(Rest rest) {
        rest.getWomanRest(this);
    }
}

//ObjectStructure
class ToiletManager {
    private List<Toilet> elements = new ArrayList<>();

    public void attach(Toilet toilet) {
        elements.add(toilet);
    }

    public void detach(Toilet toilet) {
        elements.remove(toilet);
    }

    public void display(Rest rest) {
        for (Toilet toilet : elements) {
            toilet.accept(rest);
        }
    }
}
