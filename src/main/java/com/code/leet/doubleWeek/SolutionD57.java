package com.code.leet.doubleWeek;

import java.util.*;

public class SolutionD57 {
    public static void main(String[] args) {
        SolutionD57 solution = new SolutionD57();
//        System.out.println(solution.smallestChair(new int[][]{{33889, 98676}, {80071, 89737}, {44118, 52565}, {52992, 84310}, {78492, 88209},
//                {21695, 67063}, {84622, 95452}, {98048, 98856}, {98411, 99433}, {55333, 56548}, {65375, 88566}, {55011, 62821},
//                {48548, 48656}, {87396, 94825}, {55273, 81868}, {75629, 91467}}, 6));

        solution.splitPainting(new int[][]{{1, 7, 9}, {6, 8, 15}, {8, 10, 7}});
    }

    public boolean areOccurrencesEqual(String s) {
        int[] arr = new int[26];
        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }
        int num = arr[s.charAt(0) - 'a'];
        for (int j : arr) {
            if (j > 0 && j != num) {
                return false;
            }
        }
        return true;
    }

    public int smallestChair(int[][] times, int targetFriend) {
        int[] target = times[targetFriend];
        Arrays.sort(times, Comparator.comparingInt(a -> a[0]));
        int size = 0;
        for (int i = 0; i < times.length; i++) {
            if (times[i][0] == target[0]) {
                size = i;
                break;
            }
        }
        int[] arr = new int[size + 1];
        List<Integer> use = new ArrayList<>();
        int index = 0;
        int start = times[0][0];
        for (int[] time : times) {
            for (int i = 0; i < index; i++) {
                if (arr[i] > 0) {
                    arr[i] -= time[0] - start;
                    if (arr[i] <= 0) {
                        use.add(i);
                        Collections.sort(use);
                    }
                }
            }
            start = time[0];
            if (time[0] == target[0]) {
                return use.size() > 0 ? use.get(0) : index;
            }
            if (use.size() > 0) {
                arr[use.get(0)] = time[1] - time[0];
                use.remove(0);
            } else {
                arr[index] = time[1] - time[0];
                index++;
            }
        }
        return 0;
    }

    public List<List<Long>> splitPainting(int[][] segments) {
        Arrays.sort(segments, Comparator.comparingInt(a -> a[0]));
        int start = segments[0][0];
        Arrays.sort(segments, Comparator.comparingInt(a -> a[1]));
        int end = segments[segments.length - 1][1];
        List<Integer>[] arr = new List[end - start];
        for (int[] segment : segments) {
            for (int i = segment[0]; i < segment[1]; i++) {
                if (arr[i - start] == null) {
                    arr[i - start] = new ArrayList<>();
                }
                arr[i - start].add(segment[2]);
            }
        }
        List<List<Long>> result = new ArrayList<>();
        int index = 0;
        long sum = 0;
        for (int i = 0; i < arr[0].size(); i++) {
            sum += arr[0].get(i);
        }
        Long s = (long) start;
        for (int i = 0; i < end - start; i++) {
            boolean bl = false;
            long temp = 0;
            for (int j = 0; j < arr[i].size(); j++) {
                if (arr[i].size() == arr[index].size()) {
                    if (!bl && !arr[i].get(j).equals(arr[index].get(j))) {
                        bl = true;
                    }
                }else{
                    bl = true;
                }
                temp += arr[i].get(j);
            }
            if (bl) {
                result.add(Arrays.asList(s + index, s + i, sum));
                index = i;
                sum = temp;
            }
        }
        result.add(Arrays.asList(s + index, (long) end, sum));
        return result;
    }
}
