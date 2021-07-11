package com.code.leet.contest1;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.solve(new int[]{1,1,1,1,1,1}));
    }

    public int[] solve(int[] nums) {
        int size = nums.length;
        int[] arr = new int[size];
        Arrays.fill(arr, -1);
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            Queue<Integer> queue = map.getOrDefault(nums[i],new LinkedList<>());
            if(queue.size()==5){
                Queue<Integer> temp = new LinkedList<>();
                arr[i]=0;
                while (!queue.isEmpty()){
                    arr[i]+= queue.peek();
                    temp.add(queue.poll());
                }
                queue = temp;
                queue.poll();
            }
            queue.add(i);
            map.put(nums[i],queue);
        }
        return arr;
    }
}
