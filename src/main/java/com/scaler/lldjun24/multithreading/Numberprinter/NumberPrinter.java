package com.scaler.lldjun24.multithreading.Numberprinter;

public class NumberPrinter implements Runnable{
    int num;
    NumberPrinter(int num)
    {
        this.num = num;
    }
    @Override
    public void run() {
        System.out.println("NumberPrinter started " + num + " , Printed by: " + Thread.currentThread().getName());

    }
}
