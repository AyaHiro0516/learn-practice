package org.ayahiro.practice.design_patterns.behavioral.state;

/**
 * @Author ayahiro
 * @Description: 让一个对象在其内部状态改变的时候，其行为也随之改变。
 * 状态模式需要对每一个系统可能获取的状态创立一个状态类的子类。当系统的状态变化时，系统便改变所选的子类。
 * @Create: 2019/7/27
 */
public class State {
    public static void main(String[] args) {
        MealTime mealTime = new MealTime();
        mealTime.setHour(7);
        mealTime.eat();
        mealTime.setHour(10);
        mealTime.eat();
        mealTime.setHour(15);
        mealTime.eat();
        mealTime.setHour(18);
        mealTime.eat();
        mealTime.setHour(23);
        mealTime.eat();
    }
}

//State
abstract class Period {
    abstract void eat(MealTime mealTime);
}

//ConcreteState
class Morning extends Period {
    @Override
    void eat(MealTime mealTime) {
        if (mealTime.hour > 6 && mealTime.hour <= 9) {
            System.out.println("现在是早上，可以吃包子喝豆浆");
        } else {
            mealTime.setCurrent(new Noon());
            mealTime.eat();
        }
    }
}

class Noon extends Period {
    @Override
    void eat(MealTime mealTime) {
        if (mealTime.hour > 9 && mealTime.hour <= 13) {
            System.out.println("快到中午了，可以吃大碗宽面");
        } else {
            mealTime.setCurrent(new Afternoon());
            mealTime.eat();
        }
    }
}

class Afternoon extends Period {
    @Override
    void eat(MealTime mealTime) {
        if (mealTime.hour > 13 && mealTime.hour <= 17) {
            System.out.println("现在是下午，给阿姨倒杯卡布奇诺");
        } else {
            mealTime.setCurrent(new Evening());
            mealTime.eat();
        }
    }
}

class Evening extends Period {
    @Override
    void eat(MealTime mealTime) {
        if (mealTime.hour > 17 && mealTime.hour <= 22) {
            System.out.println("现在是晚上，可以吃葱油拌面");
        } else {
            System.out.println("想吃夜宵？不怕长膘？");
        }
    }
}

//Context
class MealTime {
    private Period current;
    protected double hour;

    public MealTime() {
        current = new Morning();
    }

    public void setCurrent(Period current) {
        this.current = current;
    }

    public double getHour() {
        return hour;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }

    public void eat() {
        current.eat(this);
    }
}