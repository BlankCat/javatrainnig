package com.blankcat.java.module.ch05_thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author zjf
 * @Date: 2018/5/30
 * @Desc
 * https://www.cnblogs.com/baizhanshi/p/6425209.html
 *  一、创建执行线程的方式
 *  三：实现 Callable 接口。
 *  相较于实现 Runnable 接口的方式，
 *  方法可以有返回值，
 *  并且可以抛出异常。
 *
 *   二、执行 Callable 方式，
 *   需要 FutureTask 实现类的支持，
 *   用于接收运算结果。
 *   FutureTask 是  Future 接口的实现类
 *
 */
public class TestCallable {
    public static void main(String[] args)  {
        MyCallable callable = new MyCallable();
        FutureTask<Integer> result = new FutureTask<>(callable);
        new Thread(result).start();
      try {
          //FutureTask 可用于 闭锁 类似于CountDownLatch的作用，在所有的线程没有执行完成之后这里是不会执行的
         int sum = result.get();
          System.out.println(sum);
      }catch (InterruptedException | ExecutionException e){
          e.printStackTrace();
      }
    }
}


class MyCallable implements Callable<Integer>{
    @Override
    public Integer call() {
        int sum = 0;
        for (int i=1;i<10;i++){
            sum = sum+i;
        }
        return sum;
    }
}