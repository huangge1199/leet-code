//给定一个字符串，请将字符串里的字符按照出现的频率降序排列。 
//
// 示例 1: 
//
// 
//输入:
//"tree"
//
//输出:
//"eert"
//
//解释:
//'e'出现两次，'r'和't'都只出现一次。
//因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
// 
//
// 示例 2: 
//
// 
//输入:
//"cccaaa"
//
//输出:
//"cccaaa"
//
//解释:
//'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
//注意"cacaca"是不正确的，因为相同的字母必须放在一起。
// 
//
// 示例 3: 
//
// 
//输入:
//"Aabb"
//
//输出:
//"bbAa"
//
//解释:
//此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
//注意'A'和'a'被认为是两种不同的字符。
// 
// Related Topics 哈希表 字符串 桶排序 计数 排序 堆（优先队列） 
// 👍 310 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

//451:根据字符出现频率排序
class SortCharactersByFrequency {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new SortCharactersByFrequency().new Solution();
        System.out.println(solution.frequencySort("tree"));
        System.out.println(solution.frequencySort("raaeaedere"));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String frequencySort(String s) {
            Map<Character, Integer> map = new HashMap();
            for (char ch : s.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            HashMap<Character, Integer> mapSort = new LinkedHashMap<>();
            map.entrySet()
                    .stream()
                    .sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
                    .collect(Collectors.toList()).forEach(ele -> mapSort.put(ele.getKey(), ele.getValue()));
            StringBuilder sBuilder = new StringBuilder();
            for (char ch : mapSort.keySet()) {
                for (int i = 0; i < mapSort.get(ch); i++) {
                    sBuilder.append(ch);
                }
            }
            s = sBuilder.toString();
            return s;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}