package com.code.leet;

import com.code.leet.entiy.TwoArray;
import javafx.util.Pair;

import java.util.*;

/**
 * @description:
 * @author: Administrator
 * @date: 2021/9/11-15:06
 */
public class Fall2021 {
    public int minimumSwitchingTimes(int[][] source, int[][] target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[0].length; j++) {
                map.put(source[i][j], map.getOrDefault(source[i][j], 0) + 1);
            }
        }
        int count = 0;
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target[0].length; j++) {
                map.put(target[i][j], map.getOrDefault(target[i][j], 0) - 1);
                if (map.get(target[i][j]) < 0) {
                    count++;
                    map.put(target[i][j], 0);
                }
            }
        }
        return count;
    }

    public int maxmiumScore(int[] cards, int cnt) {
        Arrays.sort(cards);
        int size = cards.length;
        int i = size - 1;
        if (cnt == 1) {
            for (; i >= 0; i--) {
                if (cards[i] % 2 == 0) {
                    return cards[i];
                }
            }
            return 0;
        }
        int sum = 0;
        int o1 = cards[i];
        int o2 = 0;
        int d1 = cards[i];
        int d2 = 0;
        for (; i >= size - cnt; i--) {
            sum += cards[i];
            if (cards[i] % 2 == 0) {
                d1 = Math.min(d1, cards[i]);
            } else {
                o1 = Math.min(o1, cards[i]);
            }
        }
        if (sum % 2 == 0) {
            return sum;
        }
        boolean oo = true;
        boolean dd = true;
        for (; i >= 0; i--) {
            if (dd && cards[i] % 2 == 0) {
                d2 = cards[i];
                dd = false;
            }
            if (oo && cards[i] % 2 == 1) {
                o2 = cards[i];
                oo = false;
            }
            if (!(oo && dd)) {
                break;
            }
        }
        if (o2 == 0 && d2 == 0) {
            return 0;
        } else if (o2 != 0 && d2 == 0) {
            return sum - d1 + o2;
        } else if (o2 == 0) {
            return sum - o1 + d2;
        } else {
            return sum - o1 - d1 + Math.max(o1 + o2, d1 + d2);
        }
    }

    public static void main(String[] args) {
        Fall2021 fall2021 = new Fall2021();
        TwoArray twoArray = new TwoArray("[[3,3,1],[3,2,1]]", true);
        int[][] toys = twoArray.getArr();
        twoArray = new TwoArray("[[4,3]]", true);
        int[][] circles = twoArray.getArr();
        System.out.println(fall2021.circleGame(toys, circles, 2));
    }

    public int circleGame(int[][] toys, int[][] circles, int r) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < toys.length; i++) {
            if (toys[i][2] <= r) {
                list.add(i);
            }
        }
        int count = 0;
        for (int[] circle : circles) {
            if (list.size() == 0) {
                break;
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                if (isIn(toys[list.get(i)][0], toys[list.get(i)][1], circle[0], circle[1], r, toys[list.get(i)][2])) {
                    count++;
                    list.remove(i);
                }
            }
        }
        return count;
    }

    private boolean isIn(int x1, int y1, int x2, int y2, int r, int c) {
        int x = x1 - x2;
        int y = y1 - y2;
        long m = (long) x * x + (long) y * y;
        double l = Math.sqrt(m) + c;
        return l <= r;
    }

//    public int circleGame(int[][] toys, int[][] circles, int r) {
//        List<List<Pair<Integer, Integer>>> lists = new ArrayList<>();
//        for (int[] toy : toys) {
//            if (toy[2] > r) {
//                continue;
//            }
//            List<Pair<Integer, Integer>> list = new ArrayList<>();
//            list.add(new Pair<>(toy[0] - toy[2], toy[1]));
//            list.add(new Pair<>(toy[0] + toy[2], toy[1]));
//            list.add(new Pair<>(toy[0], toy[1] - toy[2]));
//            list.add(new Pair<>(toy[0], toy[1] + toy[2]));
//            lists.add(new ArrayList<>(list));
//        }
//        int count = 0;
//        for (int[] circle : circles) {
//            if (lists.size() == 0) {
//                break;
//            }
//            for (int i = lists.size() - 1; i >= 0; i--) {
//                List<Pair<Integer, Integer>> list = lists.get(i);
//                boolean bl = true;
//                for (Pair<Integer, Integer> pair : list) {
//                    if (!isIn(circle[0], circle[1], pair.getKey(), pair.getValue(), r)) {
//                        bl = false;
//                        break;
//                    }
//                }
//                if (bl) {
//                    count++;
//                    lists.remove(i);
//                }
//            }
//        }
//        return count;
//    }
//
//    private boolean isIn(int x1, int y1, int x2, int y2, int r) {
//        int x = x1 - x2;
//        int y = y1 - y2;
//        long m = (long) x * x + (long) y * y;
//        long n = (long) r * r;
//        return m <= n;
//    }

}
