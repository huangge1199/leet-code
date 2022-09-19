//给定一个编码字符串 S。请你找出 解码字符串 并将其写入磁带。解码时，从编码字符串中 每次读取一个字符 ，并采取以下步骤： 
//
// 
// 如果所读的字符是字母，则将该字母写在磁带上。 
// 如果所读的字符是数字（例如 d），则整个当前磁带总共会被重复写 d-1 次。 
// 
//
// 现在，对于给定的编码字符串 S 和索引 K，查找并返回解码字符串中的第 K 个字母。 
//
// 
//
// 示例 1： 
//
// 输入：S = "leet2code3", K = 10
//输出："o"
//解释：
//解码后的字符串为 "leetleetcodeleetleetcodeleetleetcode"。
//字符串中的第 10 个字母是 "o"。
// 
//
// 示例 2： 
//
// 输入：S = "ha22", K = 5
//输出："h"
//解释：
//解码后的字符串为 "hahahaha"。第 5 个字母是 "h"。
// 
//
// 示例 3： 
//
// 输入：S = "a2345678999999999999999", K = 1
//输出："a"
//解释：
//解码后的字符串为 "a" 重复 8301530446056247680 次。第 1 个字母是 "a"。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= S.length <= 100 
// S 只包含小写字母与数字 2 到 9 。 
// S 以字母开头。 
// 1 <= K <= 10^9 
// 题目保证 K 小于或等于解码字符串的长度。 
// 解码后的字符串保证少于 2^63 个字母。 
// 
// Related Topics 栈 
// 👍 135 👎 0

package leetcode.editor.cn;

//880:索引处的解码字符串
public class DecodedStringAtIndex {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new DecodedStringAtIndex().new Solution();
        //o
        System.out.println(solution.decodeAtIndex("leet2code3", 10));
        //h
        System.out.println(solution.decodeAtIndex("ha22", 5));
        //a
        System.out.println(solution.decodeAtIndex("a2345678999999999999999", 1));
        //内存溢出
        System.out.println(solution.decodeAtIndex("y959q969u3hb22odq595", 222280369));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String decodeAtIndex(String S, int K) {
//            StringBuilder str = new StringBuilder();
//            for (int i = 0; i < S.length(); i++) {
//                if (Character.isDigit(S.charAt(i))) {
//                    String temp = str.toString();
//                    for (int j = 0; j < S.charAt(i) - '0' - 1; j++) {
//                        str.append(temp);
//                        if (str.length() >= K) {
//                            return "" + str.charAt(K - 1);
//                        }
//                    }
//                } else {
//                    str.append(S.charAt(i));
//                    if (str.length() >= K) {
//                        break;
//                    }
//                }
//            }
//            return "" + str.charAt(K - 1);
            long size = 0;
            int length = S.length();

            // Find size = length of decoded string
            for (int i = 0; i < length; ++i) {
                if (Character.isDigit(S.charAt(i))) {
                    size *= S.charAt(i) - '0';
                } else {
                    size++;
                }
            }

            for (int i = length - 1; i >= 0; --i) {
                K %= size;
                if (K == 0 && Character.isLetter(S.charAt(i))) {
                    return Character.toString(S.charAt(i));
                }

                if (Character.isDigit(S.charAt(i))) {
                    size /= S.charAt(i) - '0';
                } else {
                    size--;
                }
            }

            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}