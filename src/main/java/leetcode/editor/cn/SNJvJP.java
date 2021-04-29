//某乐团的演出场地可视作 `num * num` 的二维矩阵 `grid`（左上角坐标为 `[0,0]`)，每个位置站有一位成员。乐团共有 `9` 种乐器，乐
//器编号为 `1~9`，每位成员持有 `1` 个乐器。
//
//为保证声乐混合效果，成员站位规则为：自 `grid` 左上角开始顺时针螺旋形向内循环以 `1，2，...，9` 循环重复排列。例如当 num = `5` 时
//，站位如图所示
//
//![image.png](https://pic.leetcode-cn.com/1616125411-WOblWH-image.png)
//
//
//请返回位于场地坐标 [`Xpos`,`Ypos`] 的成员所持乐器编号。
//
//**示例 1：**
//>输入：`num = 3, Xpos = 0, Ypos = 2`
//>
//>输出：`3`
//>
//>解释：
//![image.png](https://pic.leetcode-cn.com/1616125437-WUOwsu-image.png)
//
//
//**示例 2：**
//>输入：`num = 4, Xpos = 1, Ypos = 2`
//>
//>输出：`5`
//>
//>解释：
//![image.png](https://pic.leetcode-cn.com/1616125453-IIDpxg-image.png)
//
//
//**提示：**
//- `1 <= num <= 10^9`
//- `0 <= Xpos, Ypos < num` 👍 23 👎 0

package leetcode.editor.cn;

/**
 * LCP 29:乐团站位
 */
public class SNJvJP {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new SNJvJP().new Solution();
        System.out.println(solution.orchestraLayout(7466, 7084, 2520));
    }


    /**
     * 力扣代码
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int orchestraLayout(int num, int xPos, int yPos) {
            long round = Math.min(Math.min(xPos, num - xPos - 1), Math.min(yPos, num - yPos - 1));
            long length = (xPos - round) + (yPos - round);
            if (xPos > yPos) {
                round++;
            }
            long head = 4 * round * (num - round) + 1;
            int result = (int) (xPos > yPos ? (head - length) % 9 : (head + length) % 9);
            return result == 0 ? 9 : result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}