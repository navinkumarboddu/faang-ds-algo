package org.faang;

/***
 * 367. Valid Perfect Square
 * Solved
 * Easy
 * Topics
 * premium lock icon
 * Companies
 * Given a positive integer num, return true if num is a perfect square or false otherwise.
 *
 * A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer with itself.
 *
 * You must not use any built-in library function, such as sqrt.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 16
 * Output: true
 * Explanation: We return true because 4 * 4 = 16 and 4 is an integer.
 * Example 2:
 *
 * Input: num = 14
 * Output: false
 * Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer.
 */
public class ValidPerfectSquare {

    public static void main(String[] args) {
        int num = 2147483647;
        System.out.println(isPerfectSquare(num));

        int x = 144;
        System.out.println(isPerfectSquare(x));
    }

    public static boolean isPerfectSquare(int x) {
        if (x <= 1) return true;

        int start = 1, end = x;
        int ans = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            long square = (long) mid * mid; // ✅ prevent overflow

            if (square > x) {
                end = mid - 1;
            } else if (square < x) {
                start = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
