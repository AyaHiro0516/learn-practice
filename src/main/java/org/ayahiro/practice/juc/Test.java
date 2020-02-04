package org.ayahiro.practice.juc;

class S{
    public void print(){
        try {
            Thread.sleep(4000);
            System.out.println("come in S");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
public class Test {
    public static void main(String[] args) {
        S s=new S();
        new Thread(()->{s.print();},"A").start();

        System.out.println("main");
    }
}
