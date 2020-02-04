package org.ayahiro.practice.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SourceNew {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() {
        lock.lock();
        try {
            //判断
            while (number != 0) {
                condition.await();
            }
            //干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //通知
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            while (number == 0) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class 生产者and消费者新 {
    public static void main(String[] args) {
        SourceNew source = new SourceNew();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                source.increment();
            }
        }, "生产者A").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                source.decrement();
            }
        }, "消费者B").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                source.increment();
            }
        }, "生产者C").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                source.decrement();
            }
        }, "消费者D").start();
    }
}
