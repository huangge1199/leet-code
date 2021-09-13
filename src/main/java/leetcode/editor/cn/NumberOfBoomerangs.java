//给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中
// i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。 
//
// 返回平面上所有回旋镖的数量。 
// 
//
// 示例 1： 
//
// 
//输入：points = [[0,0],[1,0],[2,0]]
//输出：2
//解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
// 
//
// 示例 2： 
//
// 
//输入：points = [[1,1],[2,2],[3,3]]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：points = [[1,1]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// n == points.length 
// 1 <= n <= 500 
// points[i].length == 2 
// -10⁴ <= xi, yi <= 10⁴ 
// 所有点都 互不相同 
// 
// Related Topics 数组 哈希表 数学 👍 176 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.TwoArray;

import java.util.Arrays;

//447:回旋镖的数量
class NumberOfBoomerangs {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new NumberOfBoomerangs().new Solution();
        TwoArray twoArray = new TwoArray("[[0,0],[1,0],[2,0]]", true);
        System.out.println(solution.numberOfBoomerangs(twoArray.getArr()));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfBoomerangs(int[][] points) {
            int size = points.length;
            int[][] lengths = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    int x = points[j][0] - points[i][0];
                    int y = points[j][1] - points[i][1];
                    int sum = x * x + y * y;
                    lengths[i][j] = sum;
                    lengths[j][i] = sum;
                }
            }
            int counts = 0;
            for (int[] length : lengths) {
                Arrays.sort(length);
                int count = 0;
                int bef = length[0];
                for (int i = 1; i < size; i++) {
                    if (length[i] == bef) {
                        count++;
                    } else {
                        counts += (count + 1) * count;
                        count = 0;
                        bef = length[i];
                    }
                }
                if (count > 0) {
                    counts += (count + 1) * count;
                }
            }
            return counts;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}