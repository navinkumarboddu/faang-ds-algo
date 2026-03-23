package org.faang.search;

public class Sqrt {

    public static void main(String[] args) {
        int num = 8;
        //findSqrt(num);
        double x = 2.3;
        System.out.println(findSqrt(num));
    }

    //num = 4
    //iter 1 start=1 end=4, mid=2,   2 == 4/2
    private static int findSqrt(int x) {
        if (x <= 1) return x;

        int start = 1, end = x;
        int ans = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            System.out.println("Start:" + start);
            System.out.println("End:" + end);
            System.out.println("Mid:" + mid);

            // Avoid overflow
            if (mid <= x / mid) {
                ans = mid;       // possible answer
                start = mid + 1; // try bigger
            } else {
                end = mid - 1;   // go smaller
            }
        }

        return ans;
    }
}
