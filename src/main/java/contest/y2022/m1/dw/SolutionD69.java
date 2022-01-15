package contest.y2022.m1.dw;

import com.code.leet.entiy.ListNode;
import com.code.leet.entiy.TwoArray;
import javafx.util.Pair;

import java.util.*;

public class SolutionD69 {
    public static void main(String[] args) {
        SolutionD69 solution = new SolutionD69();
//        System.out.println(solution.longestPalindrome(new String[]{"ll", "lb", "bb", "bx", "xx", "lx", "xx", "lx", "ll", "xb", "bx", "lb", "bb", "lb", "bl", "bb", "bx", "xl", "lb", "xx"}));
        TwoArray twoArray = new TwoArray("[[1,0,0,0],[1,0,0,0],[1,0,0,0],[1,0,0,0],[1,0,0,0]]", true);
        System.out.println(solution.possibleToStamp(twoArray.getArr(), 4, 3));
    }

    public String capitalizeTitle(String title) {
        String[] strs = title.split(" ");
        StringBuilder titleBuilder = new StringBuilder();
        for (String str : strs) {
            str = str.toLowerCase();
            if (str.length() > 2) {
                titleBuilder.append(str.substring(0, 1).toUpperCase()).append(str.substring(1)).append(" ");
            } else {
                titleBuilder.append(str).append(" ");
            }
        }
        title = titleBuilder.toString();
        return title.substring(0, title.length() - 1);
    }

    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int max = 0;
        for (int i = 0; i < list.size() / 2; i++) {
            max = Math.max(max, list.get(i) + list.get(list.size() - 1 - i));
        }
        return max;
    }

    public int longestPalindrome(String[] words) {
        List<String> list = Arrays.asList(words);
        Collections.sort(list);
        boolean[] use = new boolean[list.size()];
        int length = 0;
        boolean bl = false;
        int bef = -1;
        for (int i = 0; i < list.size(); i++) {
            if (use[i]) {
                continue;
            }
            String str = list.get(i);
            if (str.charAt(0) == str.charAt(1)) {
                if (i + 1 < list.size() && str.equals(list.get(i + 1))) {
                    length += 4;
                    use[i] = true;
                    use[i + 1] = true;
                } else {
                    length = bl ? length : length + 2;
                    bl = true;
                    use[i] = true;
                }
            } else {
                String restr = new StringBuilder(list.get(i)).reverse().toString();
                if (i > 0 && list.get(i - 1).equals(list.get(i))) {
                    if (bef + 1 < list.size() && list.get(bef + 1).equals(restr)) {
                        use[i] = true;
                        use[bef + 1] = true;
                        length += 4;
                        bef += 1;
                    }
                } else {
                    int index = list.indexOf(restr);
                    if (index > 0 && !use[index]) {
                        use[i] = true;
                        use[index] = true;
                        length += 4;
                        bef = index;
                    }
                }
            }
        }
        return length;
    }

    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int xl = grid.length;
        int yl = grid[0].length;
        int[][] use = new int[xl][yl];
        for (int i = 0; i < xl; i++) {
            for (int j = 0; j < yl; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                if (i + stampHeight > xl || j + stampWidth > yl) {
                    if (use[i][j] == 0) {
                        return false;
                    }
                    continue;
                }
                int[][] temp = new int[xl][yl];
                boolean bl = false;
                for (int k = 0; k < stampHeight; k++) {
                    for (int l = 0; l < stampWidth; l++) {
                        if (grid[i + k][j + l] == 1) {
                            if (use[i][j] == 0) {
                                return false;
                            }
                            bl = true;
                        }
                        if (use[i + k][j + l] == 1) {
                            continue;
                        }
                        temp[i + k][j + l] = 1;
                    }
                }
                if (bl) {
                    continue;
                }
                for (int k = 0; k < stampHeight; k++) {
                    for (int l = 0; l < stampWidth; l++) {
                        if (temp[i + k][j + l] == 1) {
                            use[i + k][j + l] = 1;
                        }
                    }
                }

            }
        }
        return true;
    }
}
