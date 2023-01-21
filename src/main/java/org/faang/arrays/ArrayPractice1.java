package org.faang.arrays;

public class ArrayPractice1 {

    public static void main(String[] args) {
        int i[] = new int[10];
        System.out.println(i.length);

        String s[]={"abc","def","ghi","jkl","mno","pqr"};
        System.out.println(s.length);

        //print items in Array
        printItems(s); // using for loop
        printItemsUsingForEach(s); // using for foreach loop

        //delete items from Array, delete "jkl"
        // 1. first let us find removeIndex
        // 2. Try to remove item
        removeItem(s,"jkl");


    }

    private static void removeItem(String[] s, String removeString) {
        int removeIndex = 0;
        for (int c = 0; c< s.length-1; c++) {
            if(s[c].equals(removeString)){
                removeIndex=c;
            }
        }

        String tempArray[] = new String[s.length-1];
        for (int c = 0, k = 0; c< s.length; c++) {
            if(c==removeIndex){
                continue;
            }
            tempArray[k++]= s[c];
        }
        s = tempArray;
        printItemsUsingForEach(s);
    }

    // using for loop
    private static void printItems(String[] s) {
        for (int c = 0; c< s.length-1; c++){
            System.out.println(s[c]);
        }
    }

    // using for foreach loop
    private static void printItemsUsingForEach(String[] s){
        for (String c: s) {
            System.out.println(c);
        }
    }


}
