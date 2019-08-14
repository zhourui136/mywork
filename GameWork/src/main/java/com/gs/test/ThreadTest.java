package com.gs.test;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-12 下午4:43
 */
public class ThreadTest{
    public synchronized void print(String str){
        notify();
        System.out.println(str);
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    class A implements Runnable{

        @Override
        public void run() {
            for(int i=1;i<100;i+=2){
                print("A"+i);
            }
        }
    }
    class B implements Runnable{

        @Override
        public void run() {
            for(int i=2;i<100;i+=2){
                print("B"+i);
            }
        }
    }
    public static void main(String[] args){
        ThreadTest test=new ThreadTest();
        A a=test.new A();
        B b=test.new B();
        new Thread(a).start();
        new Thread(b).start();
    }
}
