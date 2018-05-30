package com.blankcat.java.module.ch05_thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zjf
 * @Date: 2018/5/30
 * @Desc
 * http://www.cnblogs.com/baizhanshi/p/6428810.html
 */
public class Test1234lternate {
    public static void main(String[] args) {
        Alternate alt = new Alternate();
        List<Condition>  list = alt.getSet();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){
//                    alt.loop1();
                    alt.loop(list.get(0),list.get(1),1);
                }

            }
        },"1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){
//                    alt.loop2();
                    alt.loop(list.get(1),list.get(2),2);
                }

            }
        },"2").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){
//                    alt.loop3();
                    alt.loop(list.get(2),list.get(3),3);
                }

            }
        },"3").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){
//                    alt.loop4();
                    alt.loop(list.get(3),list.get(0),1);
                }

            }
        },"4").start();
    }
}

class Alternate{
    private int number = 1;
    private int maxSize = 4;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition() ;
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    private Condition condition4 = lock.newCondition();

//     private Set<Condition> set = new HashSet<>();
     private List<Condition> set = new ArrayList<>();
     public Alternate(){
         set.add(condition1);
         set.add(condition2);
         set.add(condition3);
         set.add(condition4);
     }
     public List<Condition>  getSet(){
         return set;
     }


    /**
     *
     * @param cur 当前
     * @param next 下一个
     * @param index
     */
    public void loop(Condition cur,Condition next,int index){
        lock.lock();
        try {
            if(number!=index){
                cur.await();
            }
            System.out.print(Thread.currentThread().getName());
            if(index==3){
                number = 1;
            }else {
                number=index+1;
            }
            next.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


//
//    public void loop1(){
//        lock.lock();
//        try {
//            if(number!=1){
//                condition1.await();
//            }
//            System.out.print(Thread.currentThread().getName());
//            number=2;
//            condition2.signal();
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            lock.unlock();
//        }
//
//    }
//
//    public void loop2(){
//        lock.lock();
//        try {
//            if(number!=2){
//                condition2.await();
//            }
//            System.out.print(Thread.currentThread().getName());
//            number=3;
//            condition3.signal();
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            lock.unlock();
//        }
//    }
//
//    public void loop3(){
//        lock.lock();
//        try {
//            if(number!=3){
//                condition3.await();
//            }
//            System.out.print(Thread.currentThread().getName());
//            number = 4;
//            condition4.signal();
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            lock.unlock();
//        }
//    }
//
//    public void loop4(){
//        lock.lock();
//        try {
//            if(number!=4){
//                condition4.await();
//            }
//            System.out.print(Thread.currentThread().getName());
//            number = 1;
//            condition1.signal();
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            lock.unlock();
//        }
//    }


}