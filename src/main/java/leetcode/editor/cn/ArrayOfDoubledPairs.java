//给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i 
//+ 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [3,1,3,6]
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：arr = [2,1,2,6]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：arr = [4,-2,2,-4]
//输出：true
//解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= arr.length <= 3 * 10⁴ 
// arr.length 是偶数 
// -10⁵ <= arr[i] <= 10⁵ 
// 
// Related Topics 贪心 数组 哈希表 排序 👍 153 👎 0

package leetcode.editor.cn;

import java.util.*;

//954:二倍数对数组
public class ArrayOfDoubledPairs {
    public static void main(String[] args) {
        Solution solution = new ArrayOfDoubledPairs().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canReorderDoubled(int[] arr) {
            //计算一对元素的个数
            int num = 0;
            //统计每个元素的个数
            HashMap<Integer, Integer> map = new HashMap<>();
            //对元素进行排序 让小的元素排在前面 这样避免了 2,4,8,1这样的情况 2和4组成了一对，导致8与1组不了对
            Arrays.sort(arr);
            for (int i : arr) {
                Integer orDefault = map.getOrDefault(i, 0);
                map.put(i, orDefault + 1);
            }
            for (int i : arr) {
                //对0特殊处理
                if (i == 0 && map.get(0) < 2) {
                    continue;
                }
                //判断是否能组队成功 如果成功就把i以及2*i的数量-1
                if (map.containsKey(2 * i) && map.get(2 * i) >= 1 && map.get(i) >= 1) {
                    map.put(2 * i, map.get(2 * i) - 1);
                    map.put(i, map.get(i) - 1);
                    num++;
                }
            }
            return num == arr.length / 2;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}