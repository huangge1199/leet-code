//假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。 
//
// 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。 
//
// 示例 1: 
//
// 输入:
//["Shogun", "Tapioca Express", "Burger King", "KFC"]
//["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
//输出: ["Shogun"]
//解释: 他们唯一共同喜爱的餐厅是“Shogun”。
// 
//
// 示例 2: 
//
// 输入:
//["Shogun", "Tapioca Express", "Burger King", "KFC"]
//["KFC", "Shogun", "Burger King"]
//输出: ["Shogun"]
//解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
// 
//
// 提示: 
//
// 
// 两个列表的长度范围都在 [1, 1000]内。 
// 两个列表中的字符串的长度将在[1，30]的范围内。 
// 下标从0开始，到列表的长度减1。 
// 两个列表都没有重复的元素。 
// 
// Related Topics 数组 哈希表 字符串 
// 👍 112 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//599:两个列表的最小索引总和
public class MinimumIndexSumOfTwoLists {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new MinimumIndexSumOfTwoLists().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            List<String> listS1 = new ArrayList<>(Arrays.asList(list1));
            List<String> listS2 = new ArrayList<>(Arrays.asList(list2));
            List<String> list = new ArrayList<>();
            int min = list1.length + list2.length;
            for (int i = 0; i < listS2.size(); i++) {
                int index = listS1.indexOf(listS2.get(i));
                if (index >= 0) {
                    if (list.isEmpty() || index + i < min) {
                        list = new ArrayList<>();
                        list.add(listS2.get(i));
                        min = index + i;
                    } else if (index + i == min) {
                        list.add(listS2.get(i));
                    }
                }
            }
            String[] strs = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                strs[i] = list.get(i);
            }
            return strs;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}