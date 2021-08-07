package org.faang.arrays;

/*
    Arrays  - Question #1  Google Interview Question Two Sum
    Given an array of Integers, return indices of two numbers that add upto to a given target
    Sample Data:
    I/O             ExpectedO/P         Result
    [1,3,7,9,2]  => 11                  [3,4]
    [1,3,7,9,2]  => 25                  null
    []           => 1                   null
    [5]          => 5                   null
    [1,6]        => 7                   [0,1]
*/
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class ArrayFindIndices{

    public static void main(String[] args) {
        int[] a = {1,3,7,9,2};
        int target = 11;
        Integer[] f1 = integerBiConsumer.apply(a,target);
        System.out.println("Result : " + f1);

        System.out.println(integerOptimalConsumer.apply(a, target));
    }

    public static BiFunction<int[], Integer, Integer[]> integerBiConsumer = (a1, target1) -> {
        for (int i = 0; i < a1.length; i++) {
            int numberToFind = target1 - a1[i];
            for (int j = i + 1; j < a1.length; j++) {
                if (numberToFind == a1[j]) {
                    Integer result[] = new Integer[2];
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    };

    public static BiFunction<int[], Integer, Integer[]> integerOptimalConsumer = (a1, target1) -> {
        Map<Integer, Integer> numberToIndicesMap = new HashMap<>();
        for (int i = 0; i < a1.length; i++) {
            if (numberToIndicesMap.get(a1[i]) != null) {
                Integer result[] = new Integer[2];
                result[0] = i;
                result[1] = numberToIndicesMap.get(a1[i]);
                return result;
            } else {
                int numberToFind = target1 - a1[i];
                numberToIndicesMap.put(numberToFind, i);
            }
        }
        return null;
    };
}