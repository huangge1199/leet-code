package com.code.leet.week;

import java.util.*;
import java.util.stream.Stream;

/**
 * @Author: 轩辕龙儿
 * @Date: 2021/4/10 15:07
 * @Description:
 */
public class Lcp20210410 {
    public int storeWater(int[] bucket, int[] vat) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        int size = bucket.length;
        for (int i = 0; i < size; i++) {
            if (bucket[i] == 0) {
                count++;
                list.add(vat[i]);
            } else {
                list.add(vat[i] / bucket[i]);
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Lcp20210410 test = new Lcp20210410();
//        System.out.println(test.maxGroupNumber(new int[]{2, 2, 2, 3, 4}));
        System.out.println(test.electricCarPlan(new int[][]{{0, 4, 2}, {4, 3, 5}, {3, 0, 5}, {0, 1, 5}, {3, 2, 4}, {1, 2, 8}}, 8,
                0, 2, new int[]{4, 1, 1, 3, 2}));
    }

    public int maxGroupNumber(int[] tiles) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = -1;
        for (int num : tiles) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
        }
        int count = 0;
        int l0 = 0;
        int l1 = map.get(min);
        int l2 = map.getOrDefault(min + 1, 0);
        int cur;
        for (int i = min + 2; i <= max; i++) {
            if (!map.containsKey(i)) {
                count += l0 / 3 + l1 / 3 + l2 / 3;
                l0 = l1 % 3;
                l1 = l2 % 3;
                l2 = 0;
                continue;
            }
            cur = map.get(i);
            if (l1 > 0 && l2 > 0) {
                int tempMin = Math.min(cur, Math.min(l1, l2));
                int tempCount = l1 / 3 + l2 / 3 + cur / 3;
                if (tempMin >= tempCount) {
                    count += tempMin;
                    l0 = l1 - tempMin;
                    l1 = l2 - tempMin;
                    l2 = cur - tempMin;
                } else {
                    count += l1 / 3;
                    l0 = l1 % 3;
                    l1 = l2;
                    l2 = cur;
                }
            } else {
                count += l0 / 3 + l1 / 3;
                l0 = l1 % 3;
                l1 = l2;
                l2 = cur;
            }
        }
        return count + l1 / 3 + l2 / 3;
    }

    public int electricCarPlan(int[][] paths, int cnt, int start, int end, int[] charge) {
        int arrSize = charge.length;
        int[][] edges = new int[arrSize][arrSize];
        int size = paths.length;
        for (int i = 0; i < arrSize; i++) {
            for (int j = 0; j < arrSize; j++) {
                edges[i][j] = i == j ? 0 : Integer.MAX_VALUE;
            }
        }
        int[] distance = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            distance[i] = i == start ? 0 : Integer.MAX_VALUE;
        }
        for (int i = 0; i < size; i++) {
            int num1 = paths[i][0];
            int num2 = paths[i][1];
            int tempLength = paths[i][2];
            edges[num1][num2] = tempLength * (charge[num1] + 1);
            edges[num2][num1] = tempLength * (charge[num2] + 1);
            if (num1 == start) {
                distance[num2] = edges[num1][num2];
            }
        }
        boolean[] st = new boolean[arrSize];
        // 处理从源点到其余顶点的最短路径
        for (int i = 0; i < arrSize; ++i) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            // 比较从源点到其余顶点的路径长度
            for (int j = 0; j < arrSize; ++j) {
                // 从源点到j顶点的最短路径还没有找到
                if (!st[j]) {
                    // 从源点到j顶点的路径长度最小
                    if (distance[j] < min) {
                        index = j;
                        min = distance[j];
                    }
                }
            }
            //找到源点到索引为index顶点的最短路径长度
            if (index != -1) {
                st[index] = true;
            }
            // 更新当前最短路径及距离
            for (int w = 0; w < arrSize; w++) {
                if (!st[w]) {
                    if (edges[index][w] != Integer.MAX_VALUE
                            && (min + edges[index][w] < distance[w])) {
                        distance[w] = min + edges[index][w];
                    }
                }
            }
        }
        return distance[end];
    }
}
