package contest.y2022.m6.dw;

import com.code.leet.entiy.TwoArray;

import java.util.*;

public class Solution80 {

    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }
        String str = "!@#$%^&*()-+";
        boolean[] bl = new boolean[4];
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (i > 0 && ch == password.charAt(i - 1)) {
                return false;
            }
            if (!bl[0] && ch <= 'z' && ch >= 'a') {
                bl[0] = true;
            } else if (!bl[1] && ch <= 'Z' && ch >= 'A') {
                bl[1] = true;
            } else if (!bl[2] && Character.isDigit(ch)) {
                bl[2] = true;
            } else if (!bl[3] && str.contains(ch + "")) {
                bl[3] = true;
            }
        }
        return bl[0] && bl[1] && bl[2] && bl[3];
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] result = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];
            int left = 0;
            int right = potions.length - 1;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                long mul = (long) spell * potions[mid];
                if (mul < success) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if ((long) spell * potions[right] >= success) {
                result[i] = potions.length - right;
            } else {
                result[i] = potions.length - right - 1;
            }
        }
        return result;
    }

    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        if (sub.length() > s.length()) {
            return false;
        }
        Map<Character, List<Character>> map = new HashMap<>();
        for (int i = 0; i < sub.length(); i++) {
            map.put(sub.charAt(i), new ArrayList<>());
        }
        for (char[] mapping : mappings) {
            if (map.containsKey(mapping[0])) {
                map.get(mapping[0]).add(mapping[1]);
            }
        }
        for (char key: map.keySet()){
            if(map.get(key).size()==0){
                continue;
            }

        }
        int index = s.indexOf(sub.charAt(0));
        while (index >= 0 && s.length() - index >= sub.length()) {
            s = s.substring(index);
            boolean bl = true;
            for (int i = 0; i < sub.length(); i++) {
                if (sub.charAt(i) == s.charAt(i)) {
                    continue;
                }
                if (!map.get(sub.charAt(i)).contains(s.charAt(i))) {
                    bl = false;
                    break;
                }
            }
            if (bl) {
                return true;
            }
            s = s.substring(1);
            index = s.indexOf(sub.charAt(0));
        }
        return false;
    }

    public static void main(String[] args) {
        Solution80 solution = new Solution80();
        //solution.strongPasswordCheckerII("aA0!bB1@@3rbHkB8Puvl");
        char[][] mappings = {{'e','3'},{'t','7'},{'t','8'}};
        solution.matchReplacement("fool3e7bar","leet",mappings);
    }
}
