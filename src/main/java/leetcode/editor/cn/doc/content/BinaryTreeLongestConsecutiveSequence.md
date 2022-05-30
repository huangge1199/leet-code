<p>给你一棵指定的二叉树的根节点 <code>root</code> ，请你计算其中 <strong>最长连续序列路径</strong> 的长度。</p>

<p><strong>最长连续序列路径</strong> 是依次递增 1 的路径。该路径，可以是从某个初始节点到树中任意节点，通过「父 - 子」关系连接而产生的任意路径。且必须从父节点到子节点，反过来是不可以的。</p>
&nbsp;

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/14/consec1-1-tree.jpg" style="width: 322px; height: 421px;" />
<pre>
<strong>输入：</strong>root = [1,null,3,2,4,null,null,null,5]
<strong>输出：</strong>3
<strong>解释：</strong>当中，最长连续序列是 <code>3-4-5 ，所以</code>返回结果为 <code>3 。</code>
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/14/consec1-2-tree.jpg" style="width: 262px; height: 421px;" />
<pre>
<strong>输入：</strong>root = [2,null,3,2,null,1]
<strong>输出：</strong>2
<strong>解释：</strong>当中，最长连续序列是 <code>2-3 。注意，不是</code> <code>3-2-1，所以</code>返回 <code>2 。</code>
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中节点的数目在范围 <code>[1, 3 * 10<sup>4</sup>]</code> 内</li>
	<li><code>-3 * 10<sup>4</sup> &lt;= Node.val &lt;= 3 * 10<sup>4</sup></code></li>
</ul>
<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 89</li><li>👎 0</li></div>