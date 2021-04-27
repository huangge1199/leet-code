//有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。 
//
// 示例1: 
//
//  输入：S = "qqe"
// 输出：["eqq","qeq","qqe"]
// 
//
// 示例2: 
//
//  输入：S = "ab"
// 输出：["ab", "ba"]
// 
//
// 提示: 
//
// 
// 字符都是英文字母。 
// 字符串长度在[1, 9]之间。 
// 
// Related Topics 回溯算法 
// 👍 37 👎 0

package leetcode.editor.cn;

import java.util.*;

//面试题 08.08:有重复字符串的排列组合
public class PermutationIiLcci {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PermutationIiLcci().new Solution();
        solution.permutation("ab");
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> list;

        public String[] permutation(String S) {
            list = new ArrayList<>();
            char[] str = S.toCharArray();
            Arrays.sort(str);
            boolean[] visited = new boolean[str.length];
            dfs(str, visited, new StringBuilder());
            return list.toArray(new String[0]);
        }

        private void dfs(char[] str, boolean visited[], StringBuilder temp) {
            if (temp.length() == str.length) {
                list.add(temp.toString());
                return;
            }
            for (int i = 0; i < str.length; i++) {
                if (visited[i] || i != 0 && !visited[i - 1] && str[i] == str[i - 1]) {
                    continue;
                }
                temp.append(str[i]);
                visited[i] = true;
                dfs(str, visited, temp);
                temp.deleteCharAt(temp.length() - 1);
                visited[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}