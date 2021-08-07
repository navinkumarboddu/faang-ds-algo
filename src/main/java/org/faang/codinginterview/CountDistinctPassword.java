package org.faang.codinginterview;

import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.faang.util.CommonUtil.*;

public class CountDistinctPassword {
    //You have developed an e-commerce website. Many people have created accounts on your website. You have the passwords of
    //all the users. You want to know how many distinct passwords are there in total.

    //Details of a password are as described:

    //Each password is a string of characters from a to z (small letters).

    //Two passwords, say Pass1 and Pass2, are said to be same if Pass2 can be obtained by swapping the i character with the
    //j character in Pass1, where (i+j)%2=0.

    //input1: N, number of users registered
    //input2: an array of Strings containing all the passwords for N users

    //Return T, the total number of distinct passwords present.

    //Test Case 1:
        //  input1: 2
        //  input2: {abcd,cdab}
        //  “cdab” can be obtained from “abcd” by swapping 0 and 1 elements with 2 and 3 elements respectively. Hence, only 1
        //  distinct password.

    //Test Case 2:
        // input1: 2
        // input2: {abcd,bcad}
        //“bcad” cannot be obtained from “abcd” under the given conditions. Hence, 2 distinct passwords.

    public static void main(String[] args) {

        int totalInput;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter no. of elements you want in array:");
        totalInput = scanner.nextInt();
        String[] a = new String[totalInput];
        System.out.println("Enter all the elements:");
        for(int i = 0; i < totalInput; i++)
        {
            a[i] = scanner.next();
        }

        System.out.println(getDistinctPassword(totalInput, a));
    }

    public static long getDistinctPassword(int totalInput, String[] a) {
        long duplicateCount = getDuplicateCount(totalInput, a);
        return totalInput - duplicateCount;
    }

    private static long getDuplicateCount(int totalInput, String[] a) {
        List<String> list = List.of(a);
        startTimer();
        long duplicateCount = list.subList(1, totalInput)
                .stream()
                .map(s1 -> swapVerifyFunction.apply(s1))
                //.peek(System.out::println)
                .collect(Collectors.toList())
                .stream()
                .filter(s -> s.equals(a[0]))
                .count();
        timeTaken();
        return duplicateCount;
    }

    static Function<String, String> swapVerifyFunction = s -> {
        char[] str =  s.toCharArray();
        for(int i=0; i<=str.length-1; i++){
            //for(int j=1;j<str.length;j++) {
                int j = i+(i+2);
                if (j%2 == 0 && j<=str.length) {
                    char temp = str[i];
                    str[i] = str[i+2];
                    str[i+2] = temp;
                }
            //}
        }

        return new String(str);
    };
}