package com.code.leet.entiy;

import java.util.stream.IntStream;

public class LCArray {

    int[] arr;
    int curIndex;
    int maxSize;

    public LCArray() {
        arr = new int[1];
        curIndex = 0;
        maxSize = 1;
    }

    public void push_back(int n) {
        if(curIndex==maxSize){
            maxSize *= 2;
            int[] temp = new int[maxSize];
            if (curIndex >= 0) System.arraycopy(arr, 0, temp, 0, curIndex);
            arr = temp;
        }
        arr[curIndex] = n;
        curIndex++;
    }

    public void pop_back() {
        curIndex--;
    }

    public int size() {
        return curIndex;
    }

    public int index(int idx) {
        return arr[idx];
    }
}
