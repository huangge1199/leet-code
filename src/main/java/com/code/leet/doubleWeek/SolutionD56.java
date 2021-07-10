package com.code.leet.doubleWeek;

import javafx.util.Pair;

import java.util.*;

public class SolutionD56 {
    public static void main(String[] args) {
        SolutionD56 solution = new SolutionD56();
        System.out.println(solution.nearestExit(new char[][]{
                {'+', '+', '.', '+'},
                {'.', '.', '.', '+'},
                {'+', '+', '+', '.'}
        }, new int[]{1, 2}));
    }

    public int countTriples(int n) {
        int count = 0;
        for (int i = n; i > 0; i--) {
            for (int j = i - 1; j > 0; j--) {
                int sum = i * i - j * j;
                int num = (int) Math.sqrt(sum);
                if (sum == num * num) {
                    count++;
                }
            }
        }
        return count;
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int[][] counts = new int[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (i == entrance[0] && j == entrance[1]) {
                    counts[i][j] = -1;
                } else if (maze[i][j] == '.' && (j == 0 || j == maze[0].length - 1 || i == 0 || i == maze.length - 1)) {
                    queue.add(new Pair<>(i, j));
                    counts[i][j] = 0;
                } else {
                    counts[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            if (list.contains(pair)) {
                continue;
            }
            int x = pair.getKey();
            int y = pair.getValue();
            int count = counts[x][y] + 1;
            if ((Math.abs(entrance[0] - x) == 1 && entrance[1] == y) || (Math.abs(entrance[1] - y) == 1 && entrance[0] == x)) {
                return count;
            }
            if (x + 1 < maze.length && maze[x + 1][y] == '.') {
                counts[x + 1][y] = counts[x + 1][y] == -1 ? count : Math.min(count, counts[x + 1][y]);
                queue.add(new Pair<>(x + 1, y));
            }
            if (x - 1 >= 0 && maze[x - 1][y] == '.') {
                counts[x - 1][y] = counts[x - 1][y] == -1 ? count : Math.min(count, counts[x - 1][y]);
                queue.add(new Pair<>(x - 1, y));
            }
            if (y + 1 < maze[0].length && maze[x][y + 1] == '.') {
                counts[x][y + 1] = counts[x][y + 1] == -1 ? count : Math.min(count, counts[x][y + 1]);
                queue.add(new Pair<>(x, y + 1));
            }
            if (y - 1 >= 0 && maze[x][y - 1] == '.') {
                counts[x][y - 1] = counts[x][y - 1] == -1 ? count : Math.min(count, counts[x][y - 1]);
                queue.add(new Pair<>(x, y - 1));
            }
            list.add(pair);
        }
        return counts[entrance[0]][entrance[1]];
    }

    public boolean sumGame(String num) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            if (i < num.length() / 2) {
                if (Character.isDigit(ch)) {
                    sum += (ch - '0');
                } else {
                    count++;
                }
            } else {
                if (Character.isDigit(ch)) {
                    sum -= (ch - '0');
                } else {
                    count--;
                }
            }
        }
        if (count == 0) {
            return sum != 0;
        }
        return count % 2 == 1 || Math.abs(sum) <9;
    }
}
