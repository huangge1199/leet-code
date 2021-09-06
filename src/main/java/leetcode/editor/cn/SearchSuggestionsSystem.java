//给你一个产品数组 products 和一个字符串 searchWord ，products 数组中每个产品都是一个字符串。 
//
// 请你设计一个推荐系统，在依次输入单词 searchWord 的每一个字母后，推荐 products 数组中前缀与 searchWord 相同的最多三个产品
//。如果前缀相同的可推荐产品超过三个，请按字典序返回最小的三个。 
//
// 请你以二维列表的形式，返回在输入 searchWord 每个字母后相应的推荐产品的列表。 
//
// 
//
// 示例 1： 
//
// 输入：products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord 
//= "mouse"
//输出：[
//["mobile","moneypot","monitor"],
//["mobile","moneypot","monitor"],
//["mouse","mousepad"],
//["mouse","mousepad"],
//["mouse","mousepad"]
//]
//解释：按字典序排序后的产品列表是 ["mobile","moneypot","monitor","mouse","mousepad"]
//输入 m 和 mo，由于所有产品的前缀都相同，所以系统返回字典序最小的三个产品 ["mobile","moneypot","monitor"]
//输入 mou， mous 和 mouse 后系统都返回 ["mouse","mousepad"]
// 
//
// 示例 2： 
//
// 输入：products = ["havana"], searchWord = "havana"
//输出：[["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
// 
//
// 示例 3： 
//
// 输入：products = ["bags","baggage","banner","box","cloths"], searchWord = 
//"bags"
//输出：[["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"]
//,["bags"]]
// 
//
// 示例 4： 
//
// 输入：products = ["havana"], searchWord = "tatiana"
//输出：[[],[],[],[],[],[],[]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= products.length <= 1000 
// 1 <= Σ products[i].length <= 2 * 10^4 
// products[i] 中所有的字符都是小写英文字母。 
// 1 <= searchWord.length <= 1000 
// searchWord 中所有字符都是小写英文字母。 
// 
// Related Topics 字典树 数组 字符串 👍 84 👎 0

package leetcode.editor.cn;

import java.util.*;

//1268:搜索推荐系统
class SearchSuggestionsSystem {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new SearchSuggestionsSystem().new Solution();
        solution.suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouspepad");
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> getL;
        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            Arrays.sort(products);
            Map<Character, Node> map = new HashMap<>();
            for (String product : products) {
                char ch = product.charAt(0);
                Node root = map.getOrDefault(ch, new Node(ch));
                Node temp = root;
                for (int j = 1; j < product.length(); j++) {
                    if (temp.child[product.charAt(j) - 'a'] == null) {
                        temp.child[product.charAt(j) - 'a'] = new Node(product.charAt(j));
                    }
                    temp = temp.child[product.charAt(j) - 'a'];
                    if (j == product.length() - 1) {
                        temp.isEnd = true;
                        temp.str = product;
                    }
                }
                map.put(ch, root);
            }
            List<List<String>> result = new ArrayList<>();
            Node node;
            if (!map.containsKey(searchWord.charAt(0))) {
                for (int i = 0; i < searchWord.length(); i++) {
                    result.add(new ArrayList<>());
                }
                return result;
            }
            node = map.get(searchWord.charAt(0));
            getL = new ArrayList<>();
            getStr(node);
            result.add(new ArrayList<>(getL));
            for (int i = 1; i < searchWord.length(); i++) {
                char ch = searchWord.charAt(i);
                getL = new ArrayList<>();
                if (node.child[ch - 'a'] == null) {
                    break;
                }
                getStr(node.child[ch - 'a']);
                node = node.child[ch - 'a'];
                result.add(new ArrayList<>(getL));
            }
            int size = result.size();
            for (int i = 0; i < searchWord.length() - size; i++) {
                result.add(new ArrayList<>());
            }
            return result;
        }

        public void getStr(Node root) {
            if (root.isEnd) {
                getL.add(root.str);
            }
            for (int i = 0; i < 26; i++) {
                if (getL.size() == 3) {
                    break;
                }
                if (root.child[i] != null) {
                    getStr(root.child[i]);
                }
            }
        }

        class Node {
            char ch;
            boolean isEnd;
            Node[] child;
            String str;

            public Node(char ch) {
                this.ch = ch;
                child = new Node[26];
                isEnd = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}