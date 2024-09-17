package com.scaler.lldjun24.multithreading.Mergesort;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> l = List.of(12,3,4,10,198,182);
        ExecutorService executorService = Executors.newCachedThreadPool();
        MergeSorter mergeSorter = new MergeSorter(l, executorService);
        Future<List<Integer>> listFuture = executorService.submit(mergeSorter);

        List<Integer> sortedList = listFuture.get();
        System.out.println(sortedList);

    }
}
