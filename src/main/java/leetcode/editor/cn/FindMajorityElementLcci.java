//数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1
//) 的解决方案。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,5,9,5,9,5,5,5]
//输出：5 
//
// 示例 2： 
//
// 
//输入：[3,2]
//输出：-1 
//
// 示例 3： 
//
// 
//输入：[2,2,1,1,1,2,2]
//输出：2 
// Related Topics 数组 计数 
// 👍 134 👎 0

package leetcode.editor.cn;

//面试题 17.10:主要元素
public class FindMajorityElementLcci {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new FindMajorityElementLcci().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            int nu = -1;
            int count = 0;
            for (int num : nums) {
                if (count == 0) {
                    nu = num;
                }
                if (nu == num) {
                    count++;
                } else {
                    count--;
                }
            }
            count = 0;
            for (int num : nums) {
                if (nu == num) {
                    count++;
                }
            }
            return count * 2 > nums.length ? nu : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}