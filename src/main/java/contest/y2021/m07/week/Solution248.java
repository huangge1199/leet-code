package contest.y2021.m07.week;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution248 {

    public static void main(String[] args) {
        Solution248 solution = new Solution248();
//        System.out.println(solution.eliminateMaximum(new int[]{1, 3, 4}, new int[]{1, 1, 1}));
//        System.out.println(solution.eliminateMaximum(new int[]{1, 1, 2, 3}, new int[]{1, 1, 1, 1}));
//        System.out.println(solution.eliminateMaximum(new int[]{5}, new int[]{3}));
//        System.out.println(solution.eliminateMaximum(new int[]{4, 2, 8}, new int[]{2, 1, 4}));
        System.out.println(solution.countGoodNumbers(50));
    }

    public int[] buildArray(int[] nums) {
        int size = nums.length;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = nums[nums[i]];
        }
        return arr;
    }

    public int eliminateMaximum(int[] dist, int[] speed) {
        int size = dist.length;
        int[] times = new int[size];
        for (int i = 0; i < size; i++) {
            int time = dist[i] / speed[i];
            times[i] = dist[i] % speed[i] == 0 ? time - 1 : time;
        }
        Arrays.sort(times);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            map.put(times[i], map.getOrDefault(times[i], 0) + 1);
        }
        int index = 1;
        for (int i = 0; i < size; i++) {
            if (map.containsKey(i)) {
                if (map.get(i) > index) {
                    return i + 1;
                }
                index -= map.get(i);
            }
            index++;
        }
        return size;
    }

    public int countGoodNumbers(long n) {
        int odd = (int)(n/2);
        int num = (int)(n-odd);
        return (int)(Math.pow(5,num)*Math.pow(4,odd))%10000007;
    }
}
