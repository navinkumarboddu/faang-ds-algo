package org.faang.arrays;

import java.util.Arrays;

/*
Write a program to reverse an array or string.

Given an array (or string), the task is to reverse the array/string.

Examples :

Input : arr[] = {1, 2, 3}
Output : arr[] = {3, 2, 1}

Input : arr[] = {4, 5, 1, 2}
Output : arr[] = {2, 1, 5, 4}
 */


public class ReverseArray {

    public static void main(String[] args) {
        int[] a = new int[10];

        for(int i=0;i<a.length-1;i++){
            a[i] = (int) (Math.random() * 10 + 1);
        }
        System.out.println(Arrays.toString(a));

        // Using temp Array
        int[] tempArray = new int[a.length];
        for(int i=a.length-1, j=0;i>=0;i--,j++){
                tempArray[j] = a[i];
        }
        System.out.println(Arrays.toString(tempArray));

        // Without temp Array
        for(int i=0;i<a.length/2;i++){
            int pointer = a.length - i - 1;
            int temp = a[i];
            a[i] = a[pointer];
            a[pointer] = temp;
        }

        System.out.println(Arrays.toString(a));
    }
}
