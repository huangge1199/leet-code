//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 矩阵 
// 👍 478 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.TwoArray;

//74:搜索二维矩阵
class SearchA2dMatrix {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new SearchA2dMatrix().new Solution();
        //true
//        TwoArray twoArray = new TwoArray("[[1,3,5,7],[10,11,16,20],[23,30,34,60]]",true);
//        System.out.println(solution.searchMatrix(twoArray.getArr(), 3));
        //true
        TwoArray twoArray = new TwoArray("[[1,3]]", true);
        System.out.println(solution.searchMatrix(twoArray.getArr(), 3));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) {
                return false;
            }
            int start = 0;
            int end = matrix.length - 1;
            while (start < end - 1) {
                int mid = (start + end) / 2;
                if (matrix[mid][0] == target) {
                    return true;
                }
                if (matrix[mid][0] > target) {
                    end = mid - 1;
                } else {
                    start = mid;
                }
            }
            if (matrix[end][0] == target) {
                return true;
            }
            int xIndex = matrix[end][0] > target ? start : end;
            start = 0;
            end = matrix[0].length - 1;
            while (start < end) {
                int mid = (start + end) / 2;
                if (matrix[xIndex][mid] == target) {
                    return true;
                }
                if (matrix[xIndex][mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            return matrix[xIndex][start] == target;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}