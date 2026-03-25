package org.faang;

public class ArrangingCoins {

    public static void main(String[] args) {
        System.out.println(arrangeCoins(8));
    }

    public static int arrangeCoins(int n) {
        int rows = 0;

        while (n > rows) {
            rows++;
            n -= rows;
        }

        return rows;
    }

    //rows 1  5>0 count=0+1
    //rows 2  5>1 count=1+2
    //rows 3  5>3 count=3+3
}
