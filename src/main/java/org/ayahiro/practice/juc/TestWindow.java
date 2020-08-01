package org.ayahiro.practice.juc;

class Window extends Thread{
    static int ticket = 100;//得写成静态的
    public void run() {
        while(true) {
            if(ticket > 0) {
                System.out.println(Thread.currentThread().getName()+"售票，票号为:"+ticket--);
            }else {
                break;
            }
        }
    }
}

public class TestWindow {
    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();
        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");
        w1.start();
        w2.start();
        w3.start();
    }
}

//使用实现Runnable接口方式：售票
//class Window implements Runnable{
//    int ticket = 100;
//    public void run() {
//        while(true) {
//            if(ticket > 0) {
//                System.out.println(Thread.currentThread().getName()+"售票，票号为:"+ticket--);
//            }else {
//                break;
//            }
//        }
//    }
//}
//
//public class TestWindow {
//    public static void main(String[] args) {
//        Window w = new Window();
//        Thread t1 = new Thread(w);
//        Thread t2 = new Thread(w);
//        Thread t3 = new Thread(w);
//
//        t1.setName("窗口1");
//        t2.setName("窗口1");
//        t3.setName("窗口1");
//        t1.start();
//        t2.start();
//        t3.start();
//    }
//}
