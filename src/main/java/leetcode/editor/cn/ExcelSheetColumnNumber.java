//给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。 
//
// 
//
// 例如， 
//
// 
//    A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28 
//    ...
// 
//
// 
//
// 示例 1: 
//
// 
//输入: columnTitle = "A"
//输出: 1
// 
//
// 示例 2: 
//
// 
//输入: columnTitle = "AB"
//输出: 28
// 
//
// 示例 3: 
//
// 
//输入: columnTitle = "ZY"
//输出: 701 
//
// 示例 4: 
//
// 
//输入: columnTitle = "FXSHRXW"
//输出: 2147483647
// 
//
// 
//
// 提示： 
//
// 
// 1 <= columnTitle.length <= 7 
// columnTitle 仅由大写英文组成 
// columnTitle 在范围 ["A", "FXSHRXW"] 内 
// 
// Related Topics 数学 字符串 
// 👍 260 👎 0

package leetcode.editor.cn;

//171:Excel 表列序号
public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ExcelSheetColumnNumber().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int titleToNumber(String columnTitle) {
            char[] chs = columnTitle.toCharArray();
            int result = 0;
            int size = chs.length - 1;
            int mul = 1;
            for (int i = 0; i <= size; i++) {
                int num = chs[size - i] - 'A' + 1;
                result += num * mul;
                mul *= 26;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}