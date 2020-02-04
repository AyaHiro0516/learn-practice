package org.ayahiro.practice.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket {
    private int number = 30;
    private Lock lock = new ReentrantLock();

    public void sellTickets() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "\t卖出第:" + (number--) + "张，还剩" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class 企业级多线程模板 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(() -> {
            for (int i = 1; i <= 40; i++) ticket.sellTickets();
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i <= 40; i++) ticket.sellTickets();
        }, "B").start();
        new Thread(() -> {
            for (int i = 1; i <= 40; i++) ticket.sellTickets();
        }, "C").start();
    }
}
