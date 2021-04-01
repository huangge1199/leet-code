![图解每日一练.jpg](https://pic.leetcode-cn.com/1615817903-fzmpwZ-%E5%9B%BE%E8%A7%A3%E6%AF%8F%E6%97%A5%E4%B8%80%E7%BB%83.jpg)

---

### 🧠 解题思路

分析题意之后，可以得出以下结论：

1. 字符要做比较，所以之前的字符应该被存储下来，这里我们会用到栈。
2. 遍历字符，若栈顶和当前字符正好大小写都具备，则弹出栈顶抵消，否则当前字符入栈。

---

### 🎨 图解演示

 ![1.jpg](https://pic.leetcode-cn.com/1616513770-cbkAnG-1.jpg) ![2.jpg](https://pic.leetcode-cn.com/1616513772-ffshlQ-2.jpg) ![3.jpg](https://pic.leetcode-cn.com/1616513774-oJkAFT-3.jpg) ![4.jpg](https://pic.leetcode-cn.com/1616513777-jpPCEP-4.jpg) ![5.jpg](https://pic.leetcode-cn.com/1616513779-LcycBt-5.jpg) ![6.jpg](https://pic.leetcode-cn.com/1616513781-XeIFCV-6.jpg) 

---

### 🍭 示例代码

```Javascript []
var makeGood = function(s) {
    let res = [];
    for(let i of s){
        if(
            res.length &&
            res[res.length - 1] !== i &&
            res[res.length - 1].toUpperCase() === i.toUpperCase()
        ){
            res.pop();
        }else{
            res.push(i);
        }
    }
    return res.join("");
};
```

---

### 转身挥手

嘿，少年，做图不易，留下个赞或评论再走吧！谢啦~ 💐

差点忘了，祝你牛年大吉 🐮 ，AC 和 Offer 📑 多多益善~

⛲⛲⛲ 期待下次再见~ 