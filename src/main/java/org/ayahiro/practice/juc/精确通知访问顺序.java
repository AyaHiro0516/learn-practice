package org.ayahiro.practice.juc;

import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现线程A打印5次 线程B打印10次 线程C打印15次 顺序打印 连续10轮
 * 4 修改标志位
 */
class ShareSource {
    private int number = 1; //标志位
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void print(int n) {
        int waitState=0, nextState=0;
        Condition waitCondition=lock.newCondition(), nextCondition=lock.newCondition();
        switch (n){
            case 5: waitState=1; nextState=2;waitCondition=condition1;nextCondition=condition2; break;
            case 10:  waitState=2;nextState=3;waitCondition=condition2;nextCondition=condition3; break;
            case 15:  waitState=3; nextState=1;waitCondition=condition3;nextCondition=condition1; break;
        }
        lock.lock();
        try {
            while (number != waitState) {
                waitCondition.await();
            }
            for (int i = 1; i <= n; i++) {
                System.out.println(Thread.currentThread().getName() + "打印：" + i);
            }
            number=nextState;
            nextCondition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class 精确通知访问顺序 {
    public static void main(String[] args) {
        ShareSource shareSource=new ShareSource();
        new Thread(()->{
            for (int i=1; i<=10; i++) shareSource.print(5);
        }, "A").start();
        new Thread(()->{
            for (int i=1; i<=10; i++) shareSource.print(10);
        }, "B").start();
        new Thread(()->{
            for (int i=1; i<=10; i++) shareSource.print(15);
        }, "C").start();
    }
}
