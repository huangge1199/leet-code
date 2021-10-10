<p>&nbsp;给你一个由非负整数&nbsp;<code>a<sub>1</sub>, a<sub>2</sub>, ..., a<sub>n</sub></code> 组成的数据流输入，请你将到目前为止看到的数字总结为不相交的区间列表。</p>

<p>实现 <code>SummaryRanges</code> 类：</p>

<div class="original__bRMd">
<div>
<ul>
	<li><code>SummaryRanges()</code> 使用一个空数据流初始化对象。</li>
	<li><code>void addNum(int val)</code> 向数据流中加入整数 <code>val</code> 。</li>
	<li><code>int[][] getIntervals()</code> 以不相交区间&nbsp;<code>[start<sub>i</sub>, end<sub>i</sub>]</code> 的列表形式返回对数据流中整数的总结。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>
["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
[[], [1], [], [3], [], [7], [], [2], [], [6], []]
<strong>输出：</strong>
[null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]

<strong>解释：</strong>
SummaryRanges summaryRanges = new SummaryRanges();
summaryRanges.addNum(1);      // arr = [1]
summaryRanges.getIntervals(); // 返回 [[1, 1]]
summaryRanges.addNum(3);      // arr = [1, 3]
summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3]]
summaryRanges.addNum(7);      // arr = [1, 3, 7]
summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3], [7, 7]]
summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
summaryRanges.getIntervals(); // 返回 [[1, 3], [7, 7]]
summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
summaryRanges.getIntervals(); // 返回 [[1, 3], [6, 7]]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 &lt;= val &lt;= 10<sup>4</sup></code></li>
	<li>最多调用&nbsp;<code>addNum</code> 和 <code>getIntervals</code> 方法 <code>3 * 10<sup>4</sup></code> 次</li>
</ul>
</div>
</div>

<p>&nbsp;</p>

<p><strong>进阶：</strong>如果存在大量合并，并且与数据流的大小相比，不相交区间的数量很小，该怎么办?</p>
<div><div>Related Topics</div><div><li>设计</li><li>二分查找</li><li>有序集合</li></div></div><br><div><li>👍 100</li><li>👎 0</li></div>