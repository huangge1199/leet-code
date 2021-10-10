//给你 二维 平面上两个 由直线构成的 矩形，请你计算并返回两个矩形覆盖的总面积。 
//
// 每个矩形由其 左下 顶点和 右上 顶点坐标表示： 
//
// 
// 
// 第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。 
// 第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义。 
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
//输出：45
// 
//
// 示例 2： 
//
// 
//输入：ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
//输出：16
// 
//
// 
//
// 提示： 
//
// 
// -10⁴ <= ax1, ay1, ax2, ay2, bx1, by1, bx2, by2 <= 10⁴ 
// 
// Related Topics 几何 数学 👍 128 👎 0

package leetcode.editor.cn;

//223:矩形面积
class RectangleArea {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new RectangleArea().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
                return (ax2 - ax1) * (ay2 - ay1)
                        + (bx2 - bx1) * (by2 - by1)
                        - Math.max(Math.min(ax2, bx2) - Math.max(ax1, bx1),0)
                        * Math.max(Math.min(ay2, by2) - Math.max(ay1, by1),0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}