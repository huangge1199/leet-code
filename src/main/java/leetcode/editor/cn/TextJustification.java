//给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。 
//
// 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。 
//
// 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。 
//
// 文本的最后一行应为左对齐，且单词之间不插入额外的空格。 
//
// 说明: 
//
// 
// 单词是指由非空格字符组成的字符序列。 
// 每个单词的长度大于 0，小于等于 maxWidth。 
// 输入单词数组 words 至少包含一个单词。 
// 
//
// 示例: 
//
// 输入:
//words = ["This", "is", "an", "example", "of", "text", "justification."]
//maxWidth = 16
//输出:
//[
//   "This    is    an",
//   "example  of text",
//   "justification.  "
//]
// 
//
// 示例 2: 
//
// 输入:
//words = ["What","must","be","acknowledgment","shall","be"]
//maxWidth = 16
//输出:
//[
//  "What   must   be",
//  "acknowledgment  ",
//  "shall be        "
//]
//解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
//     因为最后一行应为左对齐，而不是左右两端对齐。       
//     第二行同样为左对齐，这是因为这行只包含一个单词。
// 
//
// 示例 3: 
//
// 输入:
//words = ["Science","is","what","we","understand","well","enough","to",
//"explain",
//         "to","a","computer.","Art","is","everything","else","we","do"]
//maxWidth = 20
//输出:
//[
//  "Science  is  what we",
//  "understand      well",
//  "enough to explain to",
//  "a  computer.  Art is",
//  "everything  else  we",
//  "do                  "
//]
// 
// Related Topics 字符串 模拟 👍 149 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//68:文本左右对齐
class TextJustification {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new TextJustification().new Solution();
        System.out.println(solution.fullJustify(new String[]{"This", "is", "an", "example", "of",
                "text", "justification."}, 16));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> result = new ArrayList<>();
            List<String> lines = new ArrayList<>();
            int size = 0;
            for (String word : words) {
                if (size + word.length() > maxWidth) {
                    StringBuilder line = new StringBuilder();
                    if (lines.size() == 1) {
                        line.append(lines.get(0));
                        int temp = maxWidth - line.length();
                        for (int j = 0; j < temp; j++) {
                            line.append(" ");
                        }
                    } else {
                        int dev = (maxWidth - size + 1) / (lines.size() - 1);
                        int mod = (maxWidth - size + 1) % (lines.size() - 1);
                        StringBuilder space = new StringBuilder();
                        for (int j = 0; j <= dev; j++) {
                            space.append(" ");
                        }
                        for (int j = 0; j < lines.size() - 1; j++) {
                            String str = lines.get(j);
                            if (j < mod) {
                                str += space + " ";
                            } else {
                                str += space;
                            }
                            line.append(str);
                        }
                        line.append(lines.get(lines.size() - 1));
                    }
                    result.add(line.toString());
                    lines = new ArrayList<>();
                    size = 0;
                }
                lines.add(word);
                size += word.length() + 1;
            }
            StringBuilder str = new StringBuilder();
            for (String line : lines) {
                str.append(line).append(" ");
            }
            str = new StringBuilder(str.substring(0, str.length() - 1));
            size = maxWidth - str.length();
            for (int i = 0; i < size; i++) {
                str.append(" ");
            }
            result.add(str.toString());
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}