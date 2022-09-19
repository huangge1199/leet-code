//给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。 
//
// 每一步，你可以从下标 i 跳到下标： 
//
// 
// i + 1 满足：i + 1 < arr.length 
// i - 1 满足：i - 1 >= 0 
// j 满足：arr[i] == arr[j] 且 i != j 
// 
//
// 请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。 
//
// 注意：任何时候你都不能跳到数组外面。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [100,-23,-23,404,100,23,23,23,3,404]
//输出：3
//解释：那你需要跳跃 3 次，下标依次为 0 --> 4 --> 3 --> 9 。下标 9 为数组的最后一个元素的下标。
// 
//
// 示例 2： 
//
// 输入：arr = [7]
//输出：0
//解释：一开始就在最后一个元素处，所以你不需要跳跃。
// 
//
// 示例 3： 
//
// 输入：arr = [7,6,9,6,9,6,9,7]
//输出：1
//解释：你可以直接从下标 0 处跳到下标 7 处，也就是数组的最后一个元素处。
// 
//
// 示例 4： 
//
// 输入：arr = [6,1,9]
//输出：2
// 
//
// 示例 5： 
//
// 输入：arr = [11,22,7,7,7,7,7,7,7,22,13]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 5 * 10^4 
// -10^8 <= arr[i] <= 10^8 
// 
// Related Topics 广度优先搜索 数组 哈希表 👍 140 👎 0

package leetcode.editor.cn;

import java.util.*;

//1345:跳跃游戏 IV
public class JumpGameIv {
    public static void main(String[] args) {
        Solution solution = new JumpGameIv().new Solution();
        // TO TEST
        solution.minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minJumps(int[] arr) {
            if (arr.length == 1) {
                return 0;
            }
            boolean[] use = new boolean[arr.length];
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
            }
            use[0] = true;
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(0);
            int count = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                count++;
                for (int i = 0; i < size; i++) {
                    int index = queue.poll();
                    if (index - 1 >= 0 && !use[index - 1]) {
                        queue.add(index - 1);
                        use[index - 1] = true;
                    }
                    if (index + 1 == arr.length - 1) {
                        return count;
                    }
                    if (index + 1 >= 0 && !use[index + 1]) {
                        queue.add(index + 1);
                        use[index + 1] = true;
                    }
                    if (map.containsKey(arr[index])) {
                        List<Integer> list = map.get(arr[index]);
                        map.remove(arr[index]);
                        for (int ind : list) {
                            if (ind == arr.length - 1) {
                                return count;
                            }
                            if (!use[ind]) {
                                queue.add(ind);
                                use[ind] = true;
                            }
                        }
                    }
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
