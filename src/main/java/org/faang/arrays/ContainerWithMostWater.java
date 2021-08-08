package org.faang.arrays;

import org.faang.util.CommonUtil;

import java.util.function.Function;

import static java.lang.Math.min;

/******
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
 * Find two lines, which, together with the x-axis forms a container, such that the container contains the
 * most water.
 */

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int a[] = {7,1,2,3,9};
        a = new int[]{6,9,3,4,5,8};
        CommonUtil.startTimer();
        int maxArea = optimalGetMaxArea.apply(a);
        CommonUtil.timeTaken();
        System.out.println(maxArea);
    }

    public static Function<int[], Integer> optimalGetMaxArea = (a) -> {
        int maxArea =0;
        int i = 0;
        int j = a.length-1;
        while(i<j){
            int height = Math.min(a[i], a[j]);
            int width = j - i;
            int result = calculateMaxArea(height,width);
            maxArea = Math.max(maxArea,result);
            if(a[i] < a[j]){
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    };

    public static Function<int[], Integer> getMaxArea = (a) -> {
        int maxArea =0;
        for(int i = 0; i< a.length; i++){
            for(int j = i+1; j< a.length; j++){
                int result = calculateMaxArea(min(a[i], a[j]),j-i);
                maxArea = Math.max(result, maxArea);
            }
        }
        return maxArea;
    };

    public static Integer calculateMaxArea(int length, int width){
        return length * width;
    }
}
