package org.faang.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 448. Find All Numbers Disappeared in an Array
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
 *
 * Example 1:
 *
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 * Example 2:
 *
 * Input: nums = [1,1]
 * Output: [2]
 *
 */
public class FindMissingNumbers {

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> missing = findDisappearedNumbers(nums);
        System.out.println("--------");
        missing.stream().forEach(System.out::println);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missing = new ArrayList<>();
        int i=0;
        while(i<nums.length){
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]){
                swap(i,correct,nums);
            } else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != j+1){
                missing.add(j+1);
            }
        }
        return missing;
    }

    static void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
