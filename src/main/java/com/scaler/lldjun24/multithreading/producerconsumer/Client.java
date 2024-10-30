package com.scaler.lldjun24.multithreading.producerconsumer;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        Queue queue = new ConcurrentLinkedQueue(); // by default it will be synchronized
        int max_size =6;

        Semaphore productsemaphore = new Semaphore(max_size); // how many thread is allowed
        Semaphore consumersemaphore = new Semaphore(0);

        Producer p1 = new Producer(queue, max_size, productsemaphore, consumersemaphore, "p1");
        Producer p2 = new Producer(queue, max_size, productsemaphore, consumersemaphore, "p2");
        Consumer c1 = new Consumer(queue, max_size, productsemaphore, consumersemaphore, "c1");
        Consumer c2 = new Consumer(queue, max_size, productsemaphore, consumersemaphore, "c2");

//        p1.run();
//        c1.run();

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(c1);
        Thread t3 = new Thread(p2);
        Thread t4 = new Thread(c2);
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
