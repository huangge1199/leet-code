<p>设计一个支持在<em>平均&nbsp;</em>时间复杂度 <strong>O(1)</strong>&nbsp;下，执行以下操作的数据结构。</p>

<ol>
	<li><code>insert(val)</code>：当元素 val 不存在时，向集合中插入该项。</li>
	<li><code>remove(val)</code>：元素 val 存在时，从集合中移除该项。</li>
	<li><code>getRandom</code>：随机返回现有集合中的一项。每个元素应该有<strong>相同的概率</strong>被返回。</li>
</ol>

<p><strong>示例 :</strong></p>

<pre>
// 初始化一个空的集合。
RandomizedSet randomSet = new RandomizedSet();

// 向集合中插入 1 。返回 true 表示 1 被成功地插入。
randomSet.insert(1);

// 返回 false ，表示集合中不存在 2 。
randomSet.remove(2);

// 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
randomSet.insert(2);

// getRandom 应随机返回 1 或 2 。
randomSet.getRandom();

// 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
randomSet.remove(1);

// 2 已在集合中，所以返回 false 。
randomSet.insert(2);

// 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
randomSet.getRandom();
</pre>
<div><div>Related Topics</div><div><li>设计</li><li>数组</li><li>哈希表</li></div></div>\n<div><li>👍 314</li><li>👎 0</li></div>