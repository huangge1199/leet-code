<p>给出基数为 <strong>-2</strong>&nbsp;的两个数&nbsp;<code>arr1</code> 和&nbsp;<code>arr2</code>，返回两数相加的结果。</p>

<p>数字以&nbsp;<em>数组形式</em><strong>&nbsp;</strong>给出：数组由若干 0 和 1 组成，按最高有效位到最低有效位的顺序排列。例如，<code>arr&nbsp;= [1,1,0,1]</code>&nbsp;表示数字&nbsp;<code>(-2)^3&nbsp;+ (-2)^2 + (-2)^0 = -3</code>。<em>数组形式</em>&nbsp;中的数字 <code>arr</code> 也同样不含前导零：即&nbsp;<code>arr == [0]</code>&nbsp;或&nbsp;<code>arr[0] == 1</code>。</p>

<p>返回相同表示形式的 <code>arr1</code> 和 <code>arr2</code> 相加的结果。两数的表示形式为：不含前导零、由若干 0 和 1 组成的数组。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>arr1 = [1,1,1,1,1], arr2 = [1,0,1]
<strong>输出：</strong>[1,0,0,0,0]
<strong>解释：</strong>arr1 表示 11，arr2 表示 5，输出表示 16 。
</pre>

<p>
 <meta charset="UTF-8" /></p>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>arr1 = [0], arr2 = [0]
<strong>输出：</strong>[0]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>arr1 = [0], arr2 = [1]
<strong>输出：</strong>[1]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p> 
<meta charset="UTF-8" />

<ul> 
 <li><code>1 &lt;= arr1.length,&nbsp;arr2.length &lt;= 1000</code></li> 
 <li><code>arr1[i]</code>&nbsp;和&nbsp;<code>arr2[i]</code>&nbsp;都是&nbsp;<code>0</code>&nbsp;或&nbsp;<code>1</code></li> 
 <li><code>arr1</code>&nbsp;和&nbsp;<code>arr2</code>&nbsp;都没有前导0</li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>数学</li></div></div><br><div><li>👍 80</li><li>👎 0</li></div>