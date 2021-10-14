//将非负整数 num 转换为其对应的英文表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 123
//输出："One Hundred Twenty Three"
// 
//
// 示例 2： 
//
// 
//输入：num = 12345
//输出："Twelve Thousand Three Hundred Forty Five"
// 
//
// 示例 3： 
//
// 
//输入：num = 1234567
//输出："One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
// 
//
// 示例 4： 
//
// 
//输入：num = 1234567891
//输出："One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven 
//Thousand Eight Hundred Ninety One"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= num <= 2³¹ - 1 
// 
// Related Topics 递归 数学 字符串 👍 198 👎 0

package leetcode.editor.cn;

//273:整数转换英文表示
class IntegerToEnglishWords {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new IntegerToEnglishWords().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] thousands = {"", "Thousand", "Million", "Billion"};

        public String numberToWords(int num) {
            if (num == 0) {
                return "Zero";
            }
            StringBuffer sb = new StringBuffer();
            for (int i = 3, unit = 1000000000; i >= 0; i--, unit /= 1000) {
                int curNum = num / unit;
                if (curNum != 0) {
                    num -= curNum * unit;
                    StringBuffer curr = new StringBuffer();
                    recursion(curr, curNum);
                    curr.append(thousands[i]).append(" ");
                    sb.append(curr);
                }
            }
            return sb.toString().trim();
        }

        public void recursion(StringBuffer curr, int num) {
            if (num == 0) {
                return;
            } else if (num < 10) {
                curr.append(singles[num]).append(" ");
            } else if (num < 20) {
                curr.append(teens[num - 10]).append(" ");
            } else if (num < 100) {
                curr.append(tens[num / 10]).append(" ");
                recursion(curr, num % 10);
            } else {
                curr.append(singles[num / 100]).append(" Hundred ");
                recursion(curr, num % 100);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}