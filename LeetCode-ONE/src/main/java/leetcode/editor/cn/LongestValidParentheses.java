package leetcode.editor.cn;

//Java: 最长有效括号(longest-valid-parentheses)

//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 栈 字符串 动态规划 👍 2114 👎 0

import java.util.Stack;

class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int max = 0;
            int[] dp = new int[s.length()];
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                    max = Math.max(max, dp[i]);
                }
            }
            return max;
        }

        public int longestValidParenthesesByStack(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int max = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(i);
                    } else {
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }

            return max;
        }

        public int longestValidParenthesesByDubbo(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int max = 0;
            int left = 0, right = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    left++;
                } else {
                    right++;
                }

                if (left == right) {
                    max = Math.max(max, 2 * left);
                } else if (right > left) {
                    left = right = 0;
                }
            }

            left = right = 0;

            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == '(') {
                    left++;
                } else {
                    right++;
                }

                if (left == right) {
                    max = Math.max(max, 2 * left);
                } else if (left > right) {
                    right = left = 0;
                }
            }

            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

