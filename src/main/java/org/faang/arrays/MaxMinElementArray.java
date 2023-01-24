package org.faang.arrays;

/*
    Maximum and minimum of an array using minimum number of comparisons
    Given an array of size N. The task is to find the maximum and the minimum element of the array using the minimum number of comparisons.
    Examples:
        Input: arr[] = {3, 5, 4, 1, 9}
        Output: Minimum element is: 1
                Maximum element is: 9

        Input: arr[] = {22, 14, 8, 17, 35, 3}
        Output:  Minimum element is: 3
                 Maximum element is: 35

 */


public class MaxMinElementArray {

    static class Pair{
        int min;
        int max;
    }

    public static void main(String[] args) {
        int arr[] = {3};
        Pair minmax = findMinMax(arr, arr.length);
        System.out.printf("\nMinimum element is %d", minmax.min);
        System.out.printf("\nMaximum element is %d", minmax.max);

        arr = new int[]{3, 5, 4, 1, 9};
        minmax = findMinMax(arr, arr.length);
        System.out.printf("\nMinimum element is %d", minmax.min);
        System.out.printf("\nMaximum element is %d", minmax.max);

        arr = new int[]{22, 14, 8, 17, 35, 3};
        minmax = findMinMax(arr, arr.length);
        System.out.printf("\nMinimum element is %d", minmax.min);
        System.out.printf("\nMaximum element is %d", minmax.max);
    }

    public static Pair findMinMax(int arr[], int n){
        Pair p = new Pair();
        int i;

        if(n==1){
            p.min=arr[0];
            p.max=arr[0];
        } else {
            if(arr[0]>arr[1]){
                p.min=arr[1];
                p.max=arr[0];
            } else {
                p.min=arr[0];
                p.max=arr[1];
            }

            for(i=2;i<n;i++){
                if(arr[i]>p.max){
                    p.max=arr[i];
                } else if(arr[i]<p.min){
                    p.min = arr[i];
                }
            }
        }

        return p;
    }
}
