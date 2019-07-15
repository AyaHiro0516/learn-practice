package org.ayahiro.practice.design_patterns.behavioral.abstract_factory;

/**
 * @Author ayahiro
 * @Description: 为一个产品族提供了统一的创建接口。当需要这个产品族的某一系列的时候，可以从抽象工厂中选出相应的系列创建一个具体的工厂类。
 * @Create: 2019/7/14
 */
public class AbstractFactory {
    public static void main(String[] args) {
        GameFactory gameFactory1 = new CDProjektRed();
        GameFactory gameFactory2 = new Blizzard();
        RPGGame game1 = gameFactory1.playRPGGame();
        CardGame game2 = gameFactory1.playCardGame();
        RPGGame game3 = gameFactory2.playRPGGame();
        CardGame game4 = gameFactory2.playCardGame();
        game1.play();
        game2.play();
        game3.play();
        game4.play();
    }
}

//AbstractProductA
interface RPGGame {
    void play();
}

//AbstractProductB
interface CardGame {
    void play();
}

//ProductB
class HeartStone implements CardGame {
    @Override
    public void play() {
        System.out.println("炉石传说，启动！");
    }
}

class Gwent implements CardGame {
    @Override
    public void play() {
        System.out.println("昆特牌，启动！");
    }
}

//ProductA
class WOW implements RPGGame {
    @Override
    public void play() {
        System.out.println("魔兽世界，启动！");
    }
}

class Witcher implements RPGGame {
    @Override
    public void play() {
        System.out.println("巫师，启动！");
    }
}

//AbstractFactory
interface GameFactory {
    RPGGame playRPGGame();

    CardGame playCardGame();
}

//ConcreteFactory1
class CDProjektRed implements GameFactory {
    @Override
    public RPGGame playRPGGame() {
        return new Witcher();
    }

    @Override
    public CardGame playCardGame() {
        return new Gwent();
    }
}

//ConcreteFactory2
class Blizzard implements GameFactory {
    @Override
    public RPGGame playRPGGame() {
        return new WOW();
    }

    @Override
    public CardGame playCardGame() {
        return new HeartStone();
    }
}

