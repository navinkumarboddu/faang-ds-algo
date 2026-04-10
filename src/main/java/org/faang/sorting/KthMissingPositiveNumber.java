package org.faang.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * 1539. Kth Missing Positive Number
 * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
 *
 * Return the kth positive integer that is missing from this array.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [2,3,4,7,11], k = 5
 * Output: 9
 * Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
 * Example 2:
 *
 * Input: arr = [1,2,3,4], k = 2
 * Output: 6
 * Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
 */
public class KthMissingPositiveNumber {

    public static void main(String[] args) {
        int[] arr = {5,6,7,8,9};
        int k = 9;
        System.out.println(findKthPositive(arr, k));
    }

   static public int findKthPositive(int[] nums, int k) {

        int current = 1;     // number we expect
        int missingCount = 0;

       for (int i = 0; i < nums.length; i++) {
           while (current < nums[i]){
               missingCount++;
               if(missingCount == k){
                   return current;
               }
               current++;
           }
           current++;
       }
       return current + k - missingCount - 1;
    }

}
