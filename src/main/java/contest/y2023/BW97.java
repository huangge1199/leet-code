package contest.y2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BW97 {
    public static void main(String[] args) {
        BW97 solution = new BW97();
        System.out.println(solution.maximizeWin(new int[]{1, 1, 2, 2, 3, 3, 5}, 2));
//        System.out.println(solution.maximizeWin(new int[]{1, 2, 3, 4}, 0));
    }

    public int maximizeWin(int[] prizePositions, int k) {
        int sum1 = 0;
        int sum2 = 0;
        int sum = 1;
        int left = 0;
        for (int i = 1; i < prizePositions.length; i++) {
            if (prizePositions[i] - prizePositions[left] <= k) {
                sum += 1;
            } else {
                if (sum >= sum2) {
                    if (sum >= sum1) {
                        sum2 = sum1;
                        sum1 = sum;
                    } else {
                        sum2 = sum;
                    }
                }
                left++;
                while (left < prizePositions.length && prizePositions[i] - prizePositions[left] > k) {
                    sum -= 1;
                    left++;
                }
            }
        }
        if (sum >= sum2) {
            if (sum >= sum1) {
                sum2 = sum1;
                sum1 = sum;
            } else {
                sum2 = sum;
            }
        }
        return sum1 + sum2;
    }

    public int maxCount(int[] banned, int n, int maxSum) {
        Arrays.sort(banned);
        int sum = 0;
        int cnt = 0;
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (index >= banned.length || i < banned[index]) {
                sum += i;
                if (sum > maxSum) {
                    return cnt;
                } else {
                    cnt++;
                }
            } else {
                index++;
            }
            while (index > 0 && index < banned.length && banned[index] == banned[index - 1]) {
                index++;
            }
        }
        return cnt;
    }

    public int[] separateDigits(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            String str = "" + nums[i];
            for (int j = 0; j < str.length(); j++) {
                list.add("" + str.charAt(j));
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = Integer.parseInt(list.get(i));
        }
        return res;
    }
}
