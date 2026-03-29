package org.faang.sorting;

import java.util.Arrays;

/***
 * 287 Find the Duplicate Number
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and using only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 * Example 3:
 *
 * Input: nums = [3,3,3,3,3]
 * Output: 3
 */
public class FindDuplicateNumber {

    public static void main(String[] args) {
        //int[] nums = {1,3,4,2,2};
        int[] nums = {3,1,3,4,2};
        System.out.println(findDuplicate(nums));
        Arrays.stream(nums).forEach(System.out::println);
    }

    static public int findDuplicate(int[] nums) {
        int i = 0;
        while(i<nums.length){
            if(nums[i] != i+1){
                int correctIndex = nums[i] - 1;
                if(nums[correctIndex] != nums[i]) {
                    swap(correctIndex, i, nums);
                } else {
                    return nums[i];
                }
            } else {
                i++;
            }
        }
        return -1;
    }

    private static void swap(int correctIndex, int i, int[] nums) {
        int tmp = nums[correctIndex];
        nums[correctIndex] = nums[i];
        nums[i] = tmp;
    }
}
