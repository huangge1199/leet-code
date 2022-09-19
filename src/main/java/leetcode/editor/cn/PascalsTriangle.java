//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 动态规划 
// 👍 525 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//118:杨辉三角
public class PascalsTriangle {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PascalsTriangle().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                List<Integer> list = new ArrayList<>();
                if (i == 0) {
                    list.add(1);
                    result.add(list);
                    continue;
                }
                List<Integer> bef = result.get(i - 1);
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        list.add(1);
                    } else {
                        list.add(bef.get(j - 1) + bef.get(j));
                    }
                }
                result.add(list);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}