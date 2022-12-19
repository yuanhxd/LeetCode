package leetcode.editor.cn;

//Java: 括号生成(generate-parentheses)

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 3000 👎 0

import java.util.ArrayList;
import java.util.List;

class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            ArrayList<String> ans = new ArrayList<>();
            if (n <= 0) return ans;
            backtrack(ans, new StringBuilder(), n, n);
            return ans;
        }

        private void backtrack(ArrayList<String> ans, StringBuilder sb, int left, int right) {
            if (left == 0 && right == 0) {
                ans.add(sb.toString());
                return;
            }

            if (left == right) {
                backtrack(ans, sb.append('('), left - 1, right);
            } else {
                if (left > 0) {
                    backtrack(ans, sb.append('('), left - 1, right);
                }
                backtrack(ans, sb.append(')'), left, right - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

