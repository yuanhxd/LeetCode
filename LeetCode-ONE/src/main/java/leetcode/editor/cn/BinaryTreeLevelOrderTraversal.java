package leetcode.editor.cn;

//Java: 二叉树的层序遍历(binary-tree-level-order-traversal)

//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
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
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 1542 👎 0

import com.lyz.java.TreeNode;

import java.util.*;

class BinaryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;

        Deque<TreeNode> stack = new LinkedList<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = stack.removeLast();
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    stack.addFirst(treeNode.left);
                }
                if (treeNode.right != null) {
                    stack.addFirst(treeNode.right);
                }
            }
            ans.add(list);
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

