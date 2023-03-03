//<p>二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字无法精确地用32位以内的二进制表示，则打印“ERROR”。</p>
//
//<p><strong>示例1:</strong></p>
//
//<pre>
//<strong> 输入</strong>：0.625
//<strong> 输出</strong>："0.101"
//</pre>
//
//<p><strong>示例2:</strong></p>
//
//<pre>
//<strong> 输入</strong>：0.1
//<strong> 输出</strong>："ERROR"
//<strong> 提示</strong>：0.1无法被二进制准确表示
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li>32位包括输出中的 <code>"0."</code> 这两位。</li> 
// <li>题目保证输入用例的小数位数最多只有 <code>6</code> 位</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>位运算</li><li>数学</li><li>字符串</li></div></div><br><div><li>👍 99</li><li>👎 0</li></div>
package leetcode.editor.cn;

// 面试题 05.02:二进制数转字符串
public class BianryNumberToStringLcci {
    public static void main(String[] args) {
        Solution solution = new BianryNumberToStringLcci().new Solution();
        // TO TEST
        solution.printBin(0.625);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String printBin(double num) {
            String str = "0.";
            String strNum = "" + num;
            while (strNum.endsWith("0")) {
                strNum = strNum.substring(0, strNum.length() - 1);
            }
            while (num > 0 && strNum.endsWith("5")) {
                num *= 2;
                if (num >= 1) {
                    str += 1;
                    num -= 1;
                } else {
                    str += 0;
                }
                strNum = "" + num;
                while (strNum.endsWith("0")) {
                    strNum = strNum.substring(0, strNum.length() - 1);
                }
            }
            return strNum.equals("0.") ? str : "ERROR";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
