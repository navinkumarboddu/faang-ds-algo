package org.faang.sorting;

import java.util.Arrays;

/**
 * You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
 *
 * You are given an integer array nums representing the data status of this set after the error.
 *
 * Find the number that occurs twice and the number that is missing and return them in the form of an array.
 *
 * Example 1:
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * Example 2:
 *
 * Input: nums = [1,1]
 * Output: [1,2]
 */
public class SetMismatch {

    public static void main(String[] args) {
        int[] nums = {1,2,2,4};
        nums = findErrorNums(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    static public int[] findErrorNums(int[] nums) {
        int[] arr = new int[2];
        int i = 0;
        while(i < nums.length){
            int correctIndex = nums[i] - 1;
            if(nums[i] != nums[correctIndex]){
                swap(i,correctIndex,nums);
            } else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j+1){
                arr[0] = nums[j];
                arr[1] = j+1;
                return arr;
            }
        }
        return new int[]{};
    }

    static public void swap(int first, int second, int[] nums){
        // 0 1 nums={1,2,2,4}
        int tmp = nums[first]; //tmp=1
        nums[first] = nums[second]; //{2,2,2,4}
        nums[second] = tmp; //{2,1,2,4}
    }
}
