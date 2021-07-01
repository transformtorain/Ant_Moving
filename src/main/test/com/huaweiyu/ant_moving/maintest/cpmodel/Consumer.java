package com.huaweiyu.ant_moving.maintest.cpmodel;

import java.util.List;
import java.util.concurrent.locks.*;

/**
 * @ClassName Consumer
 * @Description
 * @Author zaizai
 * @Date 2021/5/20 5:32 下午
 */
public class Consumer {

    private List<Object> productList;

    private ReentrantLock reentrantLock;

    private Condition consumerCondition, productCondition;

    private int consumerNum;


    public Consumer(List<Object> productList, ReentrantLock reentrantLock, Condition consumerCondition, Condition productCondition, int consumerNum) {
        this.productList = productList;
        this.reentrantLock = reentrantLock;
        this.consumerCondition = consumerCondition;
        this.productCondition = productCondition;
        this.consumerNum = consumerNum;
    }

    public void consumer() {
        while (true) {
            try {
                reentrantLock.lock();
                if (productList.size() <= 0) {
                    consumerCondition.await();
                    productCondition.signalAll();
                }
            } catch (Exception e) {
                reentrantLock.unlock();
            }
            if (productList.size() < consumerNum) {
                synchronized (productList) {
                    if (productList.size() > 0) {
                        System.out.println("消费产品，马上没了");
                        productList.remove(0);
                    }
                }
            } else {
                System.out.println("消费产品");
                productList.remove(0);
            }
        }

    }


}
