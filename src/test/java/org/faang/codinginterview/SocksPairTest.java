package org.faang.codinginterview;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SocksPairTest {

    //Test Case 1:
    //  input1: 10,20,20,10,10,30,50,10,20
    //  result: 3
    @Test
    void sockMerchant() {
        List<Integer> ar = List.of(10,20,20,10,10,30,50,10,20);
        int target = 3;
        assertEquals(target,(SocksPair.sockMerchant(ar)));
    }

    //Test Case 2:
    //  input1: 10,20,20,10,10,30,50,10,20
    //  result: 2
    @Test
    void sockMerchant2() {
        List<Integer> ar = List.of(1,2,1,2,1,3,2);
        int target = 2;
        assertEquals(target,(SocksPair.sockMerchant(ar)));
    }
}