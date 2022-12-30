package leetcode.editor.cn;

//Java: 子集(subsets)

//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯 👍 1883 👎 0

import java.util.ArrayList;
import java.util.List;

class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();

            backtrack(ans, new ArrayList<>(), nums, 0);

            return ans;
        }

        private void backtrack(List<List<Integer>> ans, ArrayList<Integer> list, int[] nums, int idx) {

            if (idx == nums.length) {
                ans.add(new ArrayList<>(list));
                return;
            }

            list.add(nums[idx]);
            backtrack(ans, list, nums, idx + 1);
            list.remove(list.size() - 1);
            backtrack(ans, list, nums, idx + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

