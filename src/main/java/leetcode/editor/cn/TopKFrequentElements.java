//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 853 👎 0

package leetcode.editor.cn;

import java.util.*;

//347:前 K 个高频元素
class TopKFrequentElements {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new TopKFrequentElements().new Solution();
        solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> counts = new HashMap<>();
            for (int num : nums) {
                counts.put(num, counts.getOrDefault(num, 0) + 1);
            }
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int key : counts.keySet()) {
                List<Integer> temp = map.getOrDefault(counts.get(key), new ArrayList<>());
                temp.add(key);
                map.put(counts.get(key), new ArrayList<>(temp));
            }
            List<Integer> list = new ArrayList<>(map.keySet());
            int[] arr = new int[k];
            int index = 0;
            for (int i = list.size() - 1; i >= 0; i--) {
                List<Integer> temp = map.get(list.get(i));
                for (int j = index; j < index + temp.size(); j++) {
                    arr[j] = temp.get(j - index);
                }
                index += temp.size();
                if (index == k) {
                    break;
                }
            }
            return arr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}