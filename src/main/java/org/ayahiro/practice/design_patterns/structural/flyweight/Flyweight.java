package org.ayahiro.practice.design_patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayahiro
 * @Description: 通过共享以便有效的支持大量小颗粒对象。
 * @Create: 2019/7/19
 */
public class Flyweight {
    public static void main(String[] args) {
        PieceFactory pieceFactory = new PieceFactory();
        Piece black1 = pieceFactory.getPiece("黑棋");
        black1.setPosition(3, 4);

        Piece write1 = pieceFactory.getPiece("白棋");
        write1.setPosition(5, 6);

        Piece black2 = pieceFactory.getPiece("黑棋");
        black2.setPosition(1, 2);

        Piece write2 = pieceFactory.getPiece("白棋");
        write2.setPosition(3, 7);

        Piece black3 = pieceFactory.getPiece("黑棋");
        black3.setPosition(4, 8);

        System.out.println(pieceFactory.getNumberOfPiecesType());
    }
}

//Flyweight
abstract class Piece {
    public abstract void setPosition(int x, int y);
}

//ConcreteFlyweight
class GoPieces extends Piece {
    private String type;

    public GoPieces(String type) {
        this.type = type;
    }

    @Override
    public void setPosition(int x, int y) {
        System.out.println(type + " 下在(" + x + "," + y + ")处。");
    }
}

//FlyweightFactory
class PieceFactory {
    private Map<String, Piece> pieceMap = new HashMap<>();

    public Piece getPiece(String key) {
        if (!pieceMap.containsKey(key)) {
            pieceMap.put(key, new GoPieces(key));
        }
        return pieceMap.get(key);
    }

    public int getNumberOfPiecesType() {
        return pieceMap.size();
    }
}