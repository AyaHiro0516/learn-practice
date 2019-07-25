package org.ayahiro.practice.design_patterns.behavioral.mediator;

/**
 * @Author ayahiro
 * @Description: 包装了一系列对象相互作用的方式，使得这些对象不必相互明显作用，从而使它们可以松散偶合。
 * 当某些对象之间的作用发生改变时，不会立即影响其他的一些对象之间的作用，保证这些作用可以彼此独立的变化。
 * @Create: 2019/7/25
 */
public class Mediator {
    public static void main(String[] args) {
        Alipay alipay = new Alipay();

        Buyer buyer = new Buyer(alipay);
        Seller seller = new Seller(alipay);

        alipay.setBuyer(buyer);
        alipay.setSeller(seller);

        buyer.transfer(999);
    }
}

//Mediator
abstract class MobilePayment {
    public abstract void transfer(Account account, double amount);
}

//Colleague
abstract class Account {
    protected MobilePayment mobilePayment;

    public Account(MobilePayment mobilePayment) {
        this.mobilePayment = mobilePayment;
    }
}

//ConcreteColleague
class Seller extends Account {
    public Seller(MobilePayment mobilePayment) {
        super(mobilePayment);
    }

    public void transfer(double amount) {
        mobilePayment.transfer(this, amount);
    }

    public void notify(double amount) {
        System.out.println("卖家收到 " + amount + " 元");
    }
}

class Buyer extends Account {
    public Buyer(MobilePayment mobilePayment) {
        super(mobilePayment);
    }

    public void transfer(double amount) {
        mobilePayment.transfer(this, amount);
    }

    public void notify(double amount) {
        System.out.println("买家收到 " + amount + " 元");
    }
}

//ConcreteMediator
class Alipay extends MobilePayment {
    private Buyer buyer;
    private Seller seller;

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    @Override
    public void transfer(Account account, double amount) {
        if (account instanceof Buyer) {
            seller.notify(amount);
        } else {
            buyer.notify(amount);
        }
    }
}



