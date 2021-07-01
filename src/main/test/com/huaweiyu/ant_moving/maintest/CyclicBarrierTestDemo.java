package com.huaweiyu.ant_moving.maintest;

import java.util.Vector;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @ClassName CyclicBarrierTestDemo
 * @Description
 * @Author zaizai
 * @Date 2021/6/24 1:43 下午
 */
public class CyclicBarrierTestDemo {

    static Vector<Object> pos = new Vector<>();

    static Vector<Object> dos = new Vector<>();

    static Executor executor = Executors.newFixedThreadPool(1);

    static Executor executor1 = Executors.newFixedThreadPool(1);

    static Executor executor2 = Executors.newFixedThreadPool(1);

    static int pNum = 0;

    static int dNum = 0;

    static final CyclicBarrier barrier = new CyclicBarrier(2, ()->{executor.execute(()->check());});

    private static void check() {
        Object p = pos.remove(0);
        Object d = dos.remove(0);
        // 对账、保存
        System.out.println("====对账 " + p + " " + d + "======保存====");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            executor1.execute(() -> {
                pos.add(pNum++);
                System.out.println("查询源账单");
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });

            executor2.execute(() -> {
                dos.add(dNum++);
                System.out.println("查询对账单");
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }

    }


}
