思路: 

先找好遍历顺序, top和bottom分别为行的上下界, 然后对列进行遍历, 利用前缀和+二分查找的方式更新ans

![](https://pic.leetcode-cn.com/1619058643-fkFedw-image.png)


### 1 | 二分查找+一维前缀和

这种方式在行遍历时先用一个sum[]保存每一列的和, 然后在列遍历的过程中动态维护前缀和

```cpp
class Solution {
public:
    int maxSumSubmatrix(vector<vector<int>>& matrix, int k) {
        int m = matrix.size(), n = matrix[0].size(), ans = INT_MIN;
        // top
        for (int i = 0; i < m; ++i) {
            // bottom
            vector<int> sum(n, 0);
            for (int j = i; j < m; ++j) {
                set<int> st{0};
                int r = 0;
                for (int z = 0; z < n; ++z) {
                    sum[z] += matrix[j][z];                    
                    r += sum[z];
                    auto lb = st.lower_bound(r - k);
                    if (lb != st.end()) {
                        ans = max(ans, r - *lb);
                    }
                    st.insert(r);
                }
            }
        }
        return ans;
    }
};
```

### 2 | 二分查找+二维前缀和(积分图)

先对矩阵进行预处理, 可以减少动态维护前缀和时候重复计算的开销, 但是增大了空间复杂度

```cpp
class Solution {
public:
    int maxSumSubmatrix(vector<vector<int>>& matrix, int k) {
        int m = matrix.size(), n = matrix[0].size(), ans = INT_MIN;
        vector<vector<int>> pre(m + 1, vector<int>(n + 1, 0));
        // 积分图
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        // top
        for (int i = 1; i <= m; ++i) {
            // bottom
            for (int j = i; j <= m; ++j) {
                set<int> st{0};
                for (int z = 1; z <= n; ++z) {
                    int r = pre[j][z] - pre[i - 1][z];
                    auto lb = st.lower_bound(r - k);
                    if (lb != st.end()) {
                        ans = max(ans, r - *lb);
                    }
                    st.insert(r);
                }
            }
        }
        return ans;
    }
};
```