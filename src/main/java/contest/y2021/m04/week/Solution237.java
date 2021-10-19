package contest.y2021.m04.week;

import java.util.*;

/**
 * @Author: 轩辕龙儿
 * @Date: 2021/4/18 10:30
 * @Description:
 */
public class Solution237 {
    public boolean checkIfPangram(String sentence) {
        List<Character> list = new ArrayList<>();
        int num = 0;
        for (char ch : sentence.toCharArray()) {
            if (ch >= 'a' && ch <= 'z' && !list.contains(ch)) {
                list.add(ch);
                num++;
            }
        }
        return num == 26;
    }

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int num = 0;
        for (int i = 0; i < costs.length; i++) {
            coins -= costs[i];
            if (coins < 0) {
                break;
            }
            num++;
        }
        return num;
    }
}
