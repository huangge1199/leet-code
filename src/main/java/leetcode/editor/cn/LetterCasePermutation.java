//给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。 
//
// 
//
// 示例：
//输入：S = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
//
//输入：S = "3z4"
//输出：["3z4", "3Z4"]
//
//输入：S = "12345"
//输出：["12345"]
// 
//
// 
//
// 提示： 
//
// 
// S 的长度不超过12。 
// S 仅由数字和字母组成。 
// 
// Related Topics 位运算 字符串 回溯 
// 👍 282 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//784:字母大小写全排列
class LetterCasePermutation{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new LetterCasePermutation().new Solution();
        solution.letterCasePermutation("a1b2");
    }
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCasePermutation(String s) {
        char[] chs = s.toCharArray();
        List<char[]> list = new ArrayList<>();
        list.add(chs);
        for (int i = 0; i < chs.length; i++) {
            if(Character.isDigit(chs[i])){
                continue;
            }
            List<char[]> temp = new ArrayList<>();
            for (char[] chList:list) {
                temp.add(chList);
                if(chList[i]<'a'){
                    chList[i] += 32;
                    temp.add(chList);
                }else {
                    chList[i] -= 32;
                    temp.add(chList);
                }
            }
            list = temp;
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            result.add(new String(list.get(i)));
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}