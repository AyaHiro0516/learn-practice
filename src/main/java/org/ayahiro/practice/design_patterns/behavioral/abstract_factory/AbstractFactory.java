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
        Game game1 = gameFactory1.playRPGGame();
        Game game2 = gameFactory1.playCardGame();
        Game game3 = gameFactory2.playRPGGame();
        Game game4 = gameFactory2.playCardGame();
        game1.play();
        game2.play();
        game3.play();
        game4.play();
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

class WOW implements Game {
    @Override
    public void play() {
        System.out.println("魔兽世界，启动！");
    }
}

class Witcher implements Game {
    @Override
    public void play() {
        System.out.println("巫师，启动！");
    }
}

interface GameFactory {
    Game playRPGGame();

    Game playCardGame();
}

class CDProjektRed implements GameFactory {
    @Override
    public Game playRPGGame() {
        return new Witcher();
    }

    @Override
    public Game playCardGame() {
        return new Gwent();
    }
}

class Blizzard implements GameFactory {
    @Override
    public Game playRPGGame() {
        return new WOW();
    }

    @Override
    public Game playCardGame() {
        return new HeartStone();
    }
}

