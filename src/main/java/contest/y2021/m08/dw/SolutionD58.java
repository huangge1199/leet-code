package contest.y2021.m08.dw;

public class SolutionD58 {
    public static void main(String[] args) {
        SolutionD58 solution = new SolutionD58();
//        System.out.println(solution.minimumPerimeter(1000000000));
        System.out.println(solution.countSpecialSubsequences(new int[]{0, 1, 2, 0, 1, 2}));
    }


    public boolean isThree(int n) {
        int flag = 0;
        if (n <= 2) {
            return false;
        }
        int num = n / 2;
        for (int i = 3; i < num; i++) {
            if (n % i == 0) {
                if (flag == 1) {
                    return false;
                }
                flag = 1;
            }
        }
        return flag == 1;
    }

    public long numberOfWeeks(int[] milestones) {
        long max = 0;
        long sum = 0;
        for (int milestone : milestones) {
            sum += milestone;
            max = Math.max(max, milestone);
        }
        return sum / max >= 2 ? sum : (sum - max) * 2 + 1;
    }

    public long minimumPerimeter(long neededApples) {
        if (neededApples == 0) {
            return 0;
        }
        if (neededApples < 12) {
            return 8;
        }
        long n = 2;
        long cur = 12;
        long sum = 12;
        while (sum < neededApples) {
            cur = cur + 12 * (n + 1);
            sum += cur;
            n += 2;
        }
        return 4 * n;
    }

    public int countSpecialSubsequences(int[] nums) {
        long[] result = new long[3];
        long[] counts = new long[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            if (num == 1) {
                counts[i] = result[2];
                result[num] += counts[i];
            } else if (num == 0) {
                result[num] = result[1] * result[2];
            } else {

            }
        }
//            return (int) (result[0][2] % 100000007);
        return 0;
    }

}
