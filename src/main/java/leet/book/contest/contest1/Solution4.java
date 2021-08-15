package leet.book.contest.contest1;

public class Solution4 {
    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        System.out.println(solution.solve("kyClMl"));
    }

    public String solve(String s) {
        char[] chs = s.toCharArray();
        int start = -1;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] > 'Z' && start != -1) {
                char ch = chs[i];
                if (i - start >= 0) System.arraycopy(chs, start, chs, start + 1, i - start);
                chs[start] = ch;
                start++;
            } else if (chs[i] <= 'Z') {
                if (start == -1) {
                    start = i;
                }
            }
        }
        StringBuilder sBuilder = new StringBuilder();
        for (char ch : chs) {
            sBuilder.append(ch);
        }
        return sBuilder.toString();
    }
}
