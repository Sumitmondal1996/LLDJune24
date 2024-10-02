package com.scaler.lldjun24.multithreading.Mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>> {
    private List<Integer> list;
    private ExecutorService executorService;
    public MergeSorter(List<Integer> list, ExecutorService executorService)
    {
        this.list = list;
        this.executorService = executorService;
    }
    @Override
    public List<Integer> call() throws Exception {
            if(list.size()<=1)
            {
                return  list;
            }      

            int n = list.size();
            int m = (n-1)/2;
            List<Integer> left = new ArrayList<>();
            for(int i=0; i<m+1; i++)
            {
                left.add(list.get(i));
            }
            List<Integer> right = new ArrayList<>();
            for(int i=m+1; i<n; i++)
            {
                right.add(list.get(i));
            }
            MergeSorter mergeSorterleft = new MergeSorter(left, executorService);
            MergeSorter mergeSorterright = new MergeSorter(right, executorService);
            Future<List<Integer>> leftsortfuture = executorService.submit(mergeSorterleft);
            Future<List<Integer>> righttsortfuture = executorService.submit(mergeSorterright);

            List<Integer> leftsort = leftsortfuture.get();
            List<Integer> rightsort = righttsortfuture.get();

            List<Integer> al = new ArrayList<>();

            int i =0, j=0;
            while(i<leftsort.size() && j<rightsort.size())
            {
                if(leftsort.get(i)<rightsort.get(j))
                {
                    al.add(leftsort.get(i));
                    i++;
                }
                else
                {
                    al.add(rightsort.get(j));
                    j++;
                }
            }

            while(i<leftsort.size() )
            {
                al.add(leftsort.get(i));
                i++;

            }
            while(j<rightsort.size())
            {
                al.add(rightsort.get(j));
                j++;

            }

            return al;


    }
}
