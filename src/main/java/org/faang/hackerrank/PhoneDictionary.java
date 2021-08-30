package org.faang.hackerrank;
import java.util.*;
import java.io.*;

/*
Given  names and phone numbers, assemble a phone book that maps friends' names to their respective phone numbers.
 You will then be given an unknown number of names to query your phone book for. For each  queried, print the
 associated entry from your phone book on a new line in the form name=phoneNumber; if an entry for  is not found, print Not found instead.
 */

public class PhoneDictionary{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<String, Integer> phoneDictionary = new HashMap<>();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            // Write code here
            phoneDictionary.put(name,phone);
        }
        while(in.hasNext()){
            String s = in.next();
            // Write code here
            Optional<Integer> phoneNumber = Optional.ofNullable(phoneDictionary.get(s));
            if(phoneNumber.isPresent()){
                System.out.println(s + "=" + phoneNumber.get());
            } else {
                System.out.println("Not found");
            }
        }
        in.close();
    }
}