//二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
// 
//
// 
// 例如，下面的二进制手表读取 "3:25" 。 
// 
//
// 
//
// （图源：WikiMedia - Binary clock samui moon.jpg ，许可协议：Attribution-ShareAlike 3.0 
//Unported (CC BY-SA 3.0) ） 
//
// 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。 
//
// 小时不会以零开头： 
//
// 
// 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。 
// 
//
// 分钟必须由两位数组成，可能会以零开头： 
//
// 
// 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：turnedOn = 1
//输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
// 
//
// 示例 2： 
//
// 
//输入：turnedOn = 9
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= turnedOn <= 10 
// 
// Related Topics 位运算 回溯 👍 356 👎 0

package leetcode.editor.cn;

import java.util.*;

//401:二进制手表
public class BinaryWatch {
    public static void main(String[] args) {
        Solution solution = new BinaryWatch().new Solution();
        // TO TEST
        System.out.println(solution.readBinaryWatch(2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> readBinaryWatch(int turnedOn) {
            if (turnedOn > 8) {
                return new ArrayList<>();
            }
            Map<Integer, Set<Integer>> map1 = getNums(4, turnedOn);
            Map<Integer, Set<Integer>> map2 = getNums(6, turnedOn);
            List<String> list = new ArrayList<>();
            for (int key : map1.keySet()) {
                if (turnedOn - key >= 6) {
                    continue;
                }
                for (int hour : map1.get(key)) {
                    for (int mini : map2.get(turnedOn - key)) {
                        list.add(hour + ":" + String.format("%02d", mini));
                    }
                }
            }
            return list;
        }

        private Map<Integer, Set<Integer>> getNums(int line, int turnedOn) {
            Map<Integer, Set<Integer>> map = new HashMap<>(line);
            int[] arrs = new int[line];
            arrs[0] = 1;
            for (int i = 1; i < line; i++) {
                arrs[i] = 2 * arrs[i - 1];
            }
            for (int i = 0; i <= Math.min(line, turnedOn); i++) {
                if (i == 0) {
                    map.put(i, new HashSet<>(Collections.singletonList(0)));
                } else {
                    Set<Integer> set = map.get(i - 1);
                    Set<Integer> cur = new HashSet<>();
                    for (int num : set) {
                        for (int j = 0; j < line; j++) {
                            if ((num & arrs[j]) == 0) {
                                if (line == 4 && (num | arrs[j]) < 12) {
                                    cur.add(num | arrs[j]);
                                } else if (line == 6 && (num | arrs[j]) < 60) {
                                    cur.add(num | arrs[j]);
                                }
                            }
                        }
                    }
                    map.put(i, cur);
                }
            }
            return map;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
