![图解每日一练.jpg](https://pic.leetcode-cn.com/1615817903-fzmpwZ-%E5%9B%BE%E8%A7%A3%E6%AF%8F%E6%97%A5%E4%B8%80%E7%BB%83.jpg)

---

### 🧠 解题思路

我们解决这道题的关键在于，需要知道哪些是需要去除的外层括号，为了找到这些需要去除的外层括号，我们可以使用到计数器。

**规则：** 遇到左括号，我们的计数器 *+1*，遇到右括号，我们的计数器 *-1*。

这样的话，一组连续且有效的括号，将不会对计数器的值产生变化。


```js
// 示例一
当前的计数值: 0 1 0 1
            ( ) ( )
遍历后计数值: 1 0 1 0

// 示例二
当前的计数值: 0 1 2 1 2 1 0 1
            ( ( ) ( ) ) ( ) 
遍历后计数值: 1 2 1 2 1 0 1 0
```

根据上述两个示例，我们可以很快的找出规律：

1. 遇到左括号，当前计数值大于 *0* ，则属于有效的左括号。
2. 遇到右括号，当前计数值大于 *1* ，则属于有效的右括号。

---

### 🎨 图解演示

 ![1.jpg](https://pic.leetcode-cn.com/1615909098-eOohaJ-1.jpg) ![2.jpg](https://pic.leetcode-cn.com/1615908912-aGpYJn-2.jpg) ![3.jpg](https://pic.leetcode-cn.com/1615908914-oGzkUH-3.jpg) ![4.jpg](https://pic.leetcode-cn.com/1615908917-mGekYh-4.jpg) ![5.jpg](https://pic.leetcode-cn.com/1615908919-mQrLwp-5.jpg) ![6.jpg](https://pic.leetcode-cn.com/1615908921-ZUDUic-6.jpg) ![7.jpg](https://pic.leetcode-cn.com/1615908923-AKfYyO-7.jpg) ![8.jpg](https://pic.leetcode-cn.com/1615908926-zzQCRy-8.jpg) ![9.jpg](https://pic.leetcode-cn.com/1615908928-KccJnw-9.jpg) 

---

### 🍭 示例代码

```Javascript []
var removeOuterParentheses = function(S) {
    let count = 0, ans = '';
    for (let i = 0; i < S.length; i++) {
        if(S[i] === '(' && count++ > 0) ans += '('
        if(S[i] === ')' && count-- > 1) ans += ')';
    }
    return ans;
};
```

---

### 转身挥手

嘿，少年，做图不易，留下个赞或评论再走吧！谢啦~ 💐

差点忘了，祝你牛年大吉 🐮 ，AC 和 Offer 📑 多多益善~

⛲⛲⛲ 期待下次再见~ 