package contest.y2022.m3.dw;

import java.util.*;

/**
 * @description:
 * @author: Administrator
 * @date: 2022/2/19 22:28
 */
public class SolutionD73 {
    public static void main(String[] args) {
        SolutionD73 solutionD72 = new SolutionD73();
//        TwoArray twoArray = new TwoArray("[[0,3],[0,4],[1,3],[2,4],[2,7],[3,5],[3,6],[3,7],[4,6]]", true);
//        solutionD72.getAncestors(8, twoArray.getArr());
        System.out.println(solutionD72.minMovesToMakePalindrome("letelt"));
    }

    public int mostFrequent(int[] nums, int key) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key && i + 1 < nums.length) {
                list.add(nums[i + 1]);
            }
        }
        Collections.sort(list);
        int num = list.get(0);
        int count = 1;
        int tn = 0;
        int tc = -1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == num) {
                count++;
            } else {
                if (tc == -1) {
                    tn = num;
                    tc = count;
                } else {
                    if (tc < count) {
                        tn = num;
                        tc = count;
                    }
                }
                num = list.get(i);
                count = 1;
            }
        }
        return count > tc ? num : tn;
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[][] change = new int[nums.length][2];
        int j = 0;
        for (int num : nums) {
            String str = "" + num;
            String temp = "";
            for (int i = 0; i < str.length(); i++) {
                temp += mapping[str.charAt(i) - '0'];
            }
            while (temp.startsWith("0")) {
                temp = temp.substring(1);
            }
            if (temp.equals("")) {
                temp = "0";
            }
            change[j][0] = Integer.parseInt(temp);
            change[j][1] = j;
            j++;
        }
        Arrays.sort(change, (e1, e2) -> {
            if (e1[0] == e2[0]) return e1[1] - e2[1];
            return e1[0] - e2[0];
        });
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[change[i][1]];
        }
        return result;
    }

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            List<Integer> list = map.get(edge[0]);
            list.add(edge[1]);
            map.put(edge[0], list);
        }
        for (int key : map.keySet()) {
            boolean[] use = new boolean[n];
            use[key] = true;
            Queue<Integer> queue = new LinkedList<>();
            for (int num : map.get(key)) {
                queue.add(num);
                use[num] = true;
            }
            while (queue.size() > 0) {
                for (int num : map.get(queue.poll())) {
                    if (!use[num]) {
                        queue.add(num);
                        map.get(key).add(num);
                        use[num] = true;
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(new ArrayList<>());
        }
        for (int key : map.keySet()) {
            for (int num : map.get(key)) {
                result.get(num).add(key);
            }
        }
        return result;
    }

    public int minMovesToMakePalindrome(String s) {
        int size = s.length();
        if (size < 3) {
            return 0;
        }
        int l = s.lastIndexOf(s.charAt(0));
        int lc = size - 1 - l;
        int rc = s.indexOf(s.charAt(s.length() - 1));
        return Math.min(lc + minMovesToMakePalindrome(s.substring(1, l) + s.substring(l + 1)),
                rc + minMovesToMakePalindrome(s.substring(0, rc) + s.substring(rc + 1, s.length() - 1)));
    }
//    public int minMovesToMakePalindrome(String s) {
//        char chs[] = s.toCharArray();
//        int n = s.length();
//        int count = 0, j = n - 1;
//        for (int i = 0; i < j; i++) {
//            for (int k = j; k >= i; k--) {
//                if (i == k) {
//                    count += (n / 2 - i);
//                } else if (chs[i] == chs[k]) {
//                    for (int m = k; m < j; m++) {
//                        char t = chs[m];
//                        chs[m] = chs[m + 1];
//                        chs[m + 1] = t;
//                        count++;
//                    }
//                    j--;
//                    break;
//                }
//
//            }
//        }
//        return count;
//    }
}
