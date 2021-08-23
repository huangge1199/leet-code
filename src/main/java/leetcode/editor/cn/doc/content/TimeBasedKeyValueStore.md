<p>创建一个基于时间的键值存储类&nbsp;<code>TimeMap</code>，它支持下面两个操作：</p>

<p>1. <code>set(string key, string value, int timestamp)</code></p>

<ul>
	<li>存储键&nbsp;<code>key</code>、值&nbsp;<code>value</code>，以及给定的时间戳&nbsp;<code>timestamp</code>。</li>
</ul>

<p>2. <code>get(string key, int timestamp)</code></p>

<ul>
	<li>返回先前调用&nbsp;<code>set(key, value, timestamp_prev)</code>&nbsp;所存储的值，其中&nbsp;<code>timestamp_prev &lt;= timestamp</code>。</li>
	<li>如果有多个这样的值，则返回对应最大的&nbsp;&nbsp;<code>timestamp_prev</code>&nbsp;的那个值。</li>
	<li>如果没有值，则返回空字符串（<code>&quot;&quot;</code>）。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>inputs = [&quot;TimeMap&quot;,&quot;set&quot;,&quot;get&quot;,&quot;get&quot;,&quot;set&quot;,&quot;get&quot;,&quot;get&quot;], inputs = [[],[&quot;foo&quot;,&quot;bar&quot;,1],[&quot;foo&quot;,1],[&quot;foo&quot;,3],[&quot;foo&quot;,&quot;bar2&quot;,4],[&quot;foo&quot;,4],[&quot;foo&quot;,5]]
<strong>输出：</strong>[null,null,&quot;bar&quot;,&quot;bar&quot;,null,&quot;bar2&quot;,&quot;bar2&quot;]
<strong>解释：</strong>&nbsp; 
TimeMap kv; &nbsp; 
kv.set(&quot;foo&quot;, &quot;bar&quot;, 1); // 存储键 &quot;foo&quot; 和值 &quot;bar&quot; 以及时间戳 timestamp = 1 &nbsp; 
kv.get(&quot;foo&quot;, 1);  // 输出 &quot;bar&quot; &nbsp; 
kv.get(&quot;foo&quot;, 3); // 输出 &quot;bar&quot; 因为在时间戳 3 和时间戳 2 处没有对应 &quot;foo&quot; 的值，所以唯一的值位于时间戳 1 处（即 &quot;bar&quot;） &nbsp; 
kv.set(&quot;foo&quot;, &quot;bar2&quot;, 4); &nbsp; 
kv.get(&quot;foo&quot;, 4); // 输出 &quot;bar2&quot; &nbsp; 
kv.get(&quot;foo&quot;, 5); // 输出 &quot;bar2&quot; &nbsp; 

</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>inputs = [&quot;TimeMap&quot;,&quot;set&quot;,&quot;set&quot;,&quot;get&quot;,&quot;get&quot;,&quot;get&quot;,&quot;get&quot;,&quot;get&quot;], inputs = [[],[&quot;love&quot;,&quot;high&quot;,10],[&quot;love&quot;,&quot;low&quot;,20],[&quot;love&quot;,5],[&quot;love&quot;,10],[&quot;love&quot;,15],[&quot;love&quot;,20],[&quot;love&quot;,25]]
<strong>输出：</strong>[null,null,null,&quot;&quot;,&quot;high&quot;,&quot;high&quot;,&quot;low&quot;,&quot;low&quot;]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li>所有的键/值字符串都是小写的。</li>
	<li>所有的键/值字符串长度都在&nbsp;<code>[1, 100]</code>&nbsp;范围内。</li>
	<li>所有&nbsp;<code>TimeMap.set</code>&nbsp;操作中的时间戳&nbsp;<code>timestamps</code> 都是严格递增的。</li>
	<li><code>1 &lt;= timestamp &lt;= 10^7</code></li>
	<li><code>TimeMap.set</code> 和&nbsp;<code>TimeMap.get</code>&nbsp;函数在每个测试用例中将（组合）调用总计&nbsp;<code>120000</code> 次。</li>
</ol>
<div><div>Related Topics</div><div><li>设计</li><li>哈希表</li><li>字符串</li><li>二分查找</li></div></div>\n<div><li>👍 120</li><li>👎 0</li></div>