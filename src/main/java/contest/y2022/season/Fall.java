package contest.y2022.season;

import javafx.util.Pair;

import java.util.*;

public class Fall {
    public static void main(String[] args) {
        Fall solution = new Fall();
        //int[] temperatureA = new int[]{5, 10, 16, -6, 15, 11, 3};
        //int[] temperatureB = new int[]{16, 22, 23, 23, 25, 3, -16};
        //solution.temperatureTrend(temperatureA, temperatureB);

        //int[][] path = new int[][]{{0, 1}, {0, 3}, {1, 3}, {2, 0}, {2, 3}};
        //solution.transportationHub(path);

        String[] plate = new String[]{".....", "..E..", ".WO..", "....."};
        solution.ballGame(5, plate);
    }

    class Nums {
        int x;
        int y;
        int index;

        public Nums(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    public int[][] ballGame(int num, String[] plate) {
        Queue<Nums> queue = new LinkedList<>();
        int xl = plate.length;
        int yl = plate[0].length();
        char[][] chs = new char[xl][yl];
        for (int i = 0; i < xl; i++) {
            chs[i] = plate[i].toCharArray();
        }
        //boolean[][] uses = new boolean[xl][yl];
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        list.add(new Pair<>(-1, 0));
        list.add(new Pair<>(0, 1));
        list.add(new Pair<>(1, 0));
        list.add(new Pair<>(0, -1));
        for (int i = 0; i < xl; i++) {
            for (int j = 0; j < yl; j++) {
                if (chs[i][j] == 'O') {
                    Nums nums = new Nums(i, j, 4);
                    queue.add(nums);
                }
            }
        }
        List<int[]> res = new ArrayList<>();
        while (!queue.isEmpty() && num > 0) {
            num--;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Nums nums = queue.poll();
                if (chs[nums.x][nums.y] != 'O') {
                    int index;
                    if (chs[nums.x][nums.y] == 'E') {
                        index = (nums.index + 3) % 4;
                    } else if (chs[nums.x][nums.y] == 'W') {
                        index = (nums.index + 1) % 4;
                    } else {
                        index = nums.index;
                    }
                    int x = nums.x + list.get(index).getKey();
                    int y = nums.y + list.get(index).getValue();
                    if (x < 0 || x >= xl || y < 0 || y >= yl || chs[x][y] == 'O') {
                        continue;
                    }
                    if ((x == 0 || x == xl - 1) && (y == 0 || y == yl - 1)) {
                        continue;
                    }
                    if ((x == 0 || x == xl - 1) || (y == 0 || y == yl - 1)) {
                        int tx = x + list.get(index).getKey();
                        int ty = y + list.get(index).getValue();
                        if (chs[x][y] == '.' && (tx < 0 || tx >= xl || ty < 0 || ty >= yl)) {
                            res.add(new int[]{x, y});
                        }
                        continue;
                    }
                    queue.add(new Nums(x, y, index));
                } else {
                    if (nums.index != 4) {
                        continue;
                    }
                    for (int j = 0; j < 4; j++) {
                        int x = nums.x + list.get(j).getKey();
                        int y = nums.y + list.get(j).getValue();
                        if (x < 0 || x >= xl || y < 0 || y >= yl || chs[x][y] == 'O') {
                            continue;
                        }
                        if ((x == 0 || x == xl - 1) && (y == 0 || y == yl - 1)) {
                            continue;
                        }
                        if ((x == 0 || x == xl - 1) || (y == 0 || y == yl - 1)) {
                            int tx = x + list.get(j).getKey();
                            int ty = y + list.get(j).getValue();
                            if (chs[x][y] == '.' && (tx < 0 || tx >= xl || ty < 0 || ty >= yl)) {
                                res.add(new int[]{x, y});
                            }
                            continue;
                        }
                        queue.add(new Nums(x, y, j));
                    }
                }
            }
        }
        int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public int transportationHub(int[][] path) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Boolean> booleanMap = new HashMap<>();
        for (int[] p : path) {
            List<Integer> tmp = map.getOrDefault(p[1], new ArrayList<>());
            tmp.add(p[0]);
            map.put(p[1], tmp);
            booleanMap.put(p[0], false);
            booleanMap.put(p[1], booleanMap.getOrDefault(p[1], true));
        }
        int cnt = booleanMap.size();
        for (int key : booleanMap.keySet()) {
            if (booleanMap.get(key) && map.get(key).size() == cnt - 1) {
                return key;
            }
        }
        return -1;
    }

    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int size = temperatureA.length;
        for (int i = 0; i < size - 1; i++) {
            temperatureA[i] = temperatureA[i + 1] - temperatureA[i];
            temperatureB[i] = temperatureB[i + 1] - temperatureB[i];
        }
        int n = 0;
        int cnt = 0;
        for (int i = 0; i < size - 1; i++) {
            if (temperatureA[i] * temperatureB[i] > 0) {
                cnt++;
            } else if (temperatureA[i] == 0 && temperatureB[i] == 0) {
                cnt++;
            } else {
                n = Math.max(n, cnt);
                cnt = 0;
            }
        }
        return Math.max(n, cnt);
    }
}
