package org.faang.arrays;

public class ArrayPractice2D {

    public static void main(String[] args) {
        int[][] matirx = new int[4][4];

        for(int i=0;i< matirx.length;i++){
            for(int j=0; j< matirx[i].length;j++){
                matirx[i][j] = (int) (Math.random() * 10 +1);
            }
        }

        for(int i=0;i< matirx.length;i++){
            for(int j=0; j< matirx[i].length;j++){
                System.out.print("| " + matirx[i][j] + " ");
            }
            System.out.println("|");
        }
    }
}
