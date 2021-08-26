package org.faang.codinginterview;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindSecondLargest {

    public static void main(String[] args) {
        //List<String> list = List.of("aa","bb","cc","dd","cc","aa","cc");

        List<Integer> list = List.of(2,1,2);

        Optional<Map.Entry<Integer, Long>> first = list
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList())
                .stream().skip(1).findFirst();

        if(first.isPresent()) {
            System.out.println(first.get().getKey());
        } else {
            System.out.println(-1);
        }
    }
}
