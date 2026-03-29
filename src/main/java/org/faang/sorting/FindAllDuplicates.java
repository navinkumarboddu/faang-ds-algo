package org.faang.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * 442. Find All Duplicates in an Array
 * Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears at most twice, return an array of all the integers that appears twice.
 *
 * You must write an algorithm that runs in O(n) time and uses only constant auxiliary space, excluding the space needed to store the output
 *
 * Example 1:
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [2,3]
 * Example 2:
 *
 * Input: nums = [1,1,2]
 * Output: [1]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: []
 */
public class FindAllDuplicates {

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        findDuplicates(nums).stream().forEach(System.out::println);
        //Arrays.stream(nums).forEach(System.out::println);
    }

    private static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        int i = 0;
        while (i<nums.length){
            int correctIndex = nums[i] - 1;
            if (nums[correctIndex] != nums[i]) {
                swap(i, correctIndex, nums);
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != j+1){
                duplicates.add(nums[j]);
            }
        }
        return duplicates;
    }

    private static void swap(int i, int correctIndex, int[] nums) {
        int tmp = nums[correctIndex];
        nums[correctIndex] = nums[i];
        nums[i] = tmp;
    }


}
