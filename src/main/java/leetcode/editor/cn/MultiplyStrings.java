//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串 
// 👍 625 👎 0

package leetcode.editor.cn;

//43:字符串相乘
public class MultiplyStrings {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new MultiplyStrings().new Solution();
        //6
        System.out.println(solution.multiply("2", "3"));
        //56088
        System.out.println(solution.multiply("123", "456"));
        //81
        System.out.println(solution.multiply("9", "9"));
        //891
        System.out.println(solution.multiply("9", "99"));
        //0
        System.out.println(solution.multiply("9133", "0"));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            if ("0".equals(num1) || "0".equals(num2)) {
                return "0";
            }
            if (num1.length() < num2.length()) {
                String temp = num1;
                num1 = num2;
                num2 = temp;
            }
            int l1 = num1.length();
            int l2 = num2.length();
            int length = l1 + l2 - 1;
            int sum = 0, n1, n2;
            StringBuilder str = new StringBuilder();
            for (int i = 1; i <= length; i++) {
                for (int j = Math.min(i, l1); j >= (i <= l1 ? 1 : i - l1 + 1) && i + 1 - j <= l2; j--) {
                    n1 = num1.charAt(l1 - j) - '0';
                    n2 = num2.charAt(l2 - i - 1 + j) - '0';
                    sum += n1 * n2;
                }
                str.insert(0, sum % 10);
                sum = sum / 10;
            }
            if (sum > 0) {
                str.insert(0, sum);
            }
            return str.toString();

//            if (num1.equals("0") || num2.equals("0")) {
//                return "0";
//            }
//            int[] res = new int[num1.length() + num2.length()];
//            for (int i = num1.length() - 1; i >= 0; i--) {
//                int n1 = num1.charAt(i) - '0';
//                for (int j = num2.length() - 1; j >= 0; j--) {
//                    int n2 = num2.charAt(j) - '0';
//                    int sum = (res[i + j + 1] + n1 * n2);
//                    res[i + j + 1] = sum % 10;
//                    res[i + j] += sum / 10;
//                }
//            }
//
//            StringBuilder result = new StringBuilder();
//            for (int i = 0; i < res.length; i++) {
//                if (i == 0 && res[i] == 0) {
//                    continue;
//                }
//                result.append(res[i]);
//            }
//            return result.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}