package org.faang.arrays;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 */
public class FirstLastPosition {

    public static void main(String[] args) {
        //int[] nums = {3,5,7,7,8,8,10};
        int[] nums = {1};
        System.out.println(Arrays.toString(searchRange(nums, 1)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] found = {-1, -1};

        int startIndex = binarySearch(nums, target, true);
        int endIndex = binarySearch(nums, target, false);

        found[0] = startIndex;
        found[1] = endIndex;

        return found;
    }

    public static int binarySearch(int[] nums, int target, boolean findStartIndex) {
        int start = 0;
        int end = nums.length - 1;
        int position = -1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = start + 1;
            } else {
               position = mid;
               if(findStartIndex){
                   end = mid - 1;
               } else {
                   start = mid + 1;
               }
            }
        }

        return position;
    }
}
