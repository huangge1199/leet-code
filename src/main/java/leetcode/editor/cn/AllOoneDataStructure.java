//请你设计一个用于存储字符串计数的数据结构，并能够返回计数最小和最大的字符串。 
//
// 实现 AllOne 类： 
//
// 
// AllOne() 初始化数据结构的对象。 
// inc(String key) 字符串 key 的计数增加 1 。如果数据结构中尚不存在 key ，那么插入计数为 1 的 key 。 
// dec(String key) 字符串 key 的计数减少 1 。如果 key 的计数在减少后为 0 ，那么需要将这个 key 从数据结构中删除。测试用例
//保证：在减少计数前，key 存在于数据结构中。 
// getMaxKey() 返回任意一个计数最大的字符串。如果没有元素存在，返回一个空字符串 "" 。 
// getMinKey() 返回任意一个计数最小的字符串。如果没有元素存在，返回一个空字符串 "" 。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", 
//"getMinKey"]
//[[], ["hello"], ["hello"], [], [], ["leet"], [], []]
//输出
//[null, null, null, "hello", "hello", null, "hello", "leet"]
//
//解释
//AllOne allOne = new AllOne();
//allOne.inc("hello");
//allOne.inc("hello");
//allOne.getMaxKey(); // 返回 "hello"
//allOne.getMinKey(); // 返回 "hello"
//allOne.inc("leet");
//allOne.getMaxKey(); // 返回 "hello"
//allOne.getMinKey(); // 返回 "leet"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= key.length <= 10 
// key 由小写英文字母组成 
// 测试用例保证：在每次调用 dec 时，数据结构中总存在 key 
// 最多调用 inc、dec、getMaxKey 和 getMinKey 方法 5 * 10⁴ 次 
// 
// Related Topics 设计 哈希表 链表 双向链表 👍 216 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//432:全 O(1) 的数据结构
public class AllOoneDataStructure {
    public static void main(String[] args) {
//        Solution solution = new AllOoneDataStructure().new Solution();
        // TO TEST
        AllOne allOne = new AllOoneDataStructure().new AllOne();
//        allOne.inc("hello");
//        allOne.inc("goodbye");
//        allOne.inc("hello");
//        allOne.inc("hello");
//        System.out.println(allOne.getMaxKey());
//        allOne.inc("leet");
//        allOne.inc("code");
//        allOne.inc("leet");
//        allOne.dec("hello");
//        allOne.inc("leet");
//        allOne.inc("code");
//        allOne.inc("code");
//        System.out.println(allOne.getMaxKey());
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("c");
        allOne.inc("c");
        allOne.inc("c");
        allOne.dec("b");
        allOne.dec("b");
        System.out.println(allOne.getMinKey());
        allOne.dec("a");
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class AllOne {
        Map<String, Integer> map;
        int max;
        int min;
        String maxStr;
        String minStr;

        public AllOne() {
            map = new HashMap<>();
            max = -1;
            min = 100000;
            maxStr = "";
            minStr = "";
        }

        public void inc(String key) {
            map.put(key, map.getOrDefault(key, 0) + 1);
            if (key.equals(maxStr)) {
                max++;
            } else if (map.get(key) > max) {
                max = map.get(key);
                maxStr = key;
            }
            if (key.equals(minStr)) {
                min++;
                for (String k : map.keySet()) {
                    if (map.get(k) < min) {
                        min = map.get(k);
                        minStr = k;
                    }
                }
            } else if (map.get(key) < min) {
                min = map.get(key);
                minStr = key;
            }
        }

        public void dec(String key) {
            int count = map.get(key) - 1;
            if (count == 0) {
                map.remove(key);
            } else {
                map.put(key, count);
            }
            if (map.isEmpty()) {
                maxStr = "";
                max = -1;
                minStr = "";
                min = 10000;
                return;
            }
            if (maxStr.equals(key)) {
                max--;
                for (String k : map.keySet()) {
                    if (map.get(k) > max) {
                        max = map.get(k);
                        maxStr = k;
                    }
                }
            }
            if (minStr.equals(key)) {
                if (count == 0) {
                    if (map.isEmpty()) {
                        minStr = "";
                        return;
                    }
                    min = 100000;
                    for (String k : map.keySet()) {
                        if (map.get(k) < min) {
                            min = map.get(k);
                            minStr = k;
                        }
                    }
                } else {
                    min--;
                }
            }
        }

        public String getMaxKey() {
            return maxStr;
        }

        public String getMinKey() {
            return minStr;
        }
    }

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
