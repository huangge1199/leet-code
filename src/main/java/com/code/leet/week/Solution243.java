package com.code.leet.week;

import java.util.*;

public class Solution243 {

    public static void main(String[] args) {
        Solution243 solution = new Solution243();
//        //2,2,0,2,1,2
//        System.out.println(solution.assignTasks(new int[]{3, 3, 2}, new int[]{1, 2, 3, 2, 1, 2}));
        System.out.println(solution.minSkips(new int[]{7,3,5,5},2,10));
    }

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return trans(firstWord) + trans(secondWord) == trans(targetWord);
    }

    private int trans(String str) {
        while (str.length() > 1 && str.startsWith("a")) {
            str = str.substring(1);
        }
        StringBuilder numStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            numStr.append(str.charAt(i) - 'a');
        }
        return Integer.parseInt(numStr.toString());
    }

    public String maxValue(String n, int x) {
        int i;
        if (n.startsWith("-")) {
            i = 1;
            for (; i < n.length(); i++) {
                if (n.charAt(i) - '0' > x) {
                    n = n.substring(0, i) + x + n.substring(i);
                    break;
                }
            }
        } else {
            i = 0;
            for (; i < n.length(); i++) {
                if (n.charAt(i) - '0' < x) {
                    n = n.substring(0, i) + x + n.substring(i);
                    break;
                }
            }
        }
        if (i == n.length()) {
            n += x;
        }
        return n;
    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        int sLength = servers.length;
        int tLength = tasks.length;
        int[] result = new int[tLength];
        int[] temp = new int[sLength];
        int index = 0;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < sLength; i++) {
            min = Math.min(min, servers[i]);
            max = Math.max(max, servers[i]);
            List<Integer> tList = map.getOrDefault(servers[i], new ArrayList<>());
            tList.add(i);
            map.put(servers[i], tList);
        }
        for (int i = min; i <= max; i++) {
            if (map.containsKey(i)) {
                list.addAll(map.get(i));
            }
        }
        while (index < tLength) {
            int i = 0;
            for (; i < sLength; i++) {
                if (temp[list.get(i)] == 0) {
                    result[index] = list.get(i);
                    temp[list.get(i)] = tasks[index];
                    index++;
                    break;
                }
            }
            if (count == 0) {
                for (int j = 0; j < sLength; j++) {
                    temp[j] = Math.max(0, temp[j] - 1);
                }
            } else {
                count--;
            }
            if (i == sLength) {
                count++;
            }
        }
        return result;
    }

    public int minSkips(int[] dist, int speed, int hoursBefore) {
        int length = dist.length;
        double[] free = new double[length-1];
        int[] hours = new int[length-1];
        double sum = 0;
        double hour = 0;
        for (int i = 0; i < length; i++) {
            double temp = (double) dist[i] / speed;
            if (i == length - 1) {
                hour += (double) dist[i] / speed;
                sum += (double) dist[i] / speed;
            } else {
                hours[i] = dist[i] % speed == 0 ? dist[i] / speed : dist[i] / speed + 1;
                hour += hours[i];
                free[i] = 1 + (int) temp - temp;
                int j = i;
                while (j>=0){
                    if(free[j]+free[j-1]>=1)
                    if(hours[j]>1){
                        break;
                    }
                }
                sum += temp;
            }
        }
        if (sum > hoursBefore) {
            return -1;
        }
        if(hour<=hoursBefore){
            return 0;
        }
        Arrays.sort(free);
        int count = 0;
        for (int i = length - 2; i>=0; i--) {
            count++;
            if(hour-free[i]<=hoursBefore){
                break;
            }
        }
        return count;
    }
}
