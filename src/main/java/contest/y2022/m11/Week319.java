package contest.y2022.m11;

import com.code.leet.entiy.TreeNode;

import java.util.*;

public class Week319 {
    public static void main(String[] args) {
        Week319 solution = new Week319();
        String s = "rzdtuheehuolxbhcychbpmcmxxxxxxiywqwyierjsuusjreunvvnu";
        int k = 4;
        System.out.println(solution.maxPalindromes(s, k));
    }

    public int maxPalindromes(String s, int k) {
        if (k == 1) {
            return s.length();
        }
        nums = new int[s.length()];
        max = 0;
        dfs(s, 0, k, 0);
        return max;
    }

    int[] nums;
    int max;

    private void dfs(String s, int index, int k, int num) {
        if (index == s.length() || s.length() - index < k) {
            max = Math.max(max, num);
            return;
        }
        nums[index] = Math.max(nums[index], num);
        String tmp = s.substring(index + k - 1);
        int i = tmp.indexOf(s.charAt(index));
        if (i >= 0) {
            StringBuilder sb = new StringBuilder(s.substring(index, index + k + i));
            if (sb.toString().equals(sb.reverse().toString())) {
                if (nums[index + k + i - 1] < num + 1) {
                    nums[index + k + i - 1] = num + 1;
                    dfs(s, index + k + i, k, num + 1);
                }
            }
        }
        dfs(s, index + 1, k, num);
    }
//--------------------------
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            List<Integer> sort = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                sort.add(node.val);
                Collections.sort(sort);
                List<Integer> tl = new ArrayList<>();
                List<Integer> ts = new ArrayList<>();
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) != sort.get(j)) {
                        tl.add(list.get(j));
                        ts.add(sort.get(j));
                    }
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return 0;
    }
//----------------------------
    public int subarrayLCM(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = 1;
            for (int j = i; j < nums.length; j++) {
                tmp = getCM(tmp, nums[j]);
                if (tmp > k) {
                    break;
                }
                if (tmp == k) {
                    res += 1;
                }
            }
        }
        return res;
    }

    public static int getCM(int m, int n) {
        int max = Math.max(m, n);
        for (int i = max; i <= m * n; i++) {
            if (i % m == 0 && i % n == 0) {
                return i;
            }
        }
        return -1;
    }
//--------------------
    public double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15, celsius * 1.8 + 32};
    }


}
