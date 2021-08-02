//给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。 
//
// 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 
//输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3000 
// s 仅由数字组成 
// 
// Related Topics 字符串 回溯 
// 👍 638 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//93:复原 IP 地址
public class RestoreIpAddresses {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new RestoreIpAddresses().new Solution();
        solution.restoreIpAddresses("0279245587303");
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<String> list;

        public List<String> restoreIpAddresses(String s) {
            if ("".equals(s) || s.length() > 12) {
                return new ArrayList<>();
            }
            list = new ArrayList<>();
            dfs(s, 1, 0, -1, "" + s.charAt(0));
            return list;
        }

        private void dfs(String s, int index, int count, int pos, String str) {
            if (count == 3) {
                str += s.substring(str.length() - 3);
                String num = str.substring(str.lastIndexOf(".") + 1);
                if (num.length() == 1 || num.length() < 4 && !num.startsWith("0") && (Integer.parseInt(num) <= 255)) {
                    list.add(str);
                }
                return;
            }
            if (str.length() == s.length() + 3 || index == s.length()) {
                return;
            }
            int cur = Integer.parseInt(s.substring(Math.max(pos, 0), index + 1));
            int bef = Integer.parseInt(s.substring(Math.max(pos, 0), index));
            if (cur <= 255 && bef > 0) {
                dfs(s, index + 1, count, pos, str + s.charAt(index));
            }
            dfs(s, index + 1, count + 1, index, str + "." + s.charAt(index));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}