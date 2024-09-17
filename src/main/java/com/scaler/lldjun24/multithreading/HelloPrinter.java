package com.scaler.lldjun24.multithreading;

public class HelloPrinter  implements Runnable{
    public void run() {
        System.out.println("Hello Printer " + Thread.currentThread().getName());
    }
}
