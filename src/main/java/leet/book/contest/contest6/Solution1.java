package leet.book.contest.contest6;

public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
    }

    public int solve(int num) {
        int count = 0;
        while (num >= 5) {
            count += num / 5 * 2;
            num = num % 5 + num / 5 * 2;
        }
        while (num >= 3) {
            count += num / 3;
            num = num % 3 + num / 3;
        }
        return count;
    }
}

