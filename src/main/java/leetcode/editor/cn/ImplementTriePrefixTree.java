//Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼
//写检查。 
//
// 请你实现 Trie 类： 
//
// 
// Trie() 初始化前缀树对象。 
// void insert(String word) 向前缀树中插入字符串 word 。 
// boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false
// 。 
// boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否
//则，返回 false 。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//输出
//[null, null, true, false, true, null, true]
//
//解释
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // 返回 True
//trie.search("app");     // 返回 False
//trie.startsWith("app"); // 返回 True
//trie.insert("app");
//trie.search("app");     // 返回 True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length, prefix.length <= 2000 
// word 和 prefix 仅由小写英文字母组成 
// insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次 
// 
// Related Topics 设计 字典树 
// 👍 618 👎 0

package leetcode.editor.cn;

//208:实现 Trie (前缀树)
public class ImplementTriePrefixTree {
    public static void main(String[] args) {
        //测试代码
        Trie trie = new ImplementTriePrefixTree().new Trie();
        String[] op = new String[]{"insert", "search", "search", "startsWith", "insert", "search"};
        String[] value = new String[]{"apple", "apple", "app", "app", "app", "app"};
        int size = op.length;
        for (int i = 0; i < size; i++) {
            switch (op[i]) {
                case "insert":
                    trie.insert(value[i]);
                    System.out.println("insert");
                    break;
                case "search":
                    System.out.println(trie.search(value[i]));
                    break;
                case "startsWith":
                    System.out.println(trie.startsWith(value[i]));
                    break;
                default:
                    break;
            }
        }
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {
        private Trie[] son;
        private boolean isEnd;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            son = new Trie[26];
            isEnd = false;
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Trie trie = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (trie.son[index] == null) {
                    trie.son[index] = new Trie();
                }
                trie = trie.son[index];
            }
            trie.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Trie trie = this;
            int size = word.length();
            for (int i = 0; i < size; i++) {
                int index = word.charAt(i) - 'a';
                if (trie.son[index] == null) {
                    return false;
                }
                if (i == size-1 && !trie.son[index].isEnd) {
                    return false;
                }
                trie = trie.son[index];
            }
            return true;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Trie trie = this;
            for (char ch : prefix.toCharArray()) {
                int index = ch - 'a';
                if (trie.son[index] == null) {
                    return false;
                }
                trie = trie.son[index];
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}