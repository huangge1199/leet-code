//对于字符串 S 和 T，只有在 S = T + ... + T（T 自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。 
//
// 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。 
//
// 
//
// 示例 1： 
//
// 
//输入：str1 = "ABCABC", str2 = "ABC"
//输出："ABC"
// 
//
// 示例 2： 
//
// 
//输入：str1 = "ABABAB", str2 = "ABAB"
//输出："AB"
// 
//
// 示例 3： 
//
// 
//输入：str1 = "LEET", str2 = "CODE"
//输出：""
// 
//
// 
//
// 提示： 
//
// 
// 1 <= str1.length <= 1000 
// 1 <= str2.length <= 1000 
// str1[i] 和 str2[i] 为大写英文字母 
// 
// Related Topics 字符串 
// 👍 194 👎 0

package leetcode.editor.cn;

//1071:字符串的最大公因子
public class GreatestCommonDivisorOfStrings {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new GreatestCommonDivisorOfStrings().new Solution();
        solution.gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX");
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //        //第一版
//        public String gcdOfStrings(String str1, String str2) {
//            int length1 = str1.length();
//            int length2 = str2.length();
//            if (length1 == length2 && !str1.equals(str2)) {
//                return "";
//            }
//            return length1 >= length2 ? get(str1, str2) : get(str2, str1);
//        }
//
//        private String get(String str1, String str2) {
//            int length1 = str1.length();
//            int length2 = str2.length();
//            if (length1 % length2 == 0) {
//                return "".equals(str1.replace(str2, "")) ? str2 : "";
//            }
//            int index = str2.lastIndexOf(str2.charAt(0));
//            String str = str2;
//            do {
//                str = str.substring(0, index);
//                if ("".equals(str1.replace(str, "")) && "".equals(str2.replace(str, ""))) {
//                    return str;
//                }
//                index = str.lastIndexOf(str2.charAt(0));
//            } while (index > 0);
//            return "";
//        }
        public String gcdOfStrings(String str1, String str2) {
            int len1 = str1.length();
            int len2 = str2.length();
            for (int i = Math.min(len1, len2); i > 0; i--) {
                if (len1 % i == 0 && len2 % i == 0) {
                    String str = str1.substring(0, i);
                    if ("".equals(str1.replace(str, "")) && "".equals(str2.replace(str, ""))) {
                        return str;
                    }
                }
            }
            return "";
        }
//        //官方
//        public String gcdOfStrings(String str1, String str2) {
//            int len1 = str1.length(), len2 = str2.length();
//            for (int i = Math.min(len1, len2); i >= 1; --i) { // 从长度大的开始枚举
//                if (len1 % i == 0 && len2 % i == 0) {
//                    String X = str1.substring(0, i);
//                    if (check(X, str1) && check(X, str2)) {
//                        return X;
//                    }
//                }
//            }
//            return "";
//        }
//
//        public boolean check(String t, String s) {
//            int lenx = s.length() / t.length();
//            StringBuffer ans = new StringBuffer();
//            for (int i = 1; i <= lenx; ++i) {
//                ans.append(t);
//            }
//            return ans.toString().equals(s);
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}