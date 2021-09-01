<p><strong>思路：</strong></p>
    <p>将每个元素与其后的k个元素依次比较，看看他们是不是相等</p>
    <p>由于题目没有给出k的范围，要注意先判断k的大小，如果k小于等于0，结果必然返回false</p>
<p><strong>代码：</strong></p>
<pre>
public boolean containsNearbyDuplicate(int[] nums, int k) {
    if (k <= 0) {
        return false;
    }
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j <= Math.min(i + k, nums.length - 1); j++) {
            if (nums[i] == nums[j]) {
                return true;
            }
        }
    }
    return false;
}
</pre>
    