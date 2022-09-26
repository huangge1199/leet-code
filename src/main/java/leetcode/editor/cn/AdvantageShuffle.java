//给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。 
//
// 返回 A 的任意排列，使其相对于 B 的优势最大化。 
//
// 
//
// 示例 1： 
//
// 输入：A = [2,7,11,15], B = [1,10,4,11]
//输出：[2,11,7,15]
// 
//
// 示例 2： 
//
// 输入：A = [12,24,8,32], B = [13,25,32,11]
//输出：[24,32,8,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length = B.length <= 10000 
// 0 <= A[i] <= 10^9 
// 0 <= B[i] <= 10^9 
// 
// Related Topics 贪心算法 数组 
// 👍 125 👎 0

package leetcode.editor.cn;

import javafx.util.Pair;

import java.util.*;

//870:优势洗牌
public class AdvantageShuffle {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new AdvantageShuffle().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] advantageCount(int[] A, int[] B) {
            int length = A.length;
            Pair<Integer, Integer>[] pairs = new Pair[length];
            for (int i = 0; i < length; i++) {
                pairs[i] = new Pair<>(i, B[i]);
            }
            Arrays.sort(pairs, Comparator.comparingInt(Pair::getValue));
            int[] copy = Arrays.copyOf(A, length);
            Arrays.sort(copy);
            int i = 0, j = 0;
            while (i < A.length) {
                if (copy[i] > pairs[j].getValue()) {
                    A[pairs[j].getKey()] = copy[i];
                    i++;
                    j++;
                } else {
                    A[pairs[(A.length - 1) - (i - j)].getKey()] = copy[i];
                    i++;
                }
            }
            return A;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}