package leetcode.editor.cn;

//Java: 寻找两个正序数组的中位数(median-of-two-sorted-arrays)

//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
// Related Topics 数组 二分查找 分治 👍 6087 👎 0

class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length ) {
                return findMedianSortedArrays(nums2, nums1);
            }

            int m = nums1.length;
            int n = nums2.length;

            int left = 0, right = m;

            int media1 = 0, media2 = 0;

            while (left <= right) {
                int i = (m + n + 1) / 2;
                int j = (m + n + 1) / 2 - i;

                int num1_t = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
                int num1_i = i == m ? Integer.MAX_VALUE : nums1[i];
                int num2_t = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
                int num2_j = j == m ? Integer.MAX_VALUE : nums2[j];

                if (num1_t <= num2_j) {
                    media1 = Math.max(num1_t, num2_t);
                    media2 = Math.min(num2_j, num1_i);
                    left = i + 1;
                } else {
                    right = i - 1;
                }
            }
            return (m + n) % 2 == 0 ? (media1 + media2) * 0.5 : media1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

