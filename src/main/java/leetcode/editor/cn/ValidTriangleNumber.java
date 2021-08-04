//给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。 
//
// 示例 1: 
//
// 
//输入: [2,2,3,4]
//输出: 3
//解释:
//有效的组合是: 
//2,3,4 (使用第一个 2)
//2,3,4 (使用第二个 2)
//2,2,3
// 
//
// 注意: 
//
// 
// 数组长度不超过1000。 
// 数组里整数的范围为 [0, 1000]。 
// 
// Related Topics 贪心 数组 双指针 二分查找 排序 
// 👍 252 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//611:有效三角形的个数
class ValidTriangleNumber {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ValidTriangleNumber().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int triangleNumber(int[] nums) {
            Arrays.sort(nums);
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i - 1; j >= 0; j--) {
//                    int k = 0;
//                    while (k < j && nums[j] + nums[k] <= nums[i]) {
//                        k++;
//                    }
//                    count += j - k;
                    int start = 0, end = j - 1;
                    while (start < end) {
                        int mid = start + end >> 1;
                        if (nums[mid] + nums[j] > nums[i]) {
                            end = mid;
                        } else {
                            start = mid + 1;
                        }
                    }
                    if (start == end && nums[end] + nums[j] > nums[i]) {
                        count += j - end;
                    }
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}