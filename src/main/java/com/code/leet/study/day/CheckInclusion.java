package com.code.leet.study.day;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 示例1:
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *  
 * <p>
 * 示例2:
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *  
 * <p>
 * 注意：
 * <p>
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckInclusion {
    /**
     * 567. 字符串的排列
     */
    public static boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        Map<String, Integer> m1 = new HashMap<>(l1);
        if (l1 > l2) {
            return false;
        }
        for (int i = 0; i < l1; i++) {
            String ch = String.valueOf(s1.charAt(i));
            m1.put(ch, m1.get(ch) == null ? 1 : m1.get(ch) + 1);
        }
        int count = l2 - l1;
        for (int i = 0; i <= count; i++) {
            String str = s2.substring(i, i + l1);
            boolean bl = true;
            for (String ch : m1.keySet()) {
                String temp = str.replace(ch, "");
                if (l1 - temp.length() != m1.get(ch)) {
                    bl = false;
                    break;
                }
            }
            if (bl) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        checkInclusion(s1, s2);
    }
}
