package leetcode.editor.cn;

//Java: 电话号码的字母组合(letter-combinations-of-a-phone-number)

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 2227 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        List<String> strings = solution.letterCombinations("2");
        System.out.println(strings);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            ArrayList<String> ans = new ArrayList<>();
            if (digits.length() == 0) return ans;
            Map<Character, String> map = new HashMap<Character, String>() {{
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }};

            backtrack(digits, ans, map, new StringBuilder(), 0);

            return ans;

        }

        private void backtrack(String digits, ArrayList<String> ans, Map<Character, String> map, StringBuilder sb, int idx) {
            if (idx == digits.length()) {
                ans.add(sb.toString());
                return;
            }
            String str = map.get(digits.charAt(idx));
            for (int i = 0; i < str.length(); i++) {
                sb.append(str.charAt(i));
                backtrack(digits, ans, map, sb, idx + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

