//给定一个用字符串表示的整数的嵌套列表，实现一个解析它的语法分析器。 
//
// 列表中的每个元素只可能是整数或整数嵌套列表 
//
// 提示：你可以假定这些字符串都是格式良好的： 
//
// 
// 字符串非空 
// 字符串不包含空格 
// 字符串只包含数字0-9、[、-、,、] 
// 
//
// 
//
// 示例 1： 
//
// 给定 s = "324",
//
//你应该返回一个 NestedInteger 对象，其中只包含整数值 324。
// 
//
// 示例 2： 
//
// 给定 s = "[123,[456,[789]]]",
//
//返回一个 NestedInteger 对象包含一个有两个元素的嵌套列表：
//
//1. 一个 integer 包含值 123
//2. 一个包含两个元素的嵌套列表：
//    i.  一个 integer 包含值 456
//    ii. 一个包含一个元素的嵌套列表
//         a. 一个 integer 包含值 789
// 
// Related Topics 栈 字符串 
// 👍 58 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.NestedInteger;

//385:迷你语法分析器
public class MiniParser {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new MiniParser().new Solution();
    }
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     * // Constructor initializes an empty nested list.
     * public NestedInteger();
     * <p>
     * // Constructor initializes a single integer.
     * public NestedInteger(int value);
     * <p>
     * // @return true if this NestedInteger holds a single integer, rather than a nested list.
     * public boolean isInteger();
     * <p>
     * // @return the single integer that this NestedInteger holds, if it holds a single integer
     * // Return null if this NestedInteger holds a nested list
     * public Integer getInteger();
     * <p>
     * // Set this NestedInteger to hold a single integer.
     * public void setInteger(int value);
     * <p>
     * // Set this NestedInteger to hold a nested list and adds a nested integer to it.
     * public void add(NestedInteger ni);
     * <p>
     * // @return the nested list that this NestedInteger holds, if it holds a nested list
     * // Return empty list if this NestedInteger holds a single integer
     * public List<NestedInteger> getList();
     * }
     */
    class Solution {
        public NestedInteger deserialize(String s) {
            int length = s.length();
            if (length == 0) {
                return new NestedInteger();
            }
            if (s.charAt(0) != '[') {
                return new NestedInteger(Integer.parseInt(s));
            }
            if (length == 2) {
                return new NestedInteger();
            }

            NestedInteger nestedInteger = new NestedInteger();
            int start = 1, i = 1, count = 0;
            while (i < length) {
                if (count == 0 && (s.charAt(i) == ',' || s.length() - 1 == i)) {
                    nestedInteger.add(deserialize(s.substring(start, i)));
                    start = i + 1;
                } else if (s.charAt(i) == '[') {
                    count++;
                } else if (s.charAt(i) == ']') {
                    count--;
                }
                i++;
            }
            return nestedInteger;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}