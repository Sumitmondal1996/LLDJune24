package com.scaler.lldjun24.multithreading.producerconsumer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{

    private Queue<Object> queue;
    private int max_size;
    Semaphore producerSemaphore;
    Semaphore consumerSemaphore;
    String name;
    public Producer(Queue<Object> queue, int max_size, Semaphore producerSemaphore, Semaphore consumerSemaphore, String name) {
        this.queue = queue;
        this.max_size = max_size;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
        this.name = name;

    }
    @Override
    public void run() {
        while(true)
        {
            try {
                producerSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(queue.size() < max_size)
            {
                queue.add(new Object());
                System.out.println(name + " produced " + queue.size() + " objects");
            }
            consumerSemaphore.release();
        }

    }
}
