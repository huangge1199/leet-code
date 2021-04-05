package leetcode.editor.cn;
//给定一个整数数组 asteroids，表示在同一行的行星。
//
// 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。 
//
// 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞
//。 
//
// 
//
// 示例 1： 
//
// 
//输入：asteroids = [5,10,-5]
//输出：[5,10]
//解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。 
//
// 示例 2： 
//
// 
//输入：asteroids = [8,-8]
//输出：[]
//解释：8 和 -8 碰撞后，两者都发生爆炸。 
//
// 示例 3： 
//
// 
//输入：asteroids = [10,2,-5]
//输出：[10]
//解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。 
//
// 示例 4： 
//
// 
//输入：asteroids = [-2,-1,1,2]
//输出：[-2,-1,1,2]
//解释：-2 和 -1 向左移动，而 1 和 2 向右移动。 由于移动方向相同的行星不会发生碰撞，所以最终没有行星发生碰撞。 
//
// 
//
// 提示： 
//
// 
// 2 <= asteroids.length <= 104 
// -1000 <= asteroids[i] <= 1000 
// asteroids[i] != 0 
// 
// Related Topics 栈 
// 👍 135 👎 0

import java.util.Stack;

public class AsteroidCollision{
        public static void main(String[] args) {
            Solution solution = new AsteroidCollision().new Solution();
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int num : asteroids) {
            boolean isIn = true;
            while (!stack.isEmpty() && num < 0 && stack.peek() > 0) {
                if (num + stack.peek() < 0) {
                    stack.pop();
                } else if (num + stack.peek() > 0) {
                    isIn = false;
                    break;
                } else {
                    isIn = false;
                    stack.pop();
                    break;
                }
            }
            if (isIn) {
                stack.push(num);
            }
        }
        int size = stack.size();
        asteroids = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            asteroids[i] = stack.pop();
        }
        return asteroids;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
