package leetcode.editor.cn;

//Java: 全排列(permutations)

//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 👍 2340 👎 0

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Permutations{
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        backtrack(ans, list, nums, 0);

        return ans;
    }

        private void backtrack(List<List<Integer>> ans, ArrayList<Integer> list, int[] nums, int idx) {
            if (idx == nums.length) {
                ans.add(new ArrayList<>(list));
                return;
            }

            for (int i = idx; i < nums.length; i++) {
                Collections.swap(list, i , idx);
                backtrack(ans, list, nums, idx + 1);
                Collections.swap(list, i , idx);

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

