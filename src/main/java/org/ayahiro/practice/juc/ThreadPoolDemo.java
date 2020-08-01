package org.ayahiro.practice.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        //ExecutorService threadPool= Executors.newFixedThreadPool(5);
        //ExecutorService threadPool= Executors.newSingleThreadExecutor();
        ExecutorService threadPool= Executors.newCachedThreadPool();

        for (int i = 0; i <10 ; i++) {
            //Thread.sleep(2);
            threadPool.execute(()->{
                System.out.println(Thread.currentThread().getName()+"办理业务");
            });
        }
        threadPool.shutdown();
    }
}
