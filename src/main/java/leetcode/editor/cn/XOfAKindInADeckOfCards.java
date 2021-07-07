//给定一副牌，每张牌上都写着一个整数。 
//
// 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组： 
//
// 
// 每组都有 X 张牌。 
// 组内所有的牌上都写着相同的整数。 
// 
//
// 仅当你可选的 X >= 2 时返回 true。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3,4,4,3,2,1]
//输出：true
//解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
// 
//
// 示例 2： 
//
// 输入：[1,1,1,2,2,2,3,3]
//输出：false
//解释：没有满足要求的分组。
// 
//
// 示例 3： 
//
// 输入：[1]
//输出：false
//解释：没有满足要求的分组。
// 
//
// 示例 4： 
//
// 输入：[1,1]
//输出：true
//解释：可行的分组是 [1,1]
// 
//
// 示例 5： 
//
// 输入：[1,1,2,2,2,2]
//输出：true
//解释：可行的分组是 [1,1]，[2,2]，[2,2]
// 
//
// 
//提示： 
//
// 
// 1 <= deck.length <= 10000 
// 0 <= deck[i] < 10000 
// 
//
// 
// Related Topics 数组 哈希表 数学 计数 数论 
// 👍 229 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//914:卡牌分组
class XOfAKindInADeckOfCards {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new XOfAKindInADeckOfCards().new Solution();
        System.out.println(solution.hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
        System.out.println(solution.hasGroupsSizeX(new int[]{1, 1}));
        System.out.println(solution.hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2}));
        System.out.println(solution.hasGroupsSizeX(new int[]{1,1,1,1,2,2,2,2,2,2}));
        System.out.println("------------------------");
        System.out.println(solution.hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
        System.out.println(solution.hasGroupsSizeX(new int[]{}));
        System.out.println(solution.hasGroupsSizeX(new int[]{}));
        System.out.println(solution.hasGroupsSizeX(new int[]{}));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean hasGroupsSizeX(int[] deck) {
            int size = deck.length;
            if (size < 2) {
                return false;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : deck) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for (int i = 2; i <= size; i++) {
                if (size % i == 0) {
                    boolean flag = true;
                    for (int key : map.keySet()) {
                        if (map.get(key) % i != 0) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}