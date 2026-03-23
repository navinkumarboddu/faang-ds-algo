package org.faang.arrays;

/***
 * Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
 *
 * Return the minimized largest sum of the split.
 *
 * A subarray is a contiguous part of the array.
 *
 *
 * Example 1:
 * Input: nums = [7,2,5,10,8], k = 2
 * Output: 18
 * Explanation: There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
 *
 * Example 2:
 * Input: nums = [1,2,3,4,5], k = 2
 * Output: 9
 * Explanation: There are four ways to split nums into two subarrays.
 * The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 106
 * 1 <= k <= min(50, nums.length)
 */

public class SplitArrayLargestSum {

    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int split = 2;
        System.out.println(splitArray(nums, split));
    }

    public static int splitArray(int[] nums, int k) {
        int low = findMax(nums);     // minimum possible answer
        int high = arraySum(nums);   // maximum possible answer

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                high = mid;  // try smaller max sum
            } else {
                low = mid + 1; // need bigger sum
            }
        }

        return low;
    }

    private static boolean canSplit(int[] nums, int k, int maxSum) {
        int pieces = 1;
        int sum = 0;

        for (int num : nums) {
            if (sum + num > maxSum) {
                pieces++;
                sum = num;
            } else {
                sum += num;
            }
        }

        return pieces <= k;
    }

    public static int findMax(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    public static int arraySum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
