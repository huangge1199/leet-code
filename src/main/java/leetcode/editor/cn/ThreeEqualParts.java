//给定一个由 0 和 1 组成的数组 arr ，将数组分成 3 个非空的部分 ，使得所有这些部分表示相同的二进制值。 
//
// 如果可以做到，请返回任何 [i, j]，其中 i+1 < j，这样一来： 
//
// 
// arr[0], arr[1], ..., arr[i] 为第一部分； 
// arr[i + 1], arr[i + 2], ..., arr[j - 1] 为第二部分； 
// arr[j], arr[j + 1], ..., arr[arr.length - 1] 为第三部分。 
// 这三个部分所表示的二进制值相等。 
// 
//
// 如果无法做到，就返回 [-1, -1]。 
//
// 注意，在考虑每个部分所表示的二进制时，应当将其看作一个整体。例如，[1,1,0] 表示十进制中的 6，而不会是 3。此外，前导零也是被允许的，所以 [0,
//1,1] 和 [1,1] 表示相同的值。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,0,1,0,1]
//输出：[0,3]
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,1,0,1,1]
//输出：[-1,-1] 
//
// 示例 3: 
//
// 
//输入：arr = [1,1,0,0,1]
//输出：[0,2]
// 
//
// 
//
// 提示： 
// 
//
// 
// 3 <= arr.length <= 3 * 10⁴ 
// arr[i] 是 0 或 1 
// 
// Related Topics 数组 数学 👍 61 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//927:三等分
public class ThreeEqualParts {
    public static void main(String[] args) {
        Solution solution = new ThreeEqualParts().new Solution();
        // TO TEST
        solution.threeEqualParts(new int[]{1, 0, 1, 0, 1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] threeEqualParts(int[] arr) {
            List<Integer> count1 = new ArrayList<>();
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                str.append(arr[i]);
                if (arr[i] == 1) {
                    count1.add(i);
                }
            }
            if (count1.size() == 0) {
                return new int[]{0, 2};
            }
            if (count1.size() % 3 > 0) {
                return new int[]{-1, -1};
            }
            int ori = count1.size() - count1.size() / 3;
            int right = count1.get(ori);

            String comStr = str.substring(right);
            str = new StringBuilder(str.substring(0, right));

            int left = str.lastIndexOf(comStr);
            if (left < 0 || left + comStr.length() - 1 < count1.get(ori - 1)) {
                return new int[]{-1, -1};
            }
            right = left + comStr.length();
            str = new StringBuilder(str.substring(0, left));

            int index = str.lastIndexOf(comStr);
            if (index < 0) {
                return new int[]{-1, -1};
            }
            left = index + comStr.length() - 1;

            return new int[]{left, right};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
