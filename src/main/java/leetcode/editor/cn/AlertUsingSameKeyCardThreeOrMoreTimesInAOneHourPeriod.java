//<p>力扣公司的员工都使用员工卡来开办公室的门。每当一个员工使用一次他的员工卡，安保系统会记录下员工的名字和使用时间。如果一个员工在一小时时间内使用员工卡的次数大于等于三次，这个系统会自动发布一个 <strong>警告</strong>&nbsp;。</p>
//
//<p>给你字符串数组&nbsp;<code>keyName</code>&nbsp;和&nbsp;<code>keyTime</code> ，其中&nbsp;<code>[keyName[i], keyTime[i]]</code>&nbsp;对应一个人的名字和他在&nbsp;<strong>某一天</strong> 内使用员工卡的时间。</p>
//
//<p>使用时间的格式是 <strong>24小时制</strong>&nbsp;，形如<strong>&nbsp;"HH:MM"</strong>&nbsp;，比方说&nbsp;<code>"23:51"</code> 和&nbsp;<code>"09:49"</code>&nbsp;。</p>
//
//<p>请你返回去重后的收到系统警告的员工名字，将它们按 <strong>字典序</strong><strong>升序&nbsp;</strong>排序后返回。</p>
//
//<p>请注意&nbsp;<code>"10:00"</code> - <code>"11:00"</code>&nbsp;视为一个小时时间范围内，而&nbsp;<code>"23:51"</code> - <code>"00:10"</code>&nbsp;不被视为一小时内，因为系统记录的是某一天内的使用情况。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>keyName = ["daniel","daniel","daniel","luis","luis","luis","luis"], keyTime = ["10:00","10:40","11:00","09:00","11:00","13:00","15:00"]
//<strong>输出：</strong>["daniel"]
//<strong>解释：</strong>"daniel" 在一小时内使用了 3 次员工卡（"10:00"，"10:40"，"11:00"）。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>keyName = ["alice","alice","alice","bob","bob","bob","bob"], keyTime = ["12:01","12:00","18:00","21:00","21:20","21:30","23:00"]
//<strong>输出：</strong>["bob"]
//<strong>解释：</strong>"bob" 在一小时内使用了 3 次员工卡（"21:00"，"21:20"，"21:30"）。
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>keyName = ["john","john","john"], keyTime = ["23:58","23:59","00:01"]
//<strong>输出：</strong>[]
//</pre>
//
//<p><strong>示例 4：</strong></p>
//
//<pre>
//<strong>输入：</strong>keyName = ["leslie","leslie","leslie","clare","clare","clare","clare"], keyTime = ["13:00","13:20","14:00","18:00","18:51","19:30","19:49"]
//<strong>输出：</strong>["clare","leslie"]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= keyName.length, keyTime.length &lt;= 10<sup>5</sup></code></li> 
// <li><code>keyName.length == keyTime.length</code></li> 
// <li><code>keyTime</code> 格式为&nbsp;<strong>"HH:MM"&nbsp;</strong>。</li> 
// <li>保证&nbsp;<code>[keyName[i], keyTime[i]]</code>&nbsp;形成的二元对&nbsp;<strong>互不相同&nbsp;</strong>。</li> 
// <li><code>1 &lt;= keyName[i].length &lt;= 10</code></li> 
// <li><code>keyName[i]</code>&nbsp;只包含小写英文字母。</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>字符串</li><li>排序</li></div></div><br><div><li>👍 42</li><li>👎 0</li></div>
package leetcode.editor.cn;

import java.util.*;

// 1604:警告一小时内使用相同员工卡大于等于三次的人
public class AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod {
    public static void main(String[] args) {
        Solution solution = new AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> alertNames(String[] keyName, String[] keyTime) {
            Map<String, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < keyName.length; i++) {
                String time = keyTime[i];
                int num = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
                List<Integer> list = map.getOrDefault(keyName[i], new ArrayList<>());
                list.add(num);
                map.put(keyName[i], list);
            }
            List<String> res = new ArrayList<>();
            for (String name : map.keySet()) {
                List<Integer> list = map.get(name);
                Collections.sort(list);
                for (int i = 0; i < list.size() - 2; i++) {
                    if (list.get(i + 2) - list.get(i) <= 60) {
                        res.add(name);
                        break;
                    }
                }
            }
            Collections.sort(res);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
