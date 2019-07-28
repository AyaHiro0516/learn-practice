package org.ayahiro.practice.design_patterns.behavioral.memento;

/**
 * @Author ayahiro
 * @Description: 备忘录对象是一个用来存储另外一个对象内部状态的快照的对象。
 * 备忘录模式的用意是在不破坏封装的条件下，将一个对象的状态捉住，并外部化，存储起来，从而可以在将来合适的时候把这个对象还原到存储起来的状态。
 * @Create: 2019/7/27
 */
public class Memento {
    public static void main(String[] args) {
        Chessman chessman = new Chessman("黑子", 1, 1);
        chessman.show();

        MementoCaretaker caretaker = new MementoCaretaker();
        caretaker.setMemento(chessman.save());

        chessman.setPosition(2, 3);
        chessman.show();

        chessman.restore(caretaker.getMemento());
        chessman.show();
    }
}

//Originator
class Chessman {
    private String label;
    private int x;
    private int y;

    public Chessman(String label, int x, int y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //保存状态
    public ChessmanMemento save() {
        return new ChessmanMemento(label, x, y);
    }

    //恢复状态
    public void restore(ChessmanMemento memento) {
        this.label = memento.getLabel();
        this.x = memento.getX();
        this.y = memento.getY();
    }

    public void show() {
        System.out.println(String.format("棋子<%s>：当前位置为：<%d, %d>", label, x, y));
    }
}

//Memento
class ChessmanMemento {
    private String label;
    private int x;
    private int y;

    public ChessmanMemento(String label, int x, int y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    public String getLabel() {
        return label;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

//Caretaker
class MementoCaretaker {
    private ChessmanMemento memento;

    public ChessmanMemento getMemento() {
        return memento;
    }

    public void setMemento(ChessmanMemento memento) {
        this.memento = memento;
    }
}