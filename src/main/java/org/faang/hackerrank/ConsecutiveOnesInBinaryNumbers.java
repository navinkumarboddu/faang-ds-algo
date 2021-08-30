package org.faang.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * HackerRank Day 10: Binary Numbers
 * Given a base- integer, , convert it to binary (base-). Then find and print the base- integer denoting the maximum number
 * of consecutive 's in 's binary representation.
 * When working with different bases, it is common to show the base as a subscript.
 */

public class ConsecutiveOnesInBinaryNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        int remainder = 0;
        String s = new String();
        while(n > 0){
            remainder = n%2;
            n = n/2;
            s = remainder + s;
        }
        System.out.println(s);
        int count = 0;
        int maxCount = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '1'){
               count = count + 1;
            } else if(s.charAt(i) == '0' ){
                if(count > maxCount){
                    maxCount = count;
                }
                count = 0;
            }
        }
        if(count > maxCount){
            maxCount = count;
        }
        System.out.println(maxCount);
        bufferedReader.close();
    }
}
