package com.blankcat.java.module.ch05_thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zjf
 * @Date: 2018/5/30
 * @Desc
 */
public class TestABCAlternate {
    public static void main(String[] args) {
        AlternateDemo demo = new AlternateDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){
                    demo.loopA();
                }

            }
        },"A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){
                    demo.loopB();
                }

            }
        },"B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){
                    demo.loopC();
                }

            }
        },"C").start();


    }
}

class AlternateDemo {
    private int number=1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void loopA(){
        lock.lock();
        try {
            //1判断
            if (number!=1){
                condition1.await();
            }
            //2打印
            System.out.print(Thread.currentThread().getName());
            //3唤醒
            number=2;
            condition2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


    }
    public void loopB(){
        lock.lock();
        try {
            //1判断
            if(number!=2){
                condition2.await();
            }
            //2打印
            System.out.print(Thread.currentThread().getName());
            //3唤醒
            number = 3;
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
    public void loopC(){
        lock.lock();
        try {
            //1判断
            if(number!=3){
                condition3.await();
            }
            //2打印
            System.out.print(Thread.currentThread().getName());
            //3唤醒
            number = 1;
            condition1.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }


}
