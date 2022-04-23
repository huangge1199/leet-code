<p>请你设计一个日志系统，可以流式接收消息以及它的时间戳。每条 <strong>不重复</strong> 的消息最多只能每 10 秒打印一次。也就是说，如果在时间戳 <code>t</code> 打印某条消息，那么相同内容的消息直到时间戳变为 <code>t + 10</code> 之前都不会被打印。</p>

<p>所有消息都按时间顺序发送。多条消息可能到达同一时间戳。</p>

<p>实现 <code>Logger</code> 类：</p>

<ul>
	<li><code>Logger()</code> 初始化 <code>logger</code> 对象</li>
	<li><code>bool shouldPrintMessage(int timestamp, string message)</code> 如果这条消息 <code>message</code> 在给定的时间戳 <code>timestamp</code> 应该被打印出来，则返回 <code>true</code> ，否则请返回 <code>false</code> 。</li>
</ul>

<p> </p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>
["Logger", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage"]
[[], [1, "foo"], [2, "bar"], [3, "foo"], [8, "bar"], [10, "foo"], [11, "foo"]]
<strong>输出：</strong>
[null, true, true, false, false, false, true]

<strong>解释：</strong>
Logger logger = new Logger();
logger.shouldPrintMessage(1, "foo");  // 返回 true ，下一次 "foo" 可以打印的时间戳是 1 + 10 = 11
logger.shouldPrintMessage(2, "bar");  // 返回 true ，下一次 "bar" 可以打印的时间戳是 2 + 10 = 12
logger.shouldPrintMessage(3, "foo");  // 3 < 11 ，返回 false
logger.shouldPrintMessage(8, "bar");  // 8 < 12 ，返回 false
logger.shouldPrintMessage(10, "foo"); // 10 < 11 ，返回 false
logger.shouldPrintMessage(11, "foo"); // 11 >= 11 ，返回 true ，下一次 "foo" 可以打印的时间戳是 11 + 10 = 21
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 <= timestamp <= 10<sup>9</sup></code></li>
	<li>每个 <code>timestamp</code> 都将按非递减顺序（时间顺序）传递</li>
	<li><code>1 <= message.length <= 30</code></li>
	<li>最多调用 <code>10<sup>4</sup></code> 次 <code>shouldPrintMessage</code> 方法</li>
</ul>
<div><div>Related Topics</div><div><li>设计</li><li>哈希表</li></div></div><br><div><li>👍 62</li><li>👎 0</li></div>