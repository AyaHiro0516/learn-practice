package org.ayahiro.practice.design_patterns.structural.adapter;

/**
 * @Author ayahiro
 * @Description: 将某个类的接口转换成客户端期望的另一个接口表示。适配器模式可以消除由于接口不匹配所造成的类兼容性问题。
 * @Create: 2019/7/17
 */
public class Adapter {
    public static void main(String[] args) {
        Chinese chinese = new ChineseSpeaker();
        chinese.speakChinese();

        Chinese chinese1 = new JapaneseToChineseTranslatorByInterface(new JapaneseSpeaker());
        chinese1.speakChinese();

        Chinese chinese2 = new JapaneseToChineseTranslatorByClass();
        chinese2.speakChinese();
    }
}

//Target
interface Chinese {
    void speakChinese();
}

//ConcreteTarget
class ChineseSpeaker implements Chinese {
    @Override
    public void speakChinese() {
        System.out.println("中国人说中文");
    }
}

//Adaptee
class JapaneseSpeaker {
    public void speakJapanese() {
        System.out.println("日本人说日语");
    }
}

//Adaptor by interface
class JapaneseToChineseTranslatorByInterface implements Chinese {
    private JapaneseSpeaker japaneseSpeaker;

    public JapaneseToChineseTranslatorByInterface(JapaneseSpeaker japaneseSpeaker) {
        this.japaneseSpeaker = japaneseSpeaker;
    }

    @Override
    public void speakChinese() {
        japaneseSpeaker.speakJapanese();
        System.out.println("经过翻译，中国人听得懂");
    }
}

//Adaptor by class
class JapaneseToChineseTranslatorByClass extends JapaneseSpeaker implements Chinese {
    @Override
    public void speakChinese() {
        super.speakJapanese();
        System.out.println("经过翻译，中国人听得懂");
    }
}
