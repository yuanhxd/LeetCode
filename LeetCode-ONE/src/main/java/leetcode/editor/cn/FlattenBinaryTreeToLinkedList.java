package leetcode.editor.cn;

//Java: 二叉树展开为链表(flatten-binary-tree-to-linked-list)

//给你二叉树的根结点 root ，请你将它展开为一个单链表： 
//
// 
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？ 
// Related Topics 栈 树 深度优先搜索 链表 二叉树 👍 1364 👎 0

import com.lyz.java.TreeNode;

import java.util.ArrayList;

class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public void flatten(TreeNode root) {
            ArrayList<TreeNode> ans = new ArrayList<>();
            preorder(ans, root);

            for (int i = 1; i < ans.size(); i++) {
                TreeNode pre = ans.get(i - 1), cur = ans.get(i);
                pre.left = null;
                pre.right = cur;
            }
        }

        public void flattenByCode(TreeNode root) {
            TreeNode curr = root;
            while (curr != null) {
                if (curr.left != null) {
                    TreeNode next = curr.left;
                    TreeNode predecessor = next;
                    while (predecessor.right != null) {
                        predecessor = predecessor.right;
                    }
                    predecessor.right = curr.right;
                    curr.left = null;
                    curr.right = next;
                }
                curr = curr.right;
            }
        }

        private void preorder(ArrayList<TreeNode> ans, TreeNode root) {
            if (root == null) return;

            ans.add(root);
            preorder(ans, root.left);
            preorder(ans, root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

