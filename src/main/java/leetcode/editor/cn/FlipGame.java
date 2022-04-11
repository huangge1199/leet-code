//你和朋友玩一个叫做「翻转游戏」的游戏。游戏规则如下： 
//
// 给你一个字符串 currentState ，其中只含 '+' 和 '-' 。你和朋友轮流将 连续 的两个 "++" 反转成 "--" 。当一方无法进行有效
//的翻转时便意味着游戏结束，则另一方获胜。 
//
// 计算并返回 一次有效操作 后，字符串 currentState 所有的可能状态，返回结果可以按 任意顺序 排列。如果不存在可能的有效操作，请返回一个空列表
// [] 。 
//
// 
//
// 示例 1： 
//
// 
//输入：currentState = "++++"
//输出：["--++","+--+","++--"]
// 
//
// 示例 2： 
//
// 
//输入：currentState = "+"
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= currentState.length <= 500 
// currentState[i] 不是 '+' 就是 '-' 
// 
// Related Topics 字符串 👍 33 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//293:翻转游戏
public class FlipGame {
    public static void main(String[] args) {
        Solution solution = new FlipGame().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generatePossibleNextMoves(String currentState) {
            List<String> list = new ArrayList<>();
            for (int i = 1; i < currentState.length(); i++) {
                if(currentState.charAt(i-1)=='+'&&currentState.charAt(i)=='+'){
                    list.add(currentState.substring(0,i-1)+"--"+currentState.substring(i+1));
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
