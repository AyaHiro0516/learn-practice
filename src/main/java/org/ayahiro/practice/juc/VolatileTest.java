package org.ayahiro.practice.juc;

import java.util.concurrent.atomic.AtomicInteger;

class MySource {
    volatile int number = 0;

    public void addTo60() {
        number = 60;
    }

    public void addPlusPlus() {
        number++;
    }

    AtomicInteger atomicInteger=new AtomicInteger();
    public void addMyatomicInteger(){
        atomicInteger.getAndIncrement();
    }
}

public class VolatileTest {
    public static void main(String[] args) throws InterruptedException {
        Test1();
        //Test2();
    }

    //volatile不保证原子性
    public static void Test1() {
        MySource mySource = new MySource();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    mySource.addPlusPlus();
                    mySource.addMyatomicInteger();
                }
            }, String.valueOf(i)).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(mySource.number);
        System.out.println(mySource.atomicInteger);
    }

    //volatile保证可见性
    public static void Test2() {
        MySource mySource = new MySource();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " come in");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mySource.addTo60();
            System.out.println(Thread.currentThread().getName() + " update data value: " + mySource.number);
        }, "AAA").start();

        while (mySource.number == 0) {
            //main线程一直等待，因为没有线程通知main number被改了
        }
        System.out.println("mission is over");
    }
}
