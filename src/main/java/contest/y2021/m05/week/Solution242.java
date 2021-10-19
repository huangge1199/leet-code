package contest.y2021.m05.week;

public class Solution242 {
    public static void main(String[] args) {
        Solution242 solution = new Solution242();
//        System.out.println(solution.minSpeedOnTime(new int[]{5,3,4,6,2,2,7}, 10.92));
//        System.out.println(solution.canReach("01101110", 2, 3));
        System.out.println(solution.canReach("00111010", 3, 5));
    }

    public boolean checkZeroOnes(String s) {
        if (s.length() == 0 || !s.contains("1")) {
            return false;
        }
        if (!s.contains("0")) {
            return true;
        }
        int[] lengths = new int[2];
        int start0 = s.indexOf("0");
        int start1 = s.indexOf("1");
        int[] maxs = new int[2];
        char ch = '0';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                lengths[ch - '0']++;
            } else {
                maxs[ch - '0'] = Math.max(maxs[ch - '0'], lengths[ch - '0']);
                lengths[ch - '0'] = 0;
                ch = s.charAt(i);
                lengths[ch - '0']++;
            }
        }
        maxs[ch - '0'] = Math.max(maxs[ch - '0'], lengths[ch - '0']);
        return maxs[1] > maxs[0];
    }

    public int minSpeedOnTime(int[] dist, double hour) {
        int length = dist.length;
        if (hour < length - 1) {
            return -1;
        }
        int sum = 0;
        for (int k : dist) {
            sum += k;
        }
        if (hour > sum) {
            return 1;
        }
        int max = dist[0];
        for (int i = 1; i < length; i++) {
            max = Math.max(max, dist[i]);
        }
        if ((int) hour == length - 1) {
            return Math.max(max, (int) (dist[length - 1] / (hour - length + 1)));
        }
        int j = max;
        for (; j > 1; j--) {
            int free = 0;
            for (int i = 0; i < length - 1; i++) {
                free += dist[i] / j;
                if (dist[i] % j > 0) {
                    free++;
                }
            }
            if ((hour - free) * j < dist[dist.length - 1]) {
                break;
            }
        }
        j = j == 1 ? 1 : j + 1;
        return j > max ? -1 : j;
    }

    public boolean canReach(String s, int minJump, int maxJump) {
        if(s.charAt(s.length()-1)=='1'){
            return false;
        }
        if (minJump >= s.length()) {
            return false;
        }
        if (maxJump >= s.length()-1) {
            return true;
        }
        String temp = s.substring(minJump, maxJump + 1);
        int index = 0;
        while (temp.lastIndexOf("0") >= 0) {
            index = minJump + temp.lastIndexOf("0");
            if (index + minJump >= s.length()) {
                return false;
            }
            if (index + maxJump + 1 >= s.length()) {
                return true;
            }
            temp = s.substring(index + minJump, index + maxJump + 1);
        }
        return false;
    }
}
