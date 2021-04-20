//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 961 👎 0

package leetcode.editor.cn;

//34:在排序数组中查找元素的第一个和最后一个位置
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        solution.searchRange(new int[]{5,7,7,8,8,10},8);//3,4
        solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);//-1,-1
        solution.searchRange(new int[]{2, 2}, 3);//-1,-1
        solution.searchRange(new int[]{1, 4}, 4);//1,1
        solution.searchRange(new int[]{0, 1, 2, 3, 4, 4, 4}, 2);//2,2
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int length = nums.length;
            if (nums.length == 0 || nums[0] > target || nums[length - 1] < target) {
                return new int[]{-1, -1};
            }
            int start = 0;
            int end = nums.length - 1;
            int mid = 0;
            while (start <= end) {
                mid = (start + end) / 2;
                while (nums[mid] < target) {
                    start = mid + 1;
                    if (mid == (mid + end) / 2) {
                        if (mid == end) {
                            return new int[]{-1, -1};
                        } else {
                            mid = end;
                        }
                    } else {
                        mid = (mid + end) / 2;
                    }
                }
                while (nums[mid] > target) {
                    end = mid - 1;
                    if (mid == mid / 2) {
                        if (mid == 0) {
                            return new int[]{-1, -1};
                        } else {
                            mid = 0;
                        }
                    } else {
                        mid /= 2;
                    }
                }
                if(nums[mid] == target){
                    break;
                }
            }
            if (nums[mid] != target) {
                return new int[]{-1, -1};
            }
            start = mid;
            end = mid;
            while (start > 0 && nums[start - 1] == target) {
                start--;
            }
            while (end < nums.length - 1 && nums[end + 1] == target) {
                end++;
            }
            return new int[]{start, end};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}