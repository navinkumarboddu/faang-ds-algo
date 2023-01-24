package org.faang.arrays;

/*
Given an integer array nums, find the subarray with the largest sum, and return its sum.

Example 1:
```
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
```

Example 2:
```
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
```
 */

import java.util.Arrays;

public class MaxSubArray {

    public static void main(String[] args) {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(nums);

    }

    public static int maxSubArray(int[] nums) {
        int size = nums.length;
        int start = 0;
        int end = 0;

        int maxSoFar = nums[0], maxEndingHere = nums[0];

        //[-2,1,-3,4,-1,2,1,-5,4]
        for(int i=1; i< nums.length;i++){
            if(nums[i] > maxEndingHere + nums[i]){
                start = i;
                maxEndingHere = nums[i];
            } else {
                maxEndingHere = maxEndingHere + nums[i];
            }

            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                end = i;
            }
        }
        System.out.println("Found Maximum Subarray between " + Math.min(start, end) + " and " +  end);
        return maxSoFar;
    }
}
