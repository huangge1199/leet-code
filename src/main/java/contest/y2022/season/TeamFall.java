package contest.y2022.season;

import java.util.*;

public class TeamFall {

    public static void main(String[] args) {
        TeamFall solution = new TeamFall();
    }

    public int minNumBooths(String[] demand) {
        Map<Character, Integer> map = new HashMap<>();
        for (String str : demand) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            int cnt = 1;
            char ch = chs[0];
            for (int i = 1; i < chs.length; i++) {
                if (chs[i] == ch) {
                    cnt++;
                } else {
                    int num = map.getOrDefault(ch, 0);
                    num = Math.max(num, cnt);
                    map.put(ch, num);
                    cnt = 1;
                    ch = chs[i];
                }
            }
            int num = map.getOrDefault(ch, 0);
            num = Math.max(num, cnt);
            map.put(ch, num);
        }
        int cnt = 0;
        for (char key : map.keySet()) {
            cnt += map.get(key);
        }
        return cnt;
    }

    public int Leetcode(String[] words) {
        int[] chs = new int[26];
        String word = "helloleetcode";
        for (char ch : word.toCharArray()) {
            chs[ch - 'a']++;
        }
        return dfs(words, chs);
    }

    int max = 0;
    List<Character> list = Arrays.asList('h', 'e', 'l', 'o', 't', 'c', 'd');

    private int dfs(String[] words, int[] chs) {
        for (int i = 0; i < 8; i++) {
            int[] tmps = new int[26];
            for (int j = 0; j < words.length; j++) {
                if ((words[j].length() + 1) / 2 <= i) {
                    continue;
                }
                char ch = words[j].charAt(i);
                if (list.contains(ch)) {
                    tmps[ch - 'a']++;
                }
            }

        }
        return 0;
    }
}
