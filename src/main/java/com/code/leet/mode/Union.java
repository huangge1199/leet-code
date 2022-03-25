package com.code.leet.mode;

/**
 * @description:
 * @author: Administrator
 * @date: 2022/3/25 22:27
 */
public class Union {// 并查集模板
    int[] fa;
    int[] sz;
    public int Count;// 当前连通分量数目

    public boolean united(int x, int y) {
        x = find(x);
        y = find(y);
        return x == y;
    }

    public int find(int x) {
        return fa[x] == x ? x : (fa[x] = find(fa[x]));
    }

    public Union(int n) {//构造函数+初始化
        this.sz = new int[n];
        for (int i = 0; i < n; i++) sz[i] = 1;
        this.fa = new int[n];
        for (int i = 0; i < n; i++) fa[i] = i;
        this.Count = 0;
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (sz[x] < sz[y]) {
            x ^= y;
            y ^= x;
            x ^= y;
        }//按秩合并保证 sz[x]>=sz[y]
        sz[x] += sz[y];
        fa[y] = x;
        --Count;//把秩小的unite到大的上
    }
}
