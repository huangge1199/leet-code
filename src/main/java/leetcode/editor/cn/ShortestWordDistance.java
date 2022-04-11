//给定一个字符串数组 wordDict 和两个已经存在于该数组中的不同的字符串 word1 和 word2 。返回列表中这两个单词之间的最短距离。 
//
// 
//
// 示例 1: 
//
// 
//输入: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = 
//"coding", word2 = "practice"
//输出: 3
// 
//
// 示例 2: 
//
// 
//输入: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = 
//"makes", word2 = "coding"
//输出: 1 
//
// 
//
// 提示: 
//
// 
// 1 <= wordsDict.length <= 3 * 10⁴ 
// 1 <= wordsDict[i].length <= 10 
// wordsDict[i] 由小写英文字母组成 
// word1 和 word2 在 wordsDict 中 
// word1 != word2 
// 
// Related Topics 数组 字符串 👍 90 👎 0

package leetcode.editor.cn;

//243:最短单词距离
public class ShortestWordDistance {
    public static void main(String[] args) {
        Solution solution = new ShortestWordDistance().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestDistance(String[] wordsDict, String word1, String word2) {
            int[] arrs = new int[]{-1, -1};
            int length = wordsDict.length;
            for (int i = 0; i < wordsDict.length; i++) {
                if (wordsDict[i].equals(word1)) {
                    arrs[0] = i;
                    if(arrs[1]>-1){
                        length = Math.min(length,arrs[0]-arrs[1]);
                    }
                }else if (wordsDict[i].equals(word2)) {
                    arrs[1] = i;
                    if(arrs[0]>-1){
                        length = Math.min(length,arrs[1]-arrs[0]);
                    }
                }
            }
            return length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
