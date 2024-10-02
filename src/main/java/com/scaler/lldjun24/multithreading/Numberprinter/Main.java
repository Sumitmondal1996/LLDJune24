package com.scaler.lldjun24.multithreading.Numberprinter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World "+ Thread.currentThread().getName()); // to print the current thread name
        Helper.dosomething();
        HelloPrinter helloPrinter= new HelloPrinter(); // Create a task
        Thread thread = new Thread(helloPrinter); // Create a thread & assign the task
        thread.start();

        /*for(int i=0; i<=99; i++)
        {
            NumberPrinter numberPrinter = new NumberPrinter(i);
            Thread thread2 = new Thread(numberPrinter);
            thread2.start();
        }*/

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0; i<=99; i++)
        {
            if(  i==50 || i==99)
            {
                System.out.println("Debug");
            }
            NumberPrinter numberPrinter = new NumberPrinter(i);
            executorService.execute(numberPrinter);

        }
        //executorService.shutdown();

        /*

         */
    }
}
