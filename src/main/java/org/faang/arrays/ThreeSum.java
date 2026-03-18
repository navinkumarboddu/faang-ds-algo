package org.faang.arrays;

/*
3Sum
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 */

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {

                    if (nums[i] + nums[j] + nums[k] == 0) {

                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet); // avoid duplicates
                        set.add(triplet);
                    }
                }
            }
        }

        result.addAll(set);
        return result;
    }

    public static List<List<Integer>> threeSum1(int[] nums) {
        /*conditions
        i != j, i != k, and j != k
         */
        List<List<Integer>> tripletPair = null;
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            List<Integer> triplet = new ArrayList<>();
            triplet.add(nums[i]);
            if(i+1 < nums.length) {
                triplet.add(nums[i + 1]);
            }
            if(i+2 < nums.length) {
                triplet.add(nums[i + 2]);
            }
            if(triplet.size() > 2){
                if( triplet.get(0) != triplet.get(1)
                        && triplet.get(0) != triplet.get(2)
                        && triplet.get(1) != triplet.get(2)){
                    if(triplet.get(0) + triplet.get(1) + triplet.get(2) == 0) {
                        if(tripletPair == null){
                            tripletPair = new ArrayList<>();
                        }
                        tripletPair.add(triplet);
                    }
                }
            }
            if(count < nums.length){
                int temp = nums[count];
                nums[count] = nums[i];
                nums[i] = temp;
                count++;
            }
        }
        return tripletPair;
    }
}
