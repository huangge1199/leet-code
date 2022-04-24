package contest.y2022.m4.dw;

import com.code.leet.entiy.TwoArray;

import java.util.*;

/**
 * @description:
 * @author: Administrator
 * @date: 2022/4/16 22:31
 */
public class Solution76 {

    public static void main(String[] args) {
        Solution76 solution = new Solution76();
//        solution.findClosestNumber(new int[]{61488, 18221, -1321, 90249, -62158, 55128, -93476, 53905, 57644, 24630, 89599, -95795, -14891, -60298, 17690, 99022, -24006, -89156, 80135, -46303, 18812, 59924, 32024, 82924, -47519, -77086, 1763, 68618, 53629, -56957, 95485, 99630, -7977, 31164, 94481, -80239, -57749, -3319, -58231, -94841, -19292, 33200, -31446, -3528, 2229, 74241, -19992, -91852, -28073, 31453, -74484, 35491, 38870, -9499, 39838, 87369, 21123, -38616, -89277, -14541, -81586, -18569, -58242, -71216, 10816, 15086, -10519, 51080, 53257, -4912, -37142, -16723, -69795, 54937, -24920, 68970, -10010, -81717, 36203, -67939, 73877, -58258, -57183, 36637, 91518, -8492, -57476, 50523, 62462, 73152, -9511, -66761, 28333, -87163, 5187});
        int[] scores = new int[]{16, 21, 22, 2, 24, 21, 12, 17, 2, 24};
        TwoArray edges = new TwoArray("[[0,1],[1,2],[2,3],[3,4],[4,5],[5,6],[6,7],[7,8],[8,9],[9,0]]", true);
        System.out.println(solution.maximumScore(scores, edges.getArr()));
    }

    public int findClosestNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] >= 0) {
            return nums[0];
        }
        if (nums[nums.length - 1] <= 0) {
            return nums[nums.length - 1];
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                return 0;
            }
            if (nums[i] > 0 && nums[i - 1] < 0) {
                if (nums[i] <= -nums[i - 1]) {
                    return nums[i];
                } else {
                    return nums[i - 1];
                }
            }
        }
        return 0;
    }

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long count = 0;
        for (int i = 0; i <= total / cost1; i++) {
            count += (total - cost1 * i) / cost2 + 1;
        }
        return count;
    }

    class ATM {

        long[] counts;
        long[] cost;

        public ATM() {
            counts = new long[5];
            cost = new long[]{20, 50, 100, 200, 500};
        }

        public void deposit(int[] banknotesCount) {
            for (int i = 0; i < 5; i++) {
                counts[i] += banknotesCount[i];
            }
        }

        public int[] withdraw(int amount) {
            int[] free = new int[5];
            for (int i = 4; i >= 0; i--) {
                if (amount >= cost[i]) {
                    free[i] = (int) Math.min(amount / cost[i], counts[i]);
                    amount -= cost[i] * free[i];
                }
            }
            if (amount > 0) {
                return new int[]{-1};
            } else {
                for (int i = 0; i < 5; i++) {
                    counts[i] -= free[i];
                }
                return free;
            }
        }
    }

    public int maximumScore(int[] scores, int[][] edges) {
        int length = scores.length;
        List<int[]>[] lists = new ArrayList[length];
        for (int i = 0; i < length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[0]].add(new int[]{scores[edge[1]], edge[1]});
            lists[edge[1]].add(new int[]{scores[edge[0]], edge[0]});
        }
        for (int i = 0; i < length; i++)
            if (lists[i].size() > 3) {
                Collections.sort(lists[i], (a, b) -> (b[0] - a[0]));
                lists[i] = new ArrayList<>(lists[i].subList(0, 3));
            }

        int ans = -1;
        for (int[] edge : edges) {
            for (int[] num1 : lists[edge[0]]) {
                if(num1[1]==edge[1]){
                    continue;
                }
                for (int[] num2 : lists[edge[1]]) {
                    if (num2[1] != edge[0] && num1[1] != num2[1])
                        ans = Math.max(ans, num1[0] + scores[edge[0]] + scores[edge[1]] + num2[0]);
                }
            }
        }
        return ans;
    }
}
