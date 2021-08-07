package org.faang.codinginterview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountDistinctPasswordTest {

    CountDistinctPassword countDistinctPassword;

    //Test Case 1:
    //  input1: 2
    //  input2: {abcd,cdab}
    //  “cdab” can be obtained from “abcd” by swapping 0 and 1 elements with 2 and 3 elements respectively. Hence, only 1
    //  distinct password.
    @Test
    void distinctPasswordTest1(){
        String[] input = new String[]{"abcd","cdab"};
        int target = 1;
        assertEquals(target,(CountDistinctPassword.getDistinctPassword(2,input)));
    }

    //Test Case 2:
    // input1: 2
    // input2: {abcd,bcad}
    //“bcad” cannot be obtained from “abcd” under the given conditions. Hence, 2 distinct passwords.
    @Test
    void distinctPasswordTest2(){
        String[] input = new String[]{"abcd","bcad"};
        int target = 2;
        assertEquals(target,(CountDistinctPassword.getDistinctPassword(2,input)));
    }

}