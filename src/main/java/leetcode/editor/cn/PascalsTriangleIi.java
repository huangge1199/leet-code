//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组 
// 👍 281 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//119:杨辉三角 II
public class PascalsTriangleIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PascalsTriangleIi().new Solution();
        solution.getRow(3);
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            int left = list.get(0);
            for (int i = 1; i <= rowIndex; i++) {
                for (int j = 1; j < list.size(); j++) {
                    int temp = list.get(j);
                    list.add(j, left + list.get(j));
                    list.remove(j + 1);
                    left = temp;
                }
                list.add(1);
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}