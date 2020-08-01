package org.ayahiro.practice.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyBlockQueue<T> {
    private List<T> queue = new ArrayList<>();
    private int capacity;
    protected int size = 0;
    private Lock lock = new ReentrantLock();
    private Condition isFull = lock.newCondition();
    private Condition isNull = lock.newCondition();

    public MyBlockQueue(int capacity) {
        this.capacity = capacity;
    }

    public void push(T data) {
        lock.lock();
        try {
            while (size >= capacity) {
                System.out.println("队列满了");
                isFull.await();
            }
            ++size;
            queue.add(data);
            isNull.signal();
        } catch (Exception e) {
            isFull.signal();
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T poll() {
        lock.lock();
        T data = null;
        try {
            while (size == 0) {
                System.out.println("队列空了");
                isNull.await();
            }
            --size;
            data = queue.get(0);
            queue.remove(0);
            isFull.signal();
        } catch (Exception e) {
            isNull.signal();
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return data;
    }
}

public class 手写阻塞队列 {
    public static void main(String[] args) {
        MyBlockQueue queue = new MyBlockQueue(5);
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                queue.push(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("塞入：" + i + "，当前容量：" + queue.size);
            }
        }, "AA").start();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费：" + queue.poll() + "，当前容量：" + queue.size);
            }
        }, "BB").start();
    }
}
