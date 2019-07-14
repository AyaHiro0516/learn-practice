package org.ayahiro.practice.design_patterns.behavioral.factory_method;

/**
 * @Author ayahiro
 * @Description: 定义一个接口用于创建对象，但是让子类决定初始化哪个类。工厂方法把一个类的初始化下放到子类。
 * @Create: 2019/7/14
 */
public class FactoryMethod {
    public static void main(String[] args) {
        GameFactory gameFactory1 = new HeartStoneFactory();
        GameFactory gameFactory2 = new GwentFactory();
        Game game1 = gameFactory1.playGame();
        Game game2 = gameFactory2.playGame();
        game1.play();
        game2.play();
    }
}

interface Game {
    void play();
}

class HeartStone implements Game {
    @Override
    public void play() {
        System.out.println("炉石传说，启动！");
    }
}

class Gwent implements Game {
    @Override
    public void play() {
        System.out.println("昆特牌，启动！");
    }
}

interface GameFactory {
    Game playGame();
}

class HeartStoneFactory implements GameFactory {
    @Override
    public Game playGame() {
        return new HeartStone();
    }
}

class GwentFactory implements GameFactory {
    @Override
    public Game playGame() {
        return new Gwent();
    }
}
