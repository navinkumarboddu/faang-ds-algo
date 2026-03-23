package org.faang.arrays;

public class FindRotationCount {

    public static void main(String[] args) {
        int[] arr = {15,18,2,3,6,12};
        System.out.println(findPivot(arr));
    }

    private static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(arr[mid] > arr[mid + 1]){
                return mid;
            }
            if(arr[mid] < arr[mid - 1]){
                return mid;
            }
        }

        return -1;
    }
}
