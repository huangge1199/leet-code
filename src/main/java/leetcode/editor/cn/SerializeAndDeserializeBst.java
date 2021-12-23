//序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。 
//
// 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序
//列化为最初的二叉搜索树。 
//
// 编码的字符串应尽可能紧凑。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,1,3]
//输出：[2,1,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数范围是 [0, 10⁴] 
// 0 <= Node.val <= 10⁴ 
// 题目数据 保证 输入的树是一棵二叉搜索树。 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 设计 二叉搜索树 字符串 二叉树 👍 236 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.TreeNode;

import java.util.ArrayDeque;

//Java：449:序列化和反序列化二叉搜索树
public class SerializeAndDeserializeBst {
    public static void main(String[] args) {
//        Solution solution = new SerializeAndDeserializeBst().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        public StringBuilder postorder(TreeNode root, StringBuilder sb) {
            if (root == null) {
                return sb;
            }
            postorder(root.left, sb);
            postorder(root.right, sb);
            sb.append(root.val);
            sb.append(' ');
            return sb;
        }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = postorder(root, new StringBuilder());
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }

        public TreeNode helper(Integer lower, Integer upper, ArrayDeque<Integer> nums) {
            if (nums.isEmpty()) {
                return null;
            }
            int val = nums.getLast();
            if (val < lower || val > upper) {
                return null;
            }

            nums.removeLast();
            TreeNode root = new TreeNode(val);
            root.right = helper(val, upper, nums);
            root.left = helper(lower, val, nums);
            return root;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) {
                return null;
            }
            ArrayDeque<Integer> nums = new ArrayDeque<Integer>();
            for (String s : data.split("\\s+")) {
                nums.add(Integer.valueOf(s));
            }
            return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, nums);
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
//leetcode submit region end(Prohibit modification and deletion)
}
