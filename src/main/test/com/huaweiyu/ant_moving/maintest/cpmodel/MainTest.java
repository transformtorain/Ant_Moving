package com.huaweiyu.ant_moving.maintest.cpmodel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.*;

/**
 * @ClassName MainTest
 * @Description
 * @Author zaizai
 * @Date 2021/5/20 7:16 下午
 */
public class MainTest {

    public static void main(String[] args) {
        final List<Object> productList = new ArrayList<Object>();
        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition consumerCondition = reentrantLock.newCondition();
        final Condition productorCondition = reentrantLock.newCondition();
        for (int i = 0; i <3 ; i++) {
            new Thread(new Runnable() {
                public void run() {
                    Productor productor = new Productor(productList, reentrantLock, consumerCondition, productorCondition, 3);
                    productor.product();
                }
            }).start();
        }

        for (int i = 0; i <3 ; i++) {
            new Thread(new Runnable() {
                public void run() {
                    Consumer consumer = new Consumer(productList, reentrantLock, consumerCondition, productorCondition, 3);
                    consumer.consumer();
                }
            }).start();
        }


    }


}
