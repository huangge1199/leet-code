package contest.y2022.m9;

import com.code.leet.entiy.TreeNode;

import java.util.*;

public class Week311 {
    public static void main(String[] args) {
        Week311 soluytion = new Week311();
        //TreeNode root = new TreeNode(Arrays.asList(2, 3, 5, 8, 13, 21, 34));
        TreeNode root = new TreeNode(Arrays.asList(0, 1, 2, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2));
        soluytion.reverseOddLevels(root);
    }

    class Trie {
        private Trie[] children;
        private int cnt;

        public Trie() {
            children = new Trie[26];
            cnt = 0;
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
                node.cnt += 1;
            }
        }

        private int search(String prefix) {
            Trie node = this;
            int cnt = 0;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    break;
                }
                node = node.children[index];
                cnt += node.cnt;
            }
            return cnt;
        }
    }

    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        int[] arrs = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            arrs[i] = trie.search(words[i]);
        }
        return arrs;
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        root = new TreeNode(list.get(0));
        queue.add(root);
        int n = 1;
        int min = 0;
        int max = 0;
        int cnt = 1;
        int mul = 1;
        while (cnt < list.size()) {
            min = max + 1;
            max += mul * 2;
            cnt += mul * 2;
            if (n % 2 == 0) {
                for (int i = min; i <= max; i = i + 2) {
                    TreeNode node = queue.poll();
                    TreeNode left = new TreeNode(list.get(i));
                    TreeNode right = new TreeNode(list.get(i + 1));
                    node.left = left;
                    node.right = right;
                    queue.add(left);
                    queue.add(right);
                }
            } else {
                for (int i = max; i >= min; i = i - 2) {
                    TreeNode node = queue.poll();
                    TreeNode left = new TreeNode(list.get(i));
                    TreeNode right = new TreeNode(list.get(i - 1));
                    node.left = left;
                    node.right = right;
                    queue.add(left);
                    queue.add(right);
                }
            }
            n++;
            mul *= 2;
        }
        return root;
    }

    public int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : n * 2;
    }
}
