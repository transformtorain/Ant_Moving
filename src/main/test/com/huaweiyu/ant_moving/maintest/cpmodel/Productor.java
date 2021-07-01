package com.huaweiyu.ant_moving.maintest.cpmodel;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Productor
 * @Description
 * @Author zaizai
 * @Date 2021/5/20 5:52 下午
 */
public class Productor {

    private List<Object> productList;

    private ReentrantLock productorReentrantLock;

    private ReentrantLock consumerReentrantLock;

    private Condition consumerCondition, productCondition;

    private int productorNum;

    public Productor(List<Object> productList, ReentrantLock productorReentrantLock, ReentrantLock consumerReentrantLock, Condition consumerCondition, Condition productCondition, int productorNum) {
        this.productList = productList;
        this.productorReentrantLock = productorReentrantLock;
        this.consumerReentrantLock = consumerReentrantLock;
        this.consumerCondition = consumerCondition;
        this.productCondition = productCondition;
        this.productorNum = productorNum;
    }

    public void product() {
        while (true) {
            try {
                reentrantLock.lock();
                if (productList.size() > 11) {
                    productCondition.await();
                    consumerCondition.signalAll();
                } else {
                    if (productList.size() > 0) {
                        consumerCondition.signalAll();
                    }
                }
            } catch (Exception e) {
                reentrantLock.unlock();
            }
            if (productList.size() > 12 - productorNum) {
                synchronized (productList) {
                    if (productList.size() <= 11) {
                        System.out.println("生产产品，快满了");
                        productList.add(0);
                    }
                }
            } else {
                System.out.println("生产产品");
                productList.add(0);
            }

        }
    }


}
