//给定一个正整数，返回它在 Excel 表中相对应的列名称。 
//
// 例如， 
//
//     1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB 
//    ...
// 
//
// 示例 1: 
//
// 输入: 1
//输出: "A"
// 
//
// 示例 2: 
//
// 输入: 28
//输出: "AB"
// 
//
// 示例 3: 
//
// 输入: 701
//输出: "ZY"
// 
// Related Topics 数学 字符串 
// 👍 370 👎 0

package leetcode.editor.cn;

//168:Excel表列名称
public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ExcelSheetColumnTitle().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToTitle(int columnNumber) {
            StringBuilder result = new StringBuilder();
            while (columnNumber > 0) {
                int num = (columnNumber - 1) % 26 + 1;
                result.insert(0, (char)((num - 1) + 'A'));
                columnNumber = (columnNumber - num) / 26;
            }
            return result.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}