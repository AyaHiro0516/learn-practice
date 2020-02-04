package org.ayahiro.practice.juc;

/**
 * 实现一个线程对变量+1 另一个线程对变量-1 交替实现10轮，变量初始值为0
 *
 * 1 高内聚低耦合下， 线程操作资源类
 * 2 判断 干活 通知
 * 3 多线程交互中，必须要防止多线程的虚假唤醒，也即判断只用 while 不用 if
 */
class Source {
    private int number = 0;

    public synchronized void increment() throws InterruptedException {
        //判断
        while (number != 0) {
            this.wait();
        }
        //干活
        number++;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        //通知
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        while (number == 0) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        this.notifyAll();
    }
}

public class 生产者and消费者 {
    public static void main(String[] args) {
        Source source = new Source();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    source.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "生产者A").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    source.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "消费者B").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    source.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "生产者C").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    source.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "消费者D").start();
    }
}
