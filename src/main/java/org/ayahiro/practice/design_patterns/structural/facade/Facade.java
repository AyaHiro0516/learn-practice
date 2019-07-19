package org.ayahiro.practice.design_patterns.structural.facade;

/**
 * @Author ayahiro
 * @Description: 为子系统中的一组接口提供一个一致的界面， 外观模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。
 * @Create: 2019/7/18
 */
public class Facade {
    public static void main(String[] args) {
        Fund fund = new Fund();
        fund.buyFund();
        fund.sellFund();
    }
}

//Facade
class Fund {
    private Stock stock;
    private NationalDebt nationalDebt;
    private Realty realty;

    public Fund() {
        stock = new Stock();
        nationalDebt = new NationalDebt();
        realty = new Realty();
    }

    public void buyFund() {
        stock.buy();
        nationalDebt.buy();
        realty.buy();
    }

    public void sellFund() {
        stock.sell();
        nationalDebt.sell();
        realty.sell();
    }
}

//SubSystem
class Stock {
    public void sell() {
        System.out.println("卖股票");
    }

    public void buy() {
        System.out.println("买股票");
    }
}

class NationalDebt {
    public void sell() {
        System.out.println("卖国债");
    }

    public void buy() {
        System.out.println("买国债");
    }
}

class Realty {
    public void sell() {
        System.out.println("卖房产");
    }

    public void buy() {
        System.out.println("买房产");
    }
}