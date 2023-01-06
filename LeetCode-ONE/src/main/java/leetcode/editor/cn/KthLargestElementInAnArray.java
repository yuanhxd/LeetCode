package leetcode.editor.cn;

//Java: 数组中的第K个最大元素(kth-largest-element-in-an-array)

//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2017 👎 0

import java.util.Random;

class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Random rand = new Random();

        public int findKthLargest(int[] nums, int k) {
            return quickSort(nums, k, 0, nums.length - 1);
        }

        private int quickSort(int[] nums, int k, int left, int right) {
            int index = rand.nextInt(right - left + 1) + left;
            int flag = nums[index];
            nums[index] = nums[left];
            int i = left, j = right;
            while (i < j) {
                while (i < j && nums[j] <= flag) j--;
                nums[i] = nums[j];
                while (i < j && nums[i] >= flag) i++;
                nums[j] = nums[i];
            }
            nums[i] = flag;
            if (i == k - 1) return nums[i];
            else if (i < k - 1) return quickSort(nums, k, i + 1, right);
            else return quickSort(nums, k, left, i - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

