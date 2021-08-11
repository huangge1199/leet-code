//给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。 
//请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
//输出：13
//解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[-5]], k = 1
//输出：-5
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length 
// n == matrix[i].length 
// 1 <= n <= 300 
// -109 <= matrix[i][j] <= 109 
// 题目数据 保证 matrix 中的所有行和列都按 非递减顺序 排列 
// 1 <= k <= n2 
// 
// Related Topics 数组 二分查找 矩阵 排序 堆（优先队列） 
// 👍 639 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.TwoArray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//378:有序矩阵中第 K 小的元素
class KthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new KthSmallestElementInASortedMatrix().new Solution();
        TwoArray twoArray = new TwoArray("[[1,3,5],[6,7,12],[11,14,14]]", true);
        System.out.println(solution.kthSmallest(twoArray.getArr(), 6));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
//            Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
//            queue.add(new int[]{0, 0, matrix[0][0]});
//            boolean[][] use = new boolean[matrix.length][matrix[0].length];
//            use[0][0] = true;
//            while (!queue.isEmpty()) {
//                k--;
//                int[] arr = queue.poll();
//                if (k == 0) {
//                    return arr[2];
//                }
//                if (arr[0] + 1 < matrix.length && !use[arr[0] + 1][arr[1]]) {
//                    queue.add(new int[]{arr[0] + 1, arr[1], matrix[arr[0] + 1][arr[1]]});
//                    use[arr[0] + 1][arr[1]] = true;
//                }
//                if (arr[1] + 1 < matrix[0].length && !use[arr[0]][arr[1] + 1]) {
//                    queue.add(new int[]{arr[0], arr[1] + 1, matrix[arr[0]][arr[1] + 1]});
//                    use[arr[0]][arr[1] + 1] = true;
//                }
//            }
//            return 0;
            int rows = matrix.length, columns = matrix[0].length;
            int[] sorted = new int[rows * columns];
            int index = 0;
            for (int[] row : matrix) {
                for (int num : row) {
                    sorted[index++] = num;
                }
            }
            Arrays.sort(sorted);
            return sorted[k - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}