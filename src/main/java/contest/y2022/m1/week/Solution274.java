package contest.y2022.m1.week;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: Administrator
 * @date: 2021/8/22-10:29
 */
public class Solution274 {
    public static void main(String[] args) {
        Solution274 solution = new Solution274();
        System.out.println(solution.maximumInvitations(new int[]{1,0,0,2,1,4,7,8,9,6,7,10,8}));
    }

    public boolean checkString(String s) {
        return s.indexOf('b') < 0 || (s.indexOf('b') > s.lastIndexOf('a'));
    }

    public int numberOfBeams(String[] bank) {
        int[] nums = new int[bank.length];
        for (int i = 0; i < bank.length; i++) {
            for (int j = 0; j < bank[i].length(); j++) {
                if (bank[i].charAt(j) == '1') {
                    nums[i]++;
                }
            }
        }
        int sum = 0;
        int bef = -1;
        for (int num : nums) {
            if (num > 0) {
                if (bef >= 0) {
                    sum += bef * num;
                }
                bef = num;
            }
        }
        return sum;
    }

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long temp = mass;
        for (int asteroid : asteroids) {
            if (temp < asteroid) {
                return false;
            }
            temp += asteroid;
        }
        return true;
    }

    public int maximumInvitations(int[] favorite) {
        int count = 0;
        boolean[] uuse = new boolean[favorite.length];
        for (int i = 0; i < favorite.length; i++) {
            if (uuse[i]) {
                continue;
            }
            boolean[] use = new boolean[favorite.length];
            use[i] = true;
            int start = i;
            int index = i;
            int temp = 2;
            while (favorite[index] != i) {
                if (favorite[favorite[index]] == index || favorite[favorite[index]] == start) {
                    use[favorite[index]] = true;
                    for (int j = 0; j < favorite.length; j++) {
                        if (use[j]) {
                            uuse[j] = true;
                        }
                    }
                    break;
                }
                if (use[favorite[index]]) {
                    temp = 0;
                    break;
                }
                temp++;
                index = favorite[index];
                use[index] = true;
            }
            count = Math.max(count, temp);
        }
        return count;
    }
}
