package org.ayahiro.practice.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ParkingSpace{
    private int number=3;
    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();
    public void park(){
        lock.lock();
        try {
            while(number==0){
                condition.await();
            }
            System.out.println(Thread.currentThread().getName()+"抢到了车位, 还剩下"+(--number)+"个车位");
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void leave(){
        lock.lock();
        try {
            while(number==3){
                condition.await();
            }
            System.out.println(Thread.currentThread().getName()+"归还了车位, 还剩下"+(++number)+"个车位");
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到了车位");
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName()+"离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
        ParkingSpace parkingSpace=new ParkingSpace();
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                parkingSpace.park();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                parkingSpace.leave();
            }, String.valueOf(i)).start();
        }
    }
}
