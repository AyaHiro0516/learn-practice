package org.ayahiro.practice.design_patterns.creational.simple_factory;

/**
 * @Author ayahiro
 * @Description: 定义一个类用于创建父类相同的子类对象，由传入参数决定创建哪个子类。
 * @Create: 2019/7/14
 */
public class SimpleFactory {
    public static void main(String[] args) {
        Game game1 = GameFactory.playGame("HeartStone");
        Game game2 = GameFactory.playGame("Gwent");
        game1.play();
        game2.play();
    }
}

//Product
interface Game {
    void play();
}

//ConcreteProduct
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

//SimpleFactory
class GameFactory {
    private static final String HeartStone = "HeartStone";
    private static final String Gwent = "Gwent";

    public static Game playGame(String game) {
        Game myGame = null;
        switch (game) {
            case HeartStone:
                myGame = new HeartStone();
                break;
            case Gwent:
                myGame = new Gwent();
                break;
        }
        return myGame;
    }
}