//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 队列 哈希表 字符串 计数 
// 👍 414 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//387:字符串中的第一个唯一字符
class FirstUniqueCharacterInAString{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new FirstUniqueCharacterInAString().new Solution();
    }
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
//        for (int i = 0; i < s.length(); i++) {
//            if(!s.substring(i+1).contains(""+s.charAt(i))&&!s.substring(0,i).contains(""+s.charAt(i))){
//                return i;
//            }
//        }
//        return -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}