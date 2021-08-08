package org.faang.arrays;

import org.faang.util.CommonUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWaterTest {

    @Test
    void calculateMaxAreaTest() {
        int a[] = {7,1,2,3,9};
        CommonUtil.startTimer();
        int maxArea = ContainerWithMostWater.optimalGetMaxArea.apply(a);
        CommonUtil.timeTaken();
        assertEquals(28,maxArea);
    }

    @Test
    void calculateMaxAreaEmptyArray() {
        int a[] = {};
        CommonUtil.startTimer();
        int maxArea = ContainerWithMostWater.optimalGetMaxArea.apply(a);
        CommonUtil.timeTaken();
        assertEquals(0,maxArea);
    }

    @Test
    void calculateMaxAreaSingleElementArray() {
        int a[] = {7};
        CommonUtil.startTimer();
        int maxArea = ContainerWithMostWater.optimalGetMaxArea.apply(a);
        CommonUtil.timeTaken();
        assertEquals(0,maxArea);
    }
}