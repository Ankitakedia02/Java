package com.test.practice.demo;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow {

    public void findMaxSlidingWindow(int arr[], int n, int k){

        long t1 = System.currentTimeMillis();
        Deque<Integer> deque = new LinkedList<Integer>();  // Create a Deque

        for (int i = 0; i < n; i++) {

            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()])
                deque.removeLast();
            deque.addLast(i);

            if (i >= k && deque.peekFirst() <= i - k)
                deque.removeFirst();

            if (i >= k - 1)
                System.out.print(arr[deque.peekFirst()] + " ");
        }
        System.out.println();
        System.out.println(System.currentTimeMillis() - t1);

    }
}
