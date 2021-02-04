package com.code.lint.y2020.m04.d026;

/**
 * 1479. 能否到达终点
 *
 * @Author: hyy
 * @Date: 2020-04-26 14:54
 */
public class ReachEndpoint {
    /**
     * @param map: the map
     * @return: can you reach the endpoint
     */
    public static boolean reachEndpoint(int[][] map) {
        // Write your code here
        return reach(0, 0, map);
    }

    private static boolean reach(int x, int y, int[][] map) {
        boolean result = false;
        if (map[x][y] == 9) {
            return true;
        }
        if (x + 1 < map[0].length && map[x + 1][y] > 0) {
            result = result || reach(x + 1, y, map);
        }
        if (y + 1 < map.length && map[x][y + 1] > 0) {
            result = result || reach(x, y + 1, map);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] map = new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 9}};
        System.out.println(reachEndpoint(map));
    }
}
