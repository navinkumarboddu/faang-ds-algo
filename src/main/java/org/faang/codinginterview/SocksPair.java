package org.faang.codinginterview;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static org.faang.util.CommonUtil.*;

public class SocksPair {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     *
     *
     * There is a large pile of socks that must be paired by color.
     * Given an array of integers representing the color of each sock,
     * determine how many pairs of socks with matching colors there are.
     */

    public static int sockMerchant(List<Integer> ar) {
        // Write your code here
        startTimer();
        List<Integer> integerList = ar
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .map(s -> s.getValue().intValue())
                .collect(toList());

        Integer count = countFunction.apply(integerList);
        timeTaken();
        stopWatch.reset();
        return (int) count;
    }

    public static Function<List<Integer>, Integer> countFunction = (a) -> {
        Integer result = 0;
        for(Integer s : a){
            if(s/2 >= 0) {
                result += s/2;
            }
        }
        return result;
    };
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //int n = Integer.parseInt(bufferedReader.readLine().trim());

        /*List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());*/

        int n = 7;
        List<Integer> ar = List.of(10,20,20,10,10,30,50,10,20);
                //List.of(1,2,1,2,1,3,2);

        int result = sockMerchant(ar);
        System.out.println(result);
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedReader.close();
        //bufferedWriter.close();
    }
}
