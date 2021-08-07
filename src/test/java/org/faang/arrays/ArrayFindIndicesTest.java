package org.faang.arrays;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayFindIndicesTest{

    private ArrayFindIndices arrayFindIndices;
    /*
        [1,3,7,9,2]  => 11                  [3,4]
        [1,3,7,9,2]  => 25                  null
        []           => 1                   null
        [5]          => 5                   null
        [1,6]        => 7                   [0,1]
     */

    @Test
    void testArrayFindIndicesTest(){
        int []a = {1,3,7,9,2};
        int target = 11;
        assertEquals(2,(arrayFindIndices.integerOptimalConsumer.apply(a, target).length));
    }

    @Test
    void testArrayFindIndicesNotPresentTest(){
        int []a = {1,3,7,9,2};
        int target = 25;
        Optional<Integer[]> indexArray = Optional.ofNullable(arrayFindIndices.integerOptimalConsumer.apply(a, target));
        assertEquals(false,indexArray.isPresent());
    }

    @Test
    void testArrayFindIndicesEmptyArrayTest(){
        int []a = {};
        int target = 5;
        Optional<Integer[]> indexArray = Optional.ofNullable(arrayFindIndices.integerOptimalConsumer.apply(a, target));
        assertEquals(false,indexArray.isPresent());
    }

    @Test
    void testArrayFindIndicesArrayTest(){
        int []a = {1,6};
        int target = 7;
        Optional<Integer[]> indexArray = Optional.ofNullable(arrayFindIndices.integerOptimalConsumer.apply(a, target));
        assertEquals(true,indexArray.isPresent());
    }
}