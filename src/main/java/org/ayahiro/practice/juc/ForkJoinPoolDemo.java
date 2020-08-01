package org.ayahiro.practice.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

class CalculateTask extends RecursiveTask<Integer> {
    private final int ADJUST_VALUE = 10;
    private int begin;
    private int end;
    private int result;

    public CalculateTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if ((end - begin) <= ADJUST_VALUE) {
            for (int i = begin; i <= end; i++) {
                result += i;
            }
        } else {
            int mid = (end + begin) / 2;
            CalculateTask task1 = new CalculateTask(begin, mid);
            CalculateTask task2 = new CalculateTask(mid + 1, end);
            task1.fork();
            task2.fork();
            result = task1.join() + task2.join();
        }
        return result;
    }
}

public class ForkJoinPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CalculateTask calculateTask = new CalculateTask(0, 100);
        ForkJoinPool threadPool = new ForkJoinPool();
        ForkJoinTask<Integer> result = threadPool.submit(calculateTask);
        System.out.println(result.get());
        threadPool.shutdown();
    }
}
