<p>给你两个整数数组 <code>nums1</code> 和 <code>nums2</code> ，请你实现一个支持下述两类查询的数据结构：</p>

<ol>
	<li><strong>累加</strong> ，将一个正整数加到 <code>nums2</code> 中指定下标对应元素上。</li>
	<li><strong>计数 </strong>，统计满足 <code>nums1[i] + nums2[j]</code> 等于指定值的下标对 <code>(i, j)</code> 数目（<code>0 <= i < nums1.length</code> 且 <code>0 <= j < nums2.length</code>）。</li>
</ol>

<p>实现 <code>FindSumPairs</code> 类：</p>

<ul>
	<li><code>FindSumPairs(int[] nums1, int[] nums2)</code> 使用整数数组 <code>nums1</code> 和 <code>nums2</code> 初始化 <code>FindSumPairs</code> 对象。</li>
	<li><code>void add(int index, int val)</code> 将 <code>val</code> 加到 <code>nums2[index]</code> 上，即，执行 <code>nums2[index] += val</code> 。</li>
	<li><code>int count(int tot)</code> 返回满足 <code>nums1[i] + nums2[j] == tot</code> 的下标对 <code>(i, j)</code> 数目。</li>
</ul>

<p> </p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>
["FindSumPairs", "count", "add", "count", "count", "add", "add", "count"]
[[[1, 1, 2, 2, 2, 3], [1, 4, 5, 2, 5, 4]], [7], [3, 2], [8], [4], [0, 1], [1, 1], [7]]
<strong>输出：</strong>
[null, 8, null, 2, 1, null, null, 11]

<strong>解释：</strong>
FindSumPairs findSumPairs = new FindSumPairs([1, 1, 2, 2, 2, 3], [1, 4, 5, 2, 5, 4]);
findSumPairs.count(7);  // 返回 8 ; 下标对 (2,2), (3,2), (4,2), (2,4), (3,4), (4,4) 满足 2 + 5 = 7 ，下标对 (5,1), (5,5) 满足 3 + 4 = 7
findSumPairs.add(3, 2); // 此时 nums2 = [1,4,5,<em><strong>4</strong></em><code>,5,4</code>]
findSumPairs.count(8);  // 返回 2 ；下标对 (5,2), (5,4) 满足 3 + 5 = 8
findSumPairs.count(4);  // 返回 1 ；下标对 (5,0) 满足 3 + 1 = 4
findSumPairs.add(0, 1); // 此时 nums2 = [<em><strong><code>2</code></strong></em>,4,5,4<code>,5,4</code>]
findSumPairs.add(1, 1); // 此时 nums2 = [<code>2</code>,<em><strong>5</strong></em>,5,4<code>,5,4</code>]
findSumPairs.count(7);  // 返回 11 ；下标对 (2,1), (2,2), (2,4), (3,1), (3,2), (3,4), (4,1), (4,2), (4,4) 满足 2 + 5 = 7 ，下标对 (5,3), (5,5) 满足 3 + 4 = 7
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums1.length <= 1000</code></li>
	<li><code>1 <= nums2.length <= 10<sup>5</sup></code></li>
	<li><code>1 <= nums1[i] <= 10<sup>9</sup></code></li>
	<li><code>1 <= nums2[i] <= 10<sup>5</sup></code></li>
	<li><code>0 <= index < nums2.length</code></li>
	<li><code>1 <= val <= 10<sup>5</sup></code></li>
	<li><code>1 <= tot <= 10<sup>9</sup></code></li>
	<li>最多调用 <code>add</code> 和 <code>count</code> 函数各 <code>1000</code> 次</li>
</ul>
<div><div>Related Topics</div><div><li>设计</li><li>哈希表</li><li>Ordered Map</li></div></div>\n<div><li>👍 9</li><li>👎 0</li></div>