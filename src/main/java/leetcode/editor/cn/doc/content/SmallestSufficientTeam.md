<p>作为项目经理，你规划了一份需求的技能清单&nbsp;<code>req_skills</code>，并打算从备选人员名单&nbsp;<code>people</code>&nbsp;中选出些人组成一个「必要团队」（ 编号为&nbsp;<code>i</code>&nbsp;的备选人员&nbsp;<code>people[i]</code>&nbsp;含有一份该备选人员掌握的技能列表）。</p>

<p>所谓「必要团队」，就是在这个团队中，对于所需求的技能列表&nbsp;<code>req_skills</code> 中列出的每项技能，团队中至少有一名成员已经掌握。可以用每个人的编号来表示团队中的成员：</p>

<ul> 
 <li>例如，团队&nbsp;<code>team = [0, 1, 3]</code>&nbsp;表示掌握技能分别为&nbsp;<code>people[0]</code>，<code>people[1]</code>，和&nbsp;<code>people[3]</code>&nbsp;的备选人员。</li> 
</ul>

<p>请你返回 <strong>任一</strong>&nbsp;规模最小的必要团队，团队成员用人员编号表示。你可以按 <strong>任意顺序</strong> 返回答案，题目数据保证答案存在。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>req_skills = ["java","nodejs","reactjs"], people = [["java"],["nodejs"],["nodejs","reactjs"]]
<strong>输出：</strong>[0,2]
</pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre>
<strong>输入：</strong>req_skills = ["algorithms","math","java","reactjs","csharp","aws"], people = [["algorithms","math","java"],["algorithms","math","reactjs"],["java","csharp","aws"],["reactjs","csharp"],["csharp","math"],["aws","java"]]
<strong>输出：</strong>[1,2]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= req_skills.length &lt;= 16</code></li> 
 <li><code>1 &lt;= req_skills[i].length &lt;= 16</code></li> 
 <li><code>req_skills[i]</code> 由小写英文字母组成</li> 
 <li><code>req_skills</code> 中的所有字符串 <strong>互不相同</strong></li> 
 <li><code>1 &lt;= people.length &lt;= 60</code></li> 
 <li><code>0 &lt;= people[i].length &lt;= 16</code></li> 
 <li><code>1 &lt;= people[i][j].length &lt;= 16</code></li> 
 <li><code>people[i][j]</code> 由小写英文字母组成</li> 
 <li><code>people[i]</code> 中的所有字符串 <strong>互不相同</strong></li> 
 <li><code>people[i]</code> 中的每个技能是 <code>req_skills</code> 中的技能</li> 
 <li>题目数据保证「必要团队」一定存在</li> 
</ul>

<div><div>Related Topics</div><div><li>位运算</li><li>数组</li><li>动态规划</li><li>状态压缩</li></div></div><br><div><li>👍 157</li><li>👎 0</li></div>