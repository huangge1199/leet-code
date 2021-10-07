//统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。 
//
// 请注意，你可以假定字符串里不包括任何不可打印的字符。 
//
// 示例: 
//
// 输入: "Hello, my name is John"
//输出: 5
//解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
// 
// Related Topics 字符串 👍 144 👎 0

package leetcode.editor.cn;

//434:字符串中的单词数
class NumberOfSegmentsInAString {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new NumberOfSegmentsInAString().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSegments(String s) {
            String[] strs = s.split(" ");
            int count = 0;
            for (String str : strs) {
                if (!"".equals(str)) {
                    count++;
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}