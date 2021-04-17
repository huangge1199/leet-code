<p>给你一个整数数组 <code>nums</code> 和两个整数 <code>k</code> 和 <code>t</code> 。请你判断是否存在 <b>两个不同下标</b> <code>i</code> 和 <code>j</code>，使得 <code>abs(nums[i] - nums[j]) <= t</code> ，同时又满足 <code>abs(i - j) <= k</code><em> </em>。</p>

<p>如果存在则返回 <code>true</code>，不存在返回 <code>false</code>。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3,1], k<em> </em>= 3, t = 0
<strong>输出：</strong>true</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,0,1,1], k<em> </em>=<em> </em>1, t = 2
<strong>输出：</strong>true</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,5,9,1,5,9], k = 2, t = 3
<strong>输出：</strong>false</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 <= nums.length <= 2 * 10<sup>4</sup></code></li>
	<li><code>-2<sup>31</sup> <= nums[i] <= 2<sup>31</sup> - 1</code></li>
	<li><code>0 <= k <= 10<sup>4</sup></code></li>
	<li><code>0 <= t <= 2<sup>31</sup> - 1</code></li>
</ul>
<div><div>Related Topics</div><div><li>排序</li><li>Ordered Map</li></div></div>\n<div><li>👍 391</li><li>👎 0</li></div>