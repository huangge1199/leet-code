package contest.y2022.m7;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Dw83 {
    public static void main(String[] args) {
        Dw83 solution = new Dw83();
    }

    public int shortestSequence(int[] rolls, int k) {
        int cnt = 1;
        boolean[] uses = new boolean[k + 1];
        int use = k;
        for (int i = 0; i < rolls.length; i++) {
            if (!uses[rolls[i]]) {
                uses[rolls[i]] = true;
                use--;
            }
            if (use == 0) {
                cnt++;
                Arrays.fill(uses, false);
                use = k;
            }
        }
        return cnt;
    }

    public long zeroFilledSubarray(int[] nums) {
        long cnt = 0;
        int[] cnts = new int[nums.length];
        if (nums[0] == 0) {
            cnts[0] = 1;
            cnt = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                cnts[i] = cnts[i - 1] + 1;
                cnt += cnts[i];
            }
        }
        return cnt;
    }

    public String bestHand(int[] ranks, char[] suits) {
        boolean bl = true;
        int max = 1;
        int cnt = 1;
        Arrays.sort(ranks);
        for (int i = 1; i < 5; i++) {
            if (suits[i] != suits[i - 1]) {
                bl = false;
            }
            if (ranks[i] == ranks[i - 1]) {
                cnt++;
            } else {
                max = Math.max(max, cnt);
                cnt = 1;
            }
        }
        max = Math.max(max, cnt);
        if (bl) {
            return "Flush";
        } else if (max >= 3) {
            return "Three of a Kind";
        } else if (max == 2) {
            return "Pair";
        } else {
            return "High Card";
        }
    }
}
