<p>给定一个长度为 <code>n</code> 的整数数组和一个目标值 <code>target</code>&nbsp;，寻找能够使条件&nbsp;<code>nums[i] + nums[j] + nums[k] &lt; target</code>&nbsp;成立的三元组&nbsp; <code>i, j, k</code>&nbsp;个数（<code>0 &lt;= i &lt; j &lt; k &lt; n</code>）。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入: </strong><em>nums</em> = <code>[-2,0,1,3]</code>, <em>target</em> = 2
<strong>输出: </strong>2 
<strong>解释: </strong>因为一共有两个三元组满足累加和小于 2:
&nbsp;    [-2,0,1]
     [-2,0,3]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入: </strong><em>nums</em> = <code>[]</code>, <em>target</em> = 0
<strong>输出: </strong>0 </pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入: </strong><em>nums</em> = <code>[0]</code>, <em>target</em> = 0
<strong>输出: </strong>0 </pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>0 &lt;= n &lt;= 3500</code></li>
	<li><code>-100 &lt;= nums[i] &lt;= 100</code></li>
	<li><code>-100 &lt;= target &lt;= 100</code></li>
</ul>
<div><div>Related Topics</div><div><li>数组</li><li>双指针</li><li>二分查找</li><li>排序</li></div></div><br><div><li>👍 106</li><li>👎 0</li></div>