package org.ayahiro.practice.design_patterns.behavioral.interpreter;

/**
 * @Author ayahiro
 * @Description: 给定一个语言, 定义它的文法的一种表示，并定义一个解释器, 该解释器使用该表示来解释语言中的句子。
 * @Create: 2019/7/25
 */
public class Interpreter {
    public static void main(String[] args) {
        String word = "好好学习，天天向上!";
        Expreeion expreeion = new BaiduExpreeion();
        Expreeion expreeion2 = new YouDaoExpreeion();
        Expreeion expreeion3 = new AyaHiroExpreeion();
        expreeion.interpert(word);
        expreeion2.interpert(word);
        expreeion3.interpert(word);
    }
}

interface Expreeion {
    void interpert(String word);
}

class BaiduExpreeion implements Expreeion {
    String str = "好好学习，天天向上!";

    @Override
    public void interpert(String word) {
        if (str.equals(word)) {
            System.out.println("百度翻译：" + word + " 的英文是  Study hard and keep up!");
        }
    }
}

class YouDaoExpreeion implements Expreeion {
    String str = "好好学习，天天向上!";

    @Override
    public void interpert(String word) {
        if (str.equals(word)) {
            System.out.println("有道翻译：" + word + " 的英文是  study hard and make progress every day！");
        }
    }
}

class AyaHiroExpreeion implements Expreeion {
    String str = "好好学习，天天向上!";

    @Override
    public void interpert(String word) {
        if (str.equals(word)) {
            System.out.println("xuwujing翻译：" + word + " 的英文是  Good good study, day day up！");
        }
    }
}
