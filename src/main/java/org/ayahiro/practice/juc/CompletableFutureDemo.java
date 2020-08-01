package org.ayahiro.practice.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("runAsync()没有返回值");
        });
        completableFuture.get();

        //异步回调
        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync()有返回值");
            //int num = 10 / 0;
            return 1024;
        }).whenComplete((integer, throwable) -> {
            System.out.println("integer: " + integer);
            System.out.println("throwable: " + throwable);
        }).exceptionally(throwable -> {
            System.out.println("exception: " + throwable.getMessage());
            return 404;
        });
        System.out.println(completableFuture2.get());
    }
}
