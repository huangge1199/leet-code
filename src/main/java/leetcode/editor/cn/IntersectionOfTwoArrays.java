//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 406 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//349:两个数组的交集
class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new IntersectionOfTwoArrays().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums1) {
                set.add(num);
            }
            int index = 0;
            for (int num : nums2) {
                if (set.contains(num)) {
                    set.remove(num);
                    nums1[index] = num;
                    index++;
                }
            }
            return Arrays.copyOf(nums1, index);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}