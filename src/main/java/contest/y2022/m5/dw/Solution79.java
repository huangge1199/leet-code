package contest.y2022.m5.dw;

import com.code.leet.entiy.TwoArray;

import java.util.*;

/**
 * leet-code
 *
 * @author 轩辕龙儿
 * @date 2022/5/28 下午10:18
 */
public class Solution79 {
    public boolean digitCount(String num) {
        int[] arrs = new int[10];
        for (char ch : num.toCharArray()) {
            arrs[ch - '0']++;
        }
        for (int i = 0; i < num.length(); i++) {
            if (arrs[i] != (num.charAt(i) - '0')) {
                return false;
            }
        }
        return true;
    }

    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < senders.length; i++) {
            map.put(senders[i], map.getOrDefault(senders[i], 0) + messages[i].split(" ").length);
        }
        List<String> list = new ArrayList<>();
        int max = 0;
        for (String key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                list = new ArrayList<>();
                list.add(key);
            } else if (map.get(key) == max) {
                list.add(key);
            }
        }
        Collections.sort(list);
        return list.get(list.size() - 1);
    }

    public long maximumImportance(int n, int[][] roads) {
        int[] nums = new int[n];
        for (int[] road : roads) {
            nums[road[0]]++;
            nums[road[1]]++;
        }
        Arrays.sort(nums);
        long result = 0;
        int num = 1;
        for (int i = 0; i < n; i++, num++) {
            result += (long) nums[i] * num;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution79 solution = new Solution79();
//        TwoArray roads = new TwoArray("[[0,1],[1,2],[2,3],[0,2],[1,3],[2,4]]",true);
//        System.out.println(solution.maximumImportance(5, roads.getArr()));
        BookMyShow bookMyShow = new BookMyShow(2,5);
        bookMyShow.gather(4,0);
        bookMyShow.gather(2,0);
        bookMyShow.scatter(5,1);
        bookMyShow.scatter(5,1);
    }
}
