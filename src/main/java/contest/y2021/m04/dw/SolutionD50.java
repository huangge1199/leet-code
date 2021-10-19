package contest.y2021.m04.dw;

/**
 * @Author: 轩辕龙儿
 * @Date: 2021/4/17 22:13
 * @Description:
 */
public class SolutionD50 {
    public int minOperations(int[] nums) {
        int left = nums[0] - 1;
        int sum = 0;
        for (int num : nums) {
            if (num <= left) {
                sum += left - num + 1;
                left++;
            } else {
                left = num;
            }
        }
        return sum;
    }

    public int[] countPoints(int[][] points, int[][] queries) {
        int size = queries.length;
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            int num = 0;
            int length = points.length;
            int c = queries[i][2];
            for (int[] point : points) {
                int x = Math.abs(queries[i][0] - point[0]);
                int y = Math.abs(queries[i][1] - point[1]);
                if (x * x + y * y <= c * c) {
                    num++;
                }
            }
            result[i] = num;
        }
        return result;
    }

    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int max = (int) Math.pow(2, maximumBit) - 1;
        int size = nums.length;
        int[] result = new int[size];
        int num = nums[0];
        result[size - 1] = max - num;
        for (int i = 1; i < size; i++) {
            num ^= nums[i];
            result[size - 1 - i] = max - num;
        }
        return result;
    }

    public static void main(String[] args) {
        SolutionD50 solutionD50 = new SolutionD50();
//        solutionD50.getMaximumXor(new int[]{0, 1, 1, 3}, 2);
        System.out.println(solutionD50.makeStringSorted("leetcode"));
//        BigDecimal mul = new BigDecimal(1);
//        for (int i = 1; i < 24; i++) {
//            System.out.println(i + ":" + mul.multiply(new BigDecimal(i)));
//            mul *= i;
//        }
//        System.out.println(solutionD50.Mulity(2));
    }

    //    public int makeStringSorted(String s) {
//        BigDecimal result = new BigDecimal(0);
//        int size = s.length();
//        int[] chs = new int[26];
//        Map<Integer, Integer> map = new HashMap<>();
//        Map<Integer, BigDecimal> jiechengMap = new HashMap<>();
//        BigDecimal fenmu = new BigDecimal(1);
//        List<Integer> list = new ArrayList<>();
//        TreeSet<Integer> treeSet = new TreeSet<>();
//        BigDecimal mul = new BigDecimal(1);
//        for (int i = 0; i <= size - 1; i++) {
//            int ch = s.charAt(size - 1 - i) - 'a';
//            int num = 0;
//            chs[ch]++;
//            if (map.containsKey(ch)) {
//                map.put(ch, map.get(ch) + 1);
//            } else {
//                map.put(ch, 1);
//            }
//            for (int j = 0; j <= list.indexOf(treeSet.lower(ch)); j++) {
//                num += map.get(list.get(j));
//            }
//            mul = mul.multiply(new BigDecimal(i + 1));
//            jiechengMap.put(i + 1, mul);
//            BigDecimal fenzi;
//            fenmu = fenmu.multiply(new BigDecimal(map.get(ch)));
//            if (!list.contains(ch)) {
//                list.add(ch);
//                Collections.sort(list);
//            }
//            treeSet.add(ch);
//            if (num > 0) {
//                fenzi = jiechengMap.get(i).multiply(new BigDecimal(num));
//                result = result.add(fenzi.divide(fenmu));
//            }
//        }
//        return result.divideAndRemainder(BigDecimal.valueOf(Math.pow(10, 9) + 7))[1].intValue();
//    }
    public int makeStringSorted(String s) {
        int mode = 1000000007;
        // 阶乘
        long[] mul = new long[4000];
        // 乘法逆元
        long[] div = new long[4000];
        mul[0] = 1;
        for (int i = 1; i < 3500; i++) {
            mul[i] = mul[i - 1] * i % mode;
        }
        for (int i = 0; i < 3500; i++) {
            div[i] = power(mul[i], mode - 2, mode);
        }

        int[] cnt = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        long res = 0;
        for (int i = 0; i < length; i++) {
            int ch = s.charAt(i) - 'a';
            for (int j = 0; j < ch; j++) {
                if (cnt[j] == 0) {
                    continue;
                }
                cnt[j]--;
                long num = mul[length - 1 - i];
                for (int k = 0; k < 26; k++) {
                    num = num * div[cnt[k]] % mode;
                }
                res = (res + num) % mode;
                cnt[j]++;
            }
            cnt[ch]--;
        }
        return (int) res;
    }

    public long power(long num, int index, int mode) {
        if (index == 0) {
            return 1;
        }
        long res = power(num, index / 2, mode);
        res = res * res % mode;
        if (index % 2 == 1) {
            res = res * num % mode;
        }
        return res;
    }
}
